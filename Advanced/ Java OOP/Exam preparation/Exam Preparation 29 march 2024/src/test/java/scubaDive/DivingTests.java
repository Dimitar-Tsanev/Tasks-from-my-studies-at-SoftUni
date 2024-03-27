package scubaDive;


import org.junit.Assert;
import org.junit.Test;

public class DivingTests {
    private static final String CORRECT_DIVING_NAME = "SomeName";
    private static final int CORRECT_CAPACITY = 2;
    private static final int NEGATIVE_CAPACITY = -2;
    private static final String DIVER_NAME = "Random";
    private static final String SECOND_DIVER_NAME = "RandomAgain";
    private static final double DIVER_OXYGEN = 20.00;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    @Test (expected = NullPointerException.class)
    public void testsNameOfDivingShouldNotBeenBlank(){
        Diving diving = new Diving ( "   ", CORRECT_CAPACITY );
    }
    @Test (expected = NullPointerException.class)
    public void testsNameOfDivingShouldNotBeenEmpty(){
        Diving diving = new Diving ( "", CORRECT_CAPACITY );
    }
    @Test (expected = NullPointerException.class)
    public void testsNameOfDivingShouldNotBeenNull(){
        Diving diving = new Diving ( null, CORRECT_CAPACITY );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testsCapacityOfDivingShouldNotBeenNegative(){
        Diving diving = new Diving ( CORRECT_DIVING_NAME,NEGATIVE_CAPACITY );
    }
    @Test
    public void testsDivingShouldBeenInitialized(){
        Diving diving = new Diving ( CORRECT_DIVING_NAME,CORRECT_CAPACITY );

        Assert.assertEquals ( CORRECT_DIVING_NAME,diving.getName () );
        Assert.assertEquals ( CORRECT_CAPACITY, diving.getCapacity () );
        Assert.assertEquals ( ZERO,diving.getCount () );

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenNameOfDiverExists(){
        Diving diving = new Diving ( CORRECT_DIVING_NAME,CORRECT_CAPACITY);

        diving.addDeepWaterDiver ( new DeepWaterDiver ( DIVER_NAME, DIVER_OXYGEN ) );
        diving.addDeepWaterDiver ( new DeepWaterDiver ( DIVER_NAME, DIVER_OXYGEN ) );

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenNoCapacity(){
        Diving diving = new Diving ( CORRECT_DIVING_NAME,ZERO );

        diving.addDeepWaterDiver ( new DeepWaterDiver ( DIVER_NAME, DIVER_OXYGEN ) );
    }
    @Test
    public void testAddShouldBeeSuccessful (){
        Diving diving = new Diving ( CORRECT_DIVING_NAME,CORRECT_CAPACITY );

        diving.addDeepWaterDiver ( new DeepWaterDiver ( DIVER_NAME, DIVER_OXYGEN ) );

        Assert.assertEquals ( ONE,diving.getCount () );
    }
    @Test
    public void testRemoveShouldBeenSuccessfulReturnTrue(){
        Diving diving = new Diving ( CORRECT_DIVING_NAME,CORRECT_CAPACITY );

        diving.addDeepWaterDiver ( new DeepWaterDiver ( DIVER_NAME, DIVER_OXYGEN ) );

        Assert.assertTrue ( diving.removeDeepWaterDiver ( DIVER_NAME ));
    }
    @Test
    public void testRemoveShouldNotBeenSuccessfulReturnFalse(){
        Diving diving = new Diving ( CORRECT_DIVING_NAME,CORRECT_CAPACITY );

        diving.addDeepWaterDiver ( new DeepWaterDiver ( DIVER_NAME, DIVER_OXYGEN ) );

        Assert.assertFalse ( diving.removeDeepWaterDiver ( SECOND_DIVER_NAME ));
    }
}
