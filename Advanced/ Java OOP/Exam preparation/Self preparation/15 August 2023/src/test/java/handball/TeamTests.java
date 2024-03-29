package handball;

import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;

public class TeamTests {

    public static final String UNUSED_NAME = "some";
    private static final String TEAM_NAME = "Random";
    private static final int CORRECT_POSITIONS = 2;
    private static final int NEGATIVE_POSITIONS = -1;

    private static final String PLAYER_NAME = "Some Name";

    private HandballPlayer player;
    @Before
    public void setUp(){
        player = new HandballPlayer ( PLAYER_NAME );
    }

    @Test (expected = NullPointerException.class)
    public void testCreateTeamWithNullNameShouldThrow(){
        Team team = new Team ( null, CORRECT_POSITIONS );
    }
    @Test (expected = NullPointerException.class)
    public void testCreateTeamWithBlankNameShouldThrow(){
        Team team = new Team ( "    ", CORRECT_POSITIONS );
    }
    @Test (expected = NullPointerException.class)
    public void testCreateTeamWithEmptyNameShouldThrow(){
        Team team = new Team ( "", CORRECT_POSITIONS );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testCreateTeamWithNegativePositionsShouldThrow(){
        Team team = new Team ( TEAM_NAME, NEGATIVE_POSITIONS );
    }
    @Test
    public void testCreateTeamShouldCreateTeam(){
        Team team = new Team ( TEAM_NAME, CORRECT_POSITIONS );

        Assert.assertEquals ( TEAM_NAME,team.getName () );
        Assert.assertEquals ( CORRECT_POSITIONS, team.getPosition () );
        Assert.assertEquals ( 0,team.getCount () );
    }
    @Test
    public void testAddShouldSuccessfullyAddPlayer(){
        Team team = new Team ( TEAM_NAME, CORRECT_POSITIONS );

        team.add ( player );
        Assert.assertEquals ( 1,team.getCount () );
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenTeamIsFull(){
        Team team = new Team ( TEAM_NAME, CORRECT_POSITIONS );

        team.add ( player );
        team.add ( player );
        team.add ( player );
    }
    @Test
    public void testRemoveShouldSuccessfullyRemovePlayer(){
        Team team = new Team ( TEAM_NAME, CORRECT_POSITIONS );

        team.add ( player );

        team.remove ( PLAYER_NAME );

        Assert.assertEquals ( 0,team.getCount () );
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowWhenNameIsNotInTeam(){
        Team team = new Team ( TEAM_NAME, CORRECT_POSITIONS );

        team.add ( player );
        team.remove ( UNUSED_NAME );

    }
    @Test
    public void testPlayerForAnotherTeamShouldReturnPlayer(){
        Team team = new Team ( TEAM_NAME, CORRECT_POSITIONS );

        team.add ( player );
        HandballPlayer playerReturn = team.playerForAnotherTeam ( PLAYER_NAME );

        Assert.assertEquals ( player,playerReturn );
        Assert.assertFalse ( player.isActive () );
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamShouldThrowWhenPlayerIsNotInTeam(){
        Team team = new Team ( TEAM_NAME, CORRECT_POSITIONS );

        team.add ( player );
        HandballPlayer playerReturn = team.playerForAnotherTeam ( UNUSED_NAME );
    }
    @Test
    public void testGetStatisticsShouldReturnCorrectStatistic(){
        Team team = new Team ( TEAM_NAME, CORRECT_POSITIONS );

        team.add ( player );
        team.add ( new HandballPlayer ( UNUSED_NAME ) );

        String names = PLAYER_NAME + ", " + UNUSED_NAME;
        String report = String.format("The player %s is in the team %s.", names, team.getName ());
        Assert.assertEquals ( report, team.getStatistics () );
    }

}
