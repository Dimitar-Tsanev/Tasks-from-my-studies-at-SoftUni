package harpoonDiver.models.diver;

public class OpenWaterDiver extends BaseDiver{
    private static final double STARTING_OXYGEN = 30.00;
    public OpenWaterDiver ( String name ) {
        super ( name, STARTING_OXYGEN);
    }

}
