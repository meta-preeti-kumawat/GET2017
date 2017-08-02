package menu;

public class ActionableMenu extends MenuItem {
    private Action action;
    
    public ActionableMenu(Action action){
        this.action = action;
    }
    
    public void triggerAction() {
        this.action.performAction();
    }
}
