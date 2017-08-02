package options.profile;


import controller.SocialNetwork;
import controller.Utilities;
import menu.Action;

public class LogoutAction implements Action{
    Utilities util = new Utilities();
    @Override
    public boolean performAction() {
        if(SocialNetwork.getLoginUserId() != null){
            SocialNetwork.setLoginUserId(null);
        }
        //util.saveAllData();
        
        return false;
    }
}
