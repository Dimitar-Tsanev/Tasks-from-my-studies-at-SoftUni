package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTests {
    private static final String CLIENT_NAME = "Random";
    private static final String BANK_NAME = "Some name";
    private static final int BANK_CAPACITY = 1;
    private static final int NEGATIVE_BANK_CAPACITY = -1;

    private Client client;

    @Before
    public void setUp(){
        this.client = new Client ( CLIENT_NAME );
    }
    @Test (expected = NullPointerException.class)
    public void testCreateBankWithNullNameShouldThrow(){
        Bank bank = new Bank ( null,BANK_CAPACITY );
    }
    @Test (expected = NullPointerException.class)
    public void testCreateBankWithEmptyNameShouldThrow(){
        Bank bank = new Bank ( "",BANK_CAPACITY );
    }
    @Test (expected = NullPointerException.class)
    public void testCreateBankWithBlancNameShouldThrow(){
        Bank bank = new Bank ( "    ",BANK_CAPACITY );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testCreateBankWithNegativeCapacityShouldThrow(){
        Bank bank = new Bank ( BANK_NAME,NEGATIVE_BANK_CAPACITY );
    }
    @Test
    public void testCreateBankShouldCreateBank(){
        Bank bank = new Bank ( BANK_NAME,BANK_CAPACITY );

        Assert.assertEquals ( BANK_NAME,bank.getName () );
        Assert.assertEquals ( BANK_CAPACITY, bank.getCapacity () );
        Assert.assertEquals ( 0, bank.getCount () );
    }
    @Test
    public void testAddShouldAddClientInBank(){
        Bank bank = new Bank ( BANK_NAME,BANK_CAPACITY );

        bank.addClient ( client );

        Assert.assertEquals ( 1, bank.getCount () );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowWithNoCapacity(){
        Bank bank = new Bank ( BANK_NAME,BANK_CAPACITY );

        bank.addClient ( client );
        bank.addClient ( client );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowWhenClientDoseNotExist(){
        Bank bank = new Bank ( BANK_NAME,BANK_CAPACITY );

        bank.removeClient ( CLIENT_NAME );
    }
    @Test
    public void testRemoveShouldRemoveClientFromBank(){
        Bank bank = new Bank ( BANK_NAME,BANK_CAPACITY );

        bank.addClient ( client );
        bank.removeClient ( CLIENT_NAME );

        Assert.assertEquals ( 0, bank.getCount () );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testLoanWithdrawalShouldTrowWhenClientNotInBank(){
        Bank bank = new Bank ( BANK_NAME,BANK_CAPACITY );

        bank.loanWithdrawal ( CLIENT_NAME );
    }
    @Test
    public void testLoanWithdrawalShouldSetClientApproveForLoanToFalse(){
        Bank bank = new Bank ( BANK_NAME,BANK_CAPACITY );

        bank.addClient ( client );
        Client client = bank.loanWithdrawal ( CLIENT_NAME );

        Assert.assertEquals ( 1,bank.getCount () );
        Assert.assertEquals ( this.client,client );
        Assert.assertFalse ( client.isApprovedForLoan () );
    }
}
