package options.profile;
import controller.SocialNetwork;
import entity.Organization;
import entity.User;
import menu.Action;

public class ProfileViewAction implements Action{
    @Override
    public boolean performAction() {
        if(SocialNetwork.getAllUserAccounts().containsKey(SocialNetwork.getLoginUserId())){
            String id = SocialNetwork.getLoginUserId();
            System.out.println("User Profile");
            System.out.println("User Id: "+id);
            User user = new User();
            user = (User) SocialNetwork.getAllUserAccounts().get(id);
            System.out.println("User Name: "+user.getName() );
            System.out.println("Date Of Birth: "+ user.getDateOfBirth());
            System.out.println("Gender: "+ user.getGender());
            System.out.println("Status: " +user.getStatus());
        }
        else if(SocialNetwork.getAllOrgAccounts().containsKey(SocialNetwork.getLoginUserId())){
            String id = SocialNetwork.getLoginUserId();
            System.out.println("Organization Profile");
            System.out.println("Organization Id: "+id);
            Organization org = new Organization();
            org = (Organization) SocialNetwork.getAllOrgAccounts().get(id);
            System.out.println("Organization Name: "+org.getName());
            System.out.println("Year of Establishment: "+ org.getEstablishmentYear());
            System.out.println("Status: " +org.getStatus());
        }
        return false;
    }
}
