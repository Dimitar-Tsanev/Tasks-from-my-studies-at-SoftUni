package BankAccount;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<Integer, BankAccount> bankAccounts = new HashMap<> ();

        String line = scanner.nextLine ();

        while (!"End".equals ( line )){
            String[] commandLine = line.split ( "\\s+" );

            if ("Create".equals ( commandLine[0] )) {
                BankAccount account = new BankAccount ();
                bankAccounts.put ( account.getId (),account );

                System.out.printf ( "Account ID%d created%n", account.getId () );
                
            } else if ( "SetInterest".equals ( commandLine[0]) ) {
                double rate = Double.parseDouble ( commandLine[1]);
                BankAccount.setInterest ( rate );
                
            } else {
                int id = Integer.parseInt ( commandLine[1]);
                if (!bankAccounts.containsKey ( id )){
                    System.out.println ( "Account does not exist");

                    line = scanner.nextLine ( );
                    continue;
                }

                switch (commandLine[0]){
                    case "Deposit":
                        int amount = Integer.parseInt ( commandLine[2] );
                        bankAccounts.get ( id ).deposit ( amount );
                        System.out.printf ( "Deposited %s to ID%d%n", new DecimalFormat ( "#.##" ).format ( amount ), id );
                        break;

                    case "GetInterest":
                        int years = Integer.parseInt ( commandLine[2] );
                        double rate = bankAccounts.get ( id ).getInterestRate ( years );
                        System.out.printf ( "%.2f%n", rate );
                        break;

                }
            }
            line = scanner.nextLine ( );
        }
    }
}
