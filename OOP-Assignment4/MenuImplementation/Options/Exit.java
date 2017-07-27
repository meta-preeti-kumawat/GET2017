package Options;
import menu.Action;

public class Exit implements Action{
    @Override
    public void performAction() {
        System.exit(1);
    }
}
