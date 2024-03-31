package bank.factories;

import bank.common.ExceptionMessages;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;

public class LoanFactory {
    private LoanFactory () {
    }
    public static Loan createLoan( String type){
        switch (type){
            case "StudentLoan":
                return new StudentLoan ( );

            case "MortgageLoan":
                return new MortgageLoan (  );
            default:
                throw new IllegalArgumentException ( ExceptionMessages.INVALID_LOAN_TYPE );
        }
    }
}
