package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import entity.Entity;
import entity.Organization;
import entity.User;
import graph.Graph;
import options.Exit;
import options.connections.ConnectionAddAction;
import options.connections.ConnectionRemoveAction;
import options.connections.ConnectionViewAction;
import options.create.OrgAccountCreationAction;
import options.create.UserAccountCreationAction;
import options.login.LoginAsOrg;
import options.login.LoginAsUser;
import options.profile.LogoutAction;
import options.profile.ProfileDeleteAction;
import options.profile.ProfileViewAction;
import options.profile.SearchAction;
import menu.ActionableMenu;
import menu.ActionableMenuWithSubMenu;
import menu.Menu;
import menu.MenuItem;

public class SocialNetwork {
    private static String userAccountFile;
    private static String orgAccountFile;
    private static String postFile;
    private static String connectionFile;
    private ArrayList<String> listOfPaths;
    private static Entity userAccount = new User();
    private static Entity orgAccount = new Organization();  
    private static Map<String, Entity> allUserAccounts = new HashMap<String, Entity>();
    private static Map<String, Entity> allOrgAccounts = new HashMap<String, Entity>();
    private static String loginUserId;
    private static Graph graph = new Graph();
    
    public static void checkFiles() {
        userAccountFile = "src/DataFiles/user_account.csv";
        orgAccountFile = "src/DataFiles/org_account.csv";
        postFile = "src/DataFiles/posts.csv";
        connectionFile = "src/DataFiles/connections.csv";
        ArrayList<String> listOfPaths = new ArrayList<String>();
        listOfPaths.add(userAccountFile);
        listOfPaths.add(orgAccountFile);
        listOfPaths.add(postFile);
        listOfPaths.add(connectionFile);
        
        try {
            Utilities.checkAndCreateFile(listOfPaths);
        } catch (IOException e) {
            System.out.println("Some Error occured in IO operations");
        }
        
        //get all accounts 
        Utilities utility = new Utilities();
        allUserAccounts = utility.getAllData(listOfPaths.get(0), userAccount);
        allOrgAccounts = utility.getAllData(listOfPaths.get(1), orgAccount);
        setGraph(utility.getAllConnections(connectionFile));
    }
    
    public static Map<String, Entity> getAllUserAccounts() {
        return allUserAccounts;
    }

    public static Map<String, Entity> getAllOrgAccounts() {
        return allOrgAccounts;
    }
    
    /**
     * Displays menu
     * @param menu
     */
    public static void displayMenu(Menu menu){
        int count = 1;
        for (Iterator<MenuItem> iterator = menu.getSubMenu().iterator(); iterator.hasNext();) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(count++ +". "+menuItem.getDispayName());
        }
    }
    
    /**
     * create a menu list
     * @return Menu
     */
    public static Menu createMenu(){
        //main menu
        Menu mainMenu = new Menu();
            //item 1 of main menu
            Menu createAccount = new Menu();
                //item 1 of create account menu
                MenuItem userAccount = new ActionableMenu(new UserAccountCreationAction());
                userAccount.setDispayName("As a User");
                createAccount.getSubMenu().add(userAccount);

                //item 2 of create account menu
                MenuItem orgAccount = new ActionableMenu(new OrgAccountCreationAction());
                orgAccount.setDispayName("As an Organization");
                createAccount.getSubMenu().add(orgAccount);

                //item 3 of create account menu
                Menu createSubMenuBack = new Menu();
                createSubMenuBack.setParentMenu(mainMenu);
                createSubMenuBack.setDispayName("Back");
                createAccount.getSubMenu().add(createSubMenuBack);

                //item 4 of create account menu
                MenuItem createSubMenuExit = new ActionableMenu(new Exit());
                createSubMenuExit.setDispayName("Exit");
                createAccount.getSubMenu().add(createSubMenuExit);
                
            createAccount.setDispayName("Create Account");
            mainMenu.getSubMenu().add(createAccount);
            
            //item 2 of main menu
            Menu login = new Menu();

                //item 1 of login menu
                ActionableMenuWithSubMenu userLogin = new ActionableMenuWithSubMenu(new LoginAsUser());
                userLogin.setDispayName("As a User");
                login.getSubMenu().add(userLogin);
                       
                //item 2 of login menu
                ActionableMenuWithSubMenu orgLogin = new ActionableMenuWithSubMenu(new LoginAsOrg());
                orgLogin.setDispayName("As an Organization");
                login.getSubMenu().add(orgLogin);
                
                      //sub menu 1 after login
                    Menu profile = new Menu();
                    profile.setDispayName("Profile");
                    
                        //profile sub menu item 1
                        MenuItem viewProfile = new ActionableMenu(new ProfileViewAction());
                        viewProfile.setDispayName("View Profile");
                        profile.getSubMenu().add(viewProfile);

                        //profile sub menu item 2
                        ActionableMenuWithSubMenu deleteProfile = new ActionableMenuWithSubMenu(new ProfileDeleteAction());
                        deleteProfile.setDispayName("Delete Profile");
                        deleteProfile.setParentMenu(mainMenu);
                        profile.getSubMenu().add(deleteProfile);

                        //profile sub menu item 3
                        Menu profileSubMenuBack = new Menu();
                        profileSubMenuBack.setParentMenu(userLogin);
                        profileSubMenuBack.setDispayName("Back");
                        profile.getSubMenu().add(profileSubMenuBack);
                        
                        //profile sub menu item 4
                        ActionableMenuWithSubMenu logoutProfile = new ActionableMenuWithSubMenu(new LogoutAction());
                        logoutProfile.setDispayName("Logout");
                        logoutProfile.setParentMenu(mainMenu);
                        profile.getSubMenu().add(logoutProfile);
                        
                    userLogin.getSubMenu().add(profile);
                    orgLogin.getSubMenu().add(profile);
                    
                    //sub menu 2 after login
                    Menu connections = new Menu();
                    connections.setDispayName("Connections");
                        
                        //connection sub menu item 1
                        MenuItem viewConnection = new ActionableMenu(new ConnectionViewAction());
                        viewConnection.setDispayName("View Connections");
                        connections.getSubMenu().add(viewConnection);

                        //connection sub menu item 2
                        MenuItem addConnection = new ActionableMenu(new ConnectionAddAction());
                        addConnection.setDispayName("Add Connections");
                        connections.getSubMenu().add(addConnection);
    
                        //connection sub menu item 3
                        ActionableMenu removeConnection = new ActionableMenu(new ConnectionRemoveAction());
                        removeConnection.setDispayName("Remove Connections");
                        connections.getSubMenu().add(removeConnection);

                        //profile sub menu item 3
                        Menu connSubMenuBack = new Menu();
                        connSubMenuBack.setParentMenu(userLogin);
                        connSubMenuBack.setDispayName("Back");
                        connections.getSubMenu().add(connSubMenuBack);
                        
                        //connection sub menu item 4
                        ActionableMenuWithSubMenu logoutConnection = new ActionableMenuWithSubMenu(new LogoutAction());
                        logoutConnection.setDispayName("Logout");
                        logoutConnection.setParentMenu(mainMenu);
                        connections.getSubMenu().add(logoutConnection);
                    
                    userLogin.getSubMenu().add(connections);
                    orgLogin.getSubMenu().add(connections);
                    
                    //sub menu 3 after login
                    MenuItem search = new ActionableMenu(new SearchAction());
                    search.setDispayName("Search");
                    userLogin.getSubMenu().add(search);
                    orgLogin.getSubMenu().add(search);
                    
                    //sub menu 4 after login
                    Menu postMenu = new Menu();
                    postMenu.setDispayName("Posts");
                    
                        //connection sub menu item 1
                        MenuItem viewPosts = new ActionableMenu(new ConnectionViewAction());
                        viewPosts.setDispayName("View Posts");
                        postMenu.getSubMenu().add(viewPosts);
    
                        //connection sub menu item 2
                        MenuItem addPost = new ActionableMenu(new ConnectionAddAction());
                        addPost.setDispayName("Add Posts");
                        postMenu.getSubMenu().add(addPost);
    
                        //connection sub menu item 3
                        ActionableMenu removePost = new ActionableMenu(new ConnectionRemoveAction());
                        removePost.setDispayName("Remove Posts");
                        postMenu.getSubMenu().add(removePost);
    
                        //profile sub menu item 3
                        Menu postSubMenuBack = new Menu();
                        postSubMenuBack.setParentMenu(userLogin);
                        postSubMenuBack.setDispayName("Back");
                        postMenu.getSubMenu().add(postSubMenuBack);
                        
                        //connection sub menu item 4
                        ActionableMenuWithSubMenu logoutPost = new ActionableMenuWithSubMenu(new LogoutAction());
                        logoutPost.setDispayName("Logout");
                        logoutPost.setParentMenu(mainMenu);
                        postMenu.getSubMenu().add(logoutPost);
                    
                    userLogin.getSubMenu().add(postMenu);
                    orgLogin.getSubMenu().add(postMenu);
                    
                    //sub menu 5 after login
                    ActionableMenuWithSubMenu logout = new ActionableMenuWithSubMenu(new LogoutAction());
                    logout.setDispayName("Logout");
                    logout.setParentMenu(mainMenu);
                    userLogin.getSubMenu().add(logout);
                    orgLogin.getSubMenu().add(logout);
                    
                //item 3 of login menu
                Menu loginSubMenuBack = new Menu();
                loginSubMenuBack.setParentMenu(mainMenu);
                loginSubMenuBack.setDispayName("Back");
                login.getSubMenu().add(loginSubMenuBack);

                //item 4 of login menu
                MenuItem loginSubMenuExit = new ActionableMenu(new Exit());
                loginSubMenuExit.setDispayName("Exit");
                login.getSubMenu().add(loginSubMenuExit);
            
            login.setDispayName("Login");
            mainMenu.getSubMenu().add(login);
                
            // item 3 or main menu
            MenuItem menuExit = new ActionableMenu(new Exit());
            menuExit.setDispayName("Exit");
            mainMenu.getSubMenu().add(menuExit);
            
        return mainMenu;
    }
    
    public static String getPostFile() {
        return postFile;
    }

    public static void setPostFile(String postFile) {
        SocialNetwork.postFile = postFile;
    }

    public static String getConnectionFile() {
        return connectionFile;
    }

    public static void setConnectionFile(String connectionFile) {
        SocialNetwork.connectionFile = connectionFile;
    }

    /**
     * perform actions according to choice
     * @param menu
     */
    public static void displayAndPerformAction(Menu menu){
        System.out.println("------------------------");
        displayMenu(menu);
        System.out.println("------------------------");
        System.out.print("Enter your Choice: ");
        
        int choice = menu.getInput();
        MenuItem menuItem = menu.getSelection(choice);
        
        if(menuItem == null){
            System.out.println("\nInvalid Choice. ");
            displayAndPerformAction(menu);
        }
        else if(menuItem instanceof ActionableMenu){
            ((ActionableMenu) menuItem).triggerAction();
            displayAndPerformAction(menu);
        }
        else if(menuItem instanceof ActionableMenuWithSubMenu){
            if(((ActionableMenuWithSubMenu) menuItem).triggerAction()){
                displayAndPerformAction((Menu)menuItem);
            }
            else if(((Menu)menuItem).isParentSet()){
                displayAndPerformAction(((Menu)menuItem).getParentMenu());
            }
            else{
                displayAndPerformAction(menu);
            }
        }
        else if(((Menu)menuItem).isParentSet()){
            displayAndPerformAction(((Menu)menuItem).getParentMenu());
        }
        
        else{
            displayAndPerformAction((Menu)menuItem);
        }
        
        
    }
    
    public static void main(String[] args) {
        checkFiles();
        Menu menu = createMenu();
        displayAndPerformAction(menu);
    }

    public static String getUserAccountFile() {
        // TODO Auto-generated method stub
        return userAccountFile;
    }

    public static String getOrgAccountFile() {
        // TODO Auto-generated method stub
        return orgAccountFile;
    }

    public ArrayList<String> getListOfPaths() {
        return listOfPaths;
    }

    public void setListOfPaths(ArrayList<String> listOfPaths) {
        this.listOfPaths = listOfPaths;
    }

    public static String getLoginUserId() {
        return loginUserId;
    }

    public static void setLoginUserId(String loginUserId) {
        SocialNetwork.loginUserId = loginUserId;
    }

    public static Graph getGraph() {
        return graph;
    }

    public static void setGraph(Graph graph) {
        SocialNetwork.graph = graph;
    }
}
