package options.profile;
import controller.SocialNetwork;
import entity.EntityUtils;
import menu.Action;

public class ProfileDeleteAction implements Action{
    EntityUtils entityUtils = new EntityUtils();
    @Override
    public boolean performAction() {
        if(SocialNetwork.getAllUserAccounts().containsKey(SocialNetwork.getLoginUserId())){
            SocialNetwork.getAllUserAccounts().remove(SocialNetwork.getLoginUserId());
            entityUtils.removeFromFile(SocialNetwork.getLoginUserId(), SocialNetwork.getUserAccountFile());    
        }
        else if(SocialNetwork.getAllOrgAccounts().containsKey(SocialNetwork.getLoginUserId())){
            SocialNetwork.getAllOrgAccounts().remove(SocialNetwork.getLoginUserId());
            entityUtils.removeFromFile(SocialNetwork.getLoginUserId(), SocialNetwork.getOrgAccountFile());
        }
        return false;
    }
}
