package bank.entities.client;

public class Adult extends BaseClient{
    private static final int INTEREST = 4;
    private static final int INTEREST_INCREASE = 2;

    public Adult ( String name, String ID, double income ) {
        super ( name, ID, INTEREST, income );
    }

    @Override
    public void increase () {
        super.setInterest ( getInterest () + INTEREST_INCREASE );
    }
}
