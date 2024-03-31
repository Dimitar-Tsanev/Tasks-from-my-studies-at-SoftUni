package bank.factories;

import bank.common.ExceptionMessages;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;



public class ClientFactory {
    private ClientFactory () {
    }
    public static Client createClient( String clientType, String clientName, String clientID, double income ){
        switch (clientType){
            case "Student":
                return new Student (clientName,clientID,income );

            case "Adult":
                return new Adult ( clientName,clientID,income );
            default:
                throw new IllegalArgumentException ( ExceptionMessages.INVALID_CLIENT_TYPE );
        }
    }
}
