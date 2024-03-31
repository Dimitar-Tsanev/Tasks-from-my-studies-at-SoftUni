package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.factories.BankFactory;
import bank.factories.ClientFactory;
import bank.factories.LoanFactory;
import bank.repositories.LoanRepository;
import bank.repositories.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private Repository loans;
    private Collection<Bank> banks;

    @Override
    public String addBank ( String type, String name ) {
        if ( this.banks == null ) {
            this.banks = new ArrayList<> ( );
        }
        banks.add ( BankFactory.createBank ( type, name ) );
        return String.format ( ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type );
    }

    @Override
    public String addLoan ( String type ) {
        if ( this.loans == null ) {
            this.loans = new LoanRepository ( );
        }
        this.loans.addLoan ( LoanFactory.createLoan ( type ) );

        return String.format ( ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type );
    }

    @Override
    public String returnedLoan ( String bankName, String loanType ) {
        Bank bank = getBank ( bankName );
        Loan loan = loans.findFirst ( loanType );

        if ( loan == null ) {
            throw new IllegalArgumentException ( String.format ( ExceptionMessages.NO_LOAN_FOUND, loanType ) );
        }

        this.loans.removeLoan ( loan );
        bank.addLoan ( loan );

        return String.format ( ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName );
    }

    @Override
    public String addClient ( String bankName, String clientType, String clientName, String clientID, double income ) {
        Client client = ClientFactory.createClient ( clientType, clientName, clientID, income );
        Bank bank = getBank ( bankName );

        boolean isStudentBranchBank = client instanceof Student && bank instanceof BranchBank;
        boolean isAdultCentralBank = client instanceof Adult && bank instanceof CentralBank;

        if ( isAdultCentralBank || isStudentBranchBank ) {
            bank.addClient ( client );
            return String.format ( ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName );

        } else {

            return ConstantMessages.UNSUITABLE_BANK;
        }
    }

    @Override
    public String finalCalculation ( String bankName ) {
        Bank bank = getBank ( bankName );

        double loansFunds = bank.getLoans ( ).stream ( )
                .mapToDouble ( Loan::getAmount )
                .sum ( );

        double clientsFunds = bank.getClients ( ).stream ( )
                .mapToDouble ( Client::getIncome )
                .sum ( );

        return String.format ( ConstantMessages.FUNDS_BANK, bankName, clientsFunds + loansFunds );
    }

    @Override
    public String getStatistics () {
        StringBuilder report = new StringBuilder ( );
        banks.forEach ( b -> report.append ( b.getStatistics ( ) ) );
        return report.toString ( );
    }

    private Bank getBank ( String bankName ) {
        return this.banks.stream ( )
                .filter ( b -> b.getName ( ).equals ( bankName ) )
                .findAny ( )
                .get ( );
    }
}
