package stuntClimb;


import org.junit.Assert;
import org.junit.Test;

public class ClimbingTests {
    private static final int CORRECT_CAPACITY = 3;
    private static final int NEGATIVE_CAPACITY = - 2;
    private static final String CLIMBING_CORRECT_NAME = "Some name";
    private static final String CLIMBER_NAME = "Random";
    private static final String CLIMBER_SECOND_NAME = "RandomAgain";
    private static final double CLIMBER_STRENGTH = 30.00;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    @Test(expected = NullPointerException.class)
    public void testNameShouldNotBeenBLank(){
        Climbing climbing = new Climbing ( "  ",CORRECT_CAPACITY );
    }
    @Test (expected = NullPointerException.class)
    public void testNameShouldNotBeenEmpty(){
        Climbing climbing1 = new Climbing ( "",CORRECT_CAPACITY );
    }
    @Test (expected = NullPointerException.class)
    public void testNameShouldNotBeenNull(){
        Climbing climbing = new Climbing ( null,CORRECT_CAPACITY );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testCapacityShouldNotBeenNegative(){
        Climbing climbing = new Climbing ( CLIMBING_CORRECT_NAME,NEGATIVE_CAPACITY);

    }
    @Test
    public void testClimbingShouldBeenInitializeCorrectly(){
        Climbing climbing = new Climbing ( CLIMBING_CORRECT_NAME, CORRECT_CAPACITY );

        Assert.assertEquals ( CLIMBING_CORRECT_NAME,climbing.getName () );
        Assert.assertEquals ( CORRECT_CAPACITY,climbing.getCapacity () );
        Assert.assertEquals ( ZERO, climbing.getCount () );
    }
    @Test
    public void testAddRockClimberShouldBeenAdded(){
        Climbing climbing = new Climbing ( CLIMBING_CORRECT_NAME, CORRECT_CAPACITY);


        climbing.addRockClimber ( new RockClimber ( CLIMBER_NAME,CLIMBER_STRENGTH ) );
        Assert.assertEquals ( ONE, climbing.getCount () );

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddRockClimberShouldThrowWhenNoCapacity(){
        Climbing climbing = new Climbing ( CLIMBING_CORRECT_NAME, ONE );


        climbing.addRockClimber ( new RockClimber ( CLIMBER_NAME,CLIMBER_STRENGTH ) );
        climbing.addRockClimber ( new RockClimber (  CLIMBER_SECOND_NAME ,CLIMBER_STRENGTH  ) );

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddRockClimberShouldThrowWhenClimberNameExists (){
        Climbing climbing = new Climbing ( CLIMBING_CORRECT_NAME, CORRECT_CAPACITY );

        climbing.addRockClimber ( new RockClimber ( CLIMBER_NAME,CLIMBER_STRENGTH ) );
        climbing.addRockClimber ( new RockClimber ( CLIMBER_NAME,CLIMBER_STRENGTH ) );

    }
    @Test
    public void testRemoveRockClimberShouldRemove(){
        Climbing climbing = new Climbing ( CLIMBING_CORRECT_NAME, CORRECT_CAPACITY );

        climbing.addRockClimber ( new RockClimber ( CLIMBER_NAME,CLIMBER_STRENGTH ) );

        climbing.removeRockClimber ( CLIMBER_NAME );

        Assert.assertEquals ( 0, climbing.getCount () );
    }
    @Test
    public void testRemoveRockClimberShouldNotRemove(){
        Climbing climbing = new Climbing ( CLIMBING_CORRECT_NAME, CORRECT_CAPACITY );

        climbing.addRockClimber ( new RockClimber ( CLIMBER_NAME,CLIMBER_STRENGTH ) );

        climbing.removeRockClimber ( CLIMBER_SECOND_NAME );

        Assert.assertEquals ( ONE, climbing.getCount () );
    }
}
