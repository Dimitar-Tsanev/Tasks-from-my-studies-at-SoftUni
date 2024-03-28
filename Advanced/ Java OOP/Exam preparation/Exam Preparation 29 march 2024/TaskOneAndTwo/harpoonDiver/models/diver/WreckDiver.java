package harpoonDiver.models.diver;

public class WreckDiver extends BaseDiver{
    private static final double STARTING_OXYGEN = 150.00;
    public WreckDiver ( String name ) {
        super ( name,STARTING_OXYGEN );
    }
}
