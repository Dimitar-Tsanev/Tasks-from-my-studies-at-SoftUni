package climbers.models.climber;

public class WallClimber extends BaseClimber{
    private static final double INITIAL_STRENGTH = 90;
    private static final double STRENGTH_DROP_RATE = 30;
    public WallClimber ( String name ) {
        super ( name, INITIAL_STRENGTH);
    }

    @Override
    public void climb () {
        double strengthAfterClimb = this.getStrength () - STRENGTH_DROP_RATE;
        if (strengthAfterClimb < 0 ){
            strengthAfterClimb = 0;

        }
        super.setStrength ( strengthAfterClimb);
    }
}
