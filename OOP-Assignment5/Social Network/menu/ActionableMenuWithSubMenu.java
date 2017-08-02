package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ActionableMenuWithSubMenu extends Menu {
    private Action action;
    private Menu childMenu;
    private ArrayList<MenuItem> subMenu = new ArrayList<>();
    private Menu parentMenu;
    Scanner scanner = new Scanner(System.in);
    
    public ActionableMenuWithSubMenu(Action action){
        this.action = action;
    }
    
    public boolean triggerAction() {
        if(this.action.performAction()){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public Menu getChild() {
        return this.childMenu;
    }
    
    public void setChild(Menu menu){
        this.childMenu = menu;
    }
    
    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }

    /**
     * Set sub menu within main menu
     * @param subMenu
     */
    public void setSubMenu(ArrayList<MenuItem> subMenu) {
        this.subMenu = subMenu;
       
    }
    
    /**
     * get selected menuItem at given index
     * @param choice
     * @return
     */
    public MenuItem getSelection(int choice){
        if(choice > subMenu.size()){
            return null;
        }
        return subMenu.get(choice-1);
    }
    
    /**
     * set parent menu to back option
     * @param parentMenu
     */
    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Menu getParentMenu() {
        return this.parentMenu;
    }
    
    public boolean isParentSet(){
        if(this.parentMenu != null){
            return true;
        }
        return false;
    }
    
    public int getInput(){
        int choice = subMenu.size() + 1;
        try{
            choice = scanner.nextInt();
        }
        catch(InputMismatchException wronginput){
            scanner.next();
        }
        return choice;
    }

    
}
