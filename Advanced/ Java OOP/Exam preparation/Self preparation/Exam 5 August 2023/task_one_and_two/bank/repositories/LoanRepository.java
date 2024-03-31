package bank.repositories;

import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;

public class LoanRepository implements Repository{
    private Collection<Loan> loans;

    public LoanRepository (  ) {
        this.setLoans ();
    }

    private void setLoans (  ) {
        this.loans = new ArrayList<> ();
    }

    @Override
    public void addLoan ( Loan loan ) {
        this.loans.add ( loan );
    }

    @Override
    public boolean removeLoan ( Loan loan ) {
        return this.loans.remove ( loan );
    }

    @Override
    public Loan findFirst ( String type ) {
        return this.loans.stream ()
                .filter ( c -> c.getClass ()
                                 .getSimpleName ()
                        .equals ( type ) )
                .findFirst ()
                .orElse ( null );
    }
}
