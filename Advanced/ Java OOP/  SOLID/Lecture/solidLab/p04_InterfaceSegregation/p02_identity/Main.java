package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.AccessController;
import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.PasswordChanger;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );
        AccessController controller = new AccessControllerImpl ( new AccountRepositoryImpl ( ) );

        String input;

        while (!"end".equals ( input = scanner.nextLine ( ) )) {
            String email;
            String password;
            switch (input) {
                case "register":
                    System.out.println ( "Enter email!" );
                    email = scanner.nextLine ( );

                    System.out.println ( "Enter password" );
                    password = scanner.nextLine ( );
                    try {
                        controller.register ( email, password );

                    } catch (IllegalArgumentException e) {
                        System.out.println ( e.getMessage ( ) );
                    }
                    break;
                case "login":
                    System.out.println ( "Enter email!" );
                    email = scanner.nextLine ( );

                    System.out.println ( "Enter password" );
                    password = scanner.nextLine ( );
                    try {
                        controller.login ( email,password );

                    } catch (IllegalAccessException e) {
                        System.out.println ( e.getMessage () );

                    }catch (NoSuchElementException e ){
                        System.out.println ( "User those not exist" );

                    }
                    break;
                case "change password":
                    System.out.println ( "Enter email!" );
                    email = scanner.nextLine ( );

                    System.out.println ( "Enter old password" );
                    String oldPassword = scanner.nextLine ( );

                    System.out.println ( "Enter new password" );
                    String newPassword = scanner.nextLine ( );
                    try {
                        ((PasswordChanger) controller).changePassword ( email, oldPassword, newPassword );

                    } catch (IllegalArgumentException | IllegalAccessException e){
                        System.out.println ( e.getMessage () );
                    }
                    break;
            }
        }
    }
}
