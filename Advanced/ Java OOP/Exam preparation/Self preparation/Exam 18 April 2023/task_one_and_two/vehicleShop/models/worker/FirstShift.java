package vehicleShop.models.worker;

public class FirstShift extends BaseWorker{
    private static final int STRENGTH = 100;
    private static final int STRENGTH_DROP = 10;
    public FirstShift ( String name ) {
        super ( name, STRENGTH );
    }
    @Override
    protected int getStrengthDrop () {
        return STRENGTH_DROP;
    }
}
