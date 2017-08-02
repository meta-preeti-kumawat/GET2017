package options.create;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controller.SocialNetwork;
import entity.EntityUtils;
import entity.User;
import menu.Action;

public class UserAccountCreationAction implements Action{
    public static User user;
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public boolean performAction() {
        System.out.print("Enter a new account Id (Account Id can be any Name without comma(,)): ");
        String accountId = scanner.nextLine();
        
        EntityUtils enUtils = new EntityUtils();
        if(!(SocialNetwork.getAllUserAccounts().containsKey(accountId) || SocialNetwork.getAllOrgAccounts().containsKey(accountId))){
            System.out.print("Enter your name: ");
            String accountName = scanner.nextLine();
            System.out.print("Enter your Date of Birth(MM/DD/YYYY): ");
            String dateString = scanner.nextLine();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date dob;
            try {
                
                dob = df.parse(dateString);
                Date startDate = df.parse("01/01/1930");
                Date endDate = new Date();
                if(dob.after(startDate) && dob.before(endDate)){
                    System.out.print("Enter your Gender(M for Male/F for Female): ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter a Status Line (anything which represents your nature): ");
                    String statusLine = scanner.nextLine();
                    
                    String data = accountId + "," + accountName + "," + df.format(dob) + "," + gender + "," + statusLine;
                    enUtils.createAccount(data, SocialNetwork.getUserAccountFile());
                    User entity = new User();
                    entity.setId(accountId);
                    entity.setName(accountName);
                    entity.setStatus(statusLine);
                    entity.setDateOfBirth(dob);
                    entity.setGender(gender);
                    System.out.println("Account Created :-)");
                    SocialNetwork.getAllUserAccounts().put(accountId, entity);
                }
                else{
                    System.out.println("Invalid date. Enter valid values.");
                    System.out.println("----------------------------------");
                    performAction();
                }
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
        else{
            System.out.println("Account already exists with given Id");
            performAction();
            return false;
        }
    }
}
