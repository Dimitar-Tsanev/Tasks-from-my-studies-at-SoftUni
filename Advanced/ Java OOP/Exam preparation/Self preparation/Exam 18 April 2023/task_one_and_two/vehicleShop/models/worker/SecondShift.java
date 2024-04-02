package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{
    private static final  int STRENGTH = 70;
    private static final int STRENGTH_DROP = 15;
    public SecondShift ( String name ) {
        super ( name, STRENGTH );
    }
    @Override
    protected int getStrengthDrop () {
        return STRENGTH_DROP;
    }

}
