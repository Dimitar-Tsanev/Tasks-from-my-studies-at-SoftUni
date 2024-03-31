package bank.entities.bank;

import bank.common.ExceptionMessages;
import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseBank implements Bank{
    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank ( String name, int capacity ) {
        this.setName ( name );
        this.setCapacity ( capacity );
        this.setLoans (  );
        this.setClients (  );

    }

    private void setCapacity ( int capacity ) {
        this.capacity = capacity;
    }

    private void setLoans (  ) {
        this.loans = new ArrayList<> ();
    }

    private void setClients (  ) {
        this.clients = new ArrayList<> ();
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public void setName ( String name ) {
        if (name == null || name.trim ().isEmpty ()){
            throw new IllegalArgumentException ( ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY );
        }
        this.name = name;
    }

    @Override
    public Collection<Client> getClients () {
        return Collections.unmodifiableCollection ( this.clients );
    }

    @Override
    public Collection<Loan> getLoans () {
        return Collections.unmodifiableCollection ( this.loans );
    }

    @Override
    public void addClient ( Client client ) {
        if (this.capacity <= this.clients.size () ){
            throw new IllegalArgumentException ( ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT );
        }
        this.clients.add ( client );
    }

    @Override
    public void removeClient ( Client client ) {
        this.clients.remove ( client );
    }

    @Override
    public void addLoan ( Loan loan ) {
        this.loans.add ( loan );
    }

    @Override
    public int sumOfInterestRates () {
        return this.loans.stream ().mapToInt ( Loan::getInterestRate ).sum ();
    }

    @Override
    public String getStatistics () {
        StringBuilder report = new StringBuilder ();

        report.append ( String.format (
                    "Name: %s, Type: %s",
                    this.getName (),
                    this.getClass ().getSimpleName () ) )
                .append ( System.lineSeparator () );

        String clients = this.clients.isEmpty () ?
                "none" :
                this.clients.stream ()
                        .map ( Client::getName )
                        .collect( Collectors.joining(", "));

        report.append ( String.format ( "Clients: %s", clients ) )
                .append ( System.lineSeparator () );

        report.append ( String.format ( "Loans: %d, Sum of interest rates: %d",
                this.loans.size (),
                this.sumOfInterestRates () ) )
                .append ( System.lineSeparator () );

        return report.toString ();
    }
}
