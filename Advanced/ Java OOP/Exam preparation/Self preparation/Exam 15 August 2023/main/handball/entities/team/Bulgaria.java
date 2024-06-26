package handball.entities.team;

public class Bulgaria extends BaseTeam{
    private static final int INCREASE_ADVANTAGE = 115;

    public Bulgaria ( String name, String country, int advantage ) {
        super ( name, country, advantage );
    }

    @Override
    public void play () {
        super.setAdvantage ( getAdvantage () + INCREASE_ADVANTAGE );
    }
}
