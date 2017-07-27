
import java.util.Iterator;

import Options.Exit;
import Options.MatrixCreation;
import Options.MatrixMultiplication;
import Options.OriginalMatrixShow;
import Options.MatrixTranspose;
import Options.TransposedMatrixShow;
import menu.*;

/**
 * 
 * @author Preeti Kumawat
 * Date: 27-07-2017
 *
 */
public class Controller {
    
    /**
     * Displays menu
     * @param menu
     */
    public static void displayMenu(Menu menu){
        int count = 1;
        System.out.println();
        for (Iterator<MenuItem> iterator = menu.getSubMenu().iterator(); iterator.hasNext();) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(count++ +". "+menuItem.getDispayName());
        }
    }
    
    /**
     * create a menu list
     * @return
     */
    public static Menu createMenu(){
        Menu mainMenu = new Menu();
        
        MenuItem createMatrix = new ActionableMenu(new MatrixCreation());
        createMatrix.setDispayName("Create Matrix");
        mainMenu.getSubMenu().add(createMatrix);
        
        //sub menu
        Menu OperationSubMenu = new Menu();

            MenuItem transposeMatrix = new ActionableMenu(new MatrixTranspose());
            transposeMatrix.setDispayName("Transpose");
            OperationSubMenu.getSubMenu().add(transposeMatrix);

            MenuItem multiplyMatrix = new ActionableMenu(new MatrixMultiplication());
            multiplyMatrix.setDispayName("Multiply with transposed matrix");
            OperationSubMenu.getSubMenu().add(multiplyMatrix);
            
            Menu subMenuBack = new Menu();
            subMenuBack.setParentMenu(mainMenu);
            subMenuBack.setDispayName("Back");
            OperationSubMenu.getSubMenu().add(subMenuBack);

            MenuItem subMenuExit = new ActionableMenu(new Exit());
            subMenuExit.setDispayName("Exit");
            OperationSubMenu.getSubMenu().add(subMenuExit);
            
        OperationSubMenu.setDispayName("Perform Operations");
        mainMenu.getSubMenu().add(OperationSubMenu);
        
        //sub menu
        Menu displayMatrix = new Menu();
        
            MenuItem displayOriginalMatrix = new ActionableMenu(new OriginalMatrixShow());
            displayOriginalMatrix.setDispayName("Display Original Matrix");
            displayMatrix.getSubMenu().add(displayOriginalMatrix);
            
            MenuItem displayTransposedMatrix = new ActionableMenu(new TransposedMatrixShow());
            displayTransposedMatrix.setDispayName("Display Transposed Matrix");
            displayMatrix.getSubMenu().add(displayTransposedMatrix);
            
            Menu displaySubMenuBack = new Menu();
            displaySubMenuBack.setParentMenu(mainMenu);
            displaySubMenuBack.setDispayName("Back");
            displayMatrix.getSubMenu().add(displaySubMenuBack);

            MenuItem displaySubMenuExit = new ActionableMenu(new Exit());
            displaySubMenuExit.setDispayName("Exit");
            displayMatrix.getSubMenu().add(displaySubMenuExit);
        
        displayMatrix.setDispayName("Display Matrix");
        mainMenu.getSubMenu().add(displayMatrix);
        
        MenuItem menuExit = new ActionableMenu(new Exit());
        menuExit.setDispayName("Exit");
        mainMenu.getSubMenu().add(menuExit);
        
        return mainMenu;
    }
    
    /**
     * perform actions according to choice
     * @param menu
     */
    public static void displayAndPerformAction(Menu menu){
        displayMenu(menu);
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
        else if(((Menu)menuItem).isParentSet()){
            displayAndPerformAction(((Menu)menuItem).getParentMenu());
        }
        else{
            displayAndPerformAction((Menu)menuItem);
        }
        
        
    }
    
    public static void main(String[] args) {
        Menu menu = createMenu();
        displayAndPerformAction(menu);
    }
}
