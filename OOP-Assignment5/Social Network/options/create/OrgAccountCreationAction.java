package options.create;
import java.util.Scanner;

import controller.SocialNetwork;
import entity.EntityUtils;
import entity.Organization;
import menu.Action;

public class OrgAccountCreationAction implements Action{
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public boolean performAction() {
        System.out.print("Enter a new account Id (Account Id can be any Name without comma(,)): ");
        String accountId = scanner.nextLine();
        EntityUtils enUtils = new EntityUtils();
        if(!(SocialNetwork.getAllOrgAccounts().containsKey(accountId) || SocialNetwork.getAllUserAccounts().containsKey(accountId))){
            System.out.print("Enter Organization name: ");
            String accountName = scanner.nextLine();
            System.out.print("Enter Establishment Year: ");
            String est = scanner.nextLine();
            System.out.print("Enter a Status Line (anything which represents your organization): ");
            String statusLine = scanner.nextLine();
            
            String data = accountId + "," + accountName + "," + est + "," + statusLine;
            enUtils.createAccount(data, SocialNetwork.getOrgAccountFile());
            Organization entity = new Organization();
            entity.setId(accountId);
            entity.setName(accountName);
            entity.setStatus(statusLine);
            entity.setEstablishmentYear(est);
            SocialNetwork.getAllOrgAccounts().put(accountId, entity);
            System.out.println("Account Created :-)");
            return true;
        }
        else{
            System.out.println("Account already exists with given Id");
            performAction();
        }
        return false;
    }
}
