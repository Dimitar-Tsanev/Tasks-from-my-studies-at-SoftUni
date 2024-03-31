package bank.entities.loan;

public class MortgageLoan extends BaseLoan{
    private static final int INTEREST_RATE = 3;
    private static final double AMOUNT = 50_000.00;
    public MortgageLoan ( ) {
        super ( INTEREST_RATE, AMOUNT);
    }
}
