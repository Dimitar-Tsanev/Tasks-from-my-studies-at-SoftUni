package bank.entities.client;

public class Student extends BaseClient{
    private static final int INTEREST = 2;
    private static final int INTEREST_INCREASE = 1;
    public Student ( String name, String ID, double income ) {
        super ( name, ID, INTEREST, income );
    }

    @Override
    public void increase () {
        super.setInterest ( getInterest () + INTEREST_INCREASE );
    }
}
