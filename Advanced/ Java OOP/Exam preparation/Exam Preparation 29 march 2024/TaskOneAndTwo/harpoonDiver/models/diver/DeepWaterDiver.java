package harpoonDiver.models.diver;

public class DeepWaterDiver extends BaseDiver{
    private static final double STARTING_OXYGEN = 90.00;
    public DeepWaterDiver ( String name) {
        super ( name, STARTING_OXYGEN );
    }
}
