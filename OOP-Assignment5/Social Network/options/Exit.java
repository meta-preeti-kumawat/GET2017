package options;

import controller.Utilities;
import menu.Action;

public class Exit implements Action{
    Utilities util = new Utilities();
    @Override
    public boolean performAction() {
        util.saveAllData();
        System.exit(0);
        return false;
    }
}
