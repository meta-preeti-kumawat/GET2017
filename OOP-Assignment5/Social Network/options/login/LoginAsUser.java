package options.login;
import java.util.Scanner;

import controller.SocialNetwork;
import menu.Action;

public class LoginAsUser implements Action{
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public boolean performAction() {
        System.out.println("Enter Account Id");
        String accountId = scanner.nextLine();
        if(SocialNetwork.getAllUserAccounts().containsKey(accountId)){
            SocialNetwork.setLoginUserId(accountId);
            System.out.println("Hello, "+ SocialNetwork.getAllUserAccounts().get(accountId).getName().toUpperCase());
            return true;
        }
        else{
            System.out.println("No User available with such Id");
            return false;
        }
    }
}
