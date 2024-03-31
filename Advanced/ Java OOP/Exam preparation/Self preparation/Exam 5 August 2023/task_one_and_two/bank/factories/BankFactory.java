package bank.factories;

import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;

public class BankFactory {
    private BankFactory () {
    }
    public static Bank createBank(String type, String name){
        switch (type){
            case "CentralBank":
                return new CentralBank ( name );

            case "BranchBank":
                return new BranchBank ( name );
            default:
                throw new NullPointerException ( ExceptionMessages.INVALID_BANK_TYPE );
        }
    }
}
