package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class CarShopTests {
    private static final String NULL_EXCEPTION_MESSAGE = "Car cannot be null.";
    private static final String CAR_MODEL_ONE = "random";
    private static final String CAR_MODEL_TWO = "some";
    private static final double HIGHEST_PRICE = 50_000.00;
    private static final double PRICE = 20_000.00;
    private static final int HIGHEST_HORSE_POWER = 200;
    private static final int HORSE_POWER = 100;
    private Car bestCar;
    private Car car;
    private CarShop shop;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void setUp(){
        bestCar = new Car ( CAR_MODEL_ONE, HIGHEST_HORSE_POWER, HIGHEST_PRICE );
        car = new Car ( CAR_MODEL_TWO, HORSE_POWER,PRICE );

        shop = new CarShop ();
    }
    @Test
    public void testConstructorShouldSuccessfullyCreate(){
        Assert.assertEquals ( 0,shop.getCount () );

    }
    @Test
    public void testAddShouldAddInCollection(){
        shop.add ( car );
        shop.add ( bestCar );

        Assert.assertEquals ( 2, shop.getCount () );
    }
    @Test
    public void testAddShouldThrowWhenAddingNull(){
        expected.expect(NullPointerException.class);
        expected.expectMessage(NULL_EXCEPTION_MESSAGE);

        shop.add ( null );
    }

    @Test
    public void testRemoveShouldRemove(){
        shop.add ( car );

        shop.remove ( car );

        Assert.assertEquals ( 0, shop.getCount () );
    }
    @Test
    public void testRemoveShouldNotRemove(){
        shop.add ( car );

        shop.remove ( bestCar );

        Assert.assertEquals ( 1, shop.getCount () );
    }
    @Test
    public void testGetCarShouldReturnAllCars(){
        shop.add ( car );
        shop.add ( bestCar );

        List<Car> cars = shop.getCars ();

        Assert.assertEquals ( cars.size (), shop.getCount () );
        Assert.assertEquals ( car, cars.get ( 0 ) );
        Assert.assertEquals ( bestCar,cars.get ( 1 ) );
    }
    @Test
    public void testGetCarShouldThrowWhenModified(){
        shop.add ( car );

        expected.expect ( UnsupportedOperationException.class );

        shop.getCars ().add ( bestCar );
    }
    @Test
    public void testFindAllCarsWithMaxHorsePowerShouldReturnCarsWithMoreThenGivenNumber(){
        shop.add ( car );
        shop.add ( bestCar );

        List<Car> cars = shop.findAllCarsWithMaxHorsePower ( 50 );
        List<Car> cars2 = shop.findAllCarsWithMaxHorsePower ( 100 );

        cars.forEach ( c-> Assert.assertTrue ( 50 < c.getHorsePower () ) );
        cars2.forEach ( c-> Assert.assertTrue ( 100 < c.getHorsePower () ) );
    }
    @Test
    public void testGetTheMostLuxuryCarShouldReturnMostExpensiveCar(){
        shop.add ( car );
        shop.add ( bestCar );

        Car mostExpensiveCar = shop.getTheMostLuxuryCar ();

        Assert.assertEquals ( HIGHEST_PRICE, mostExpensiveCar.getPrice (), 0.001 );
    }
    @Test
    public void testFindAllCarByModelShouldReturnCarsWithTheGivenModel(){
        shop.add ( car );
        shop.add ( bestCar );
        shop.add ( new Car ( CAR_MODEL_ONE, HORSE_POWER ,PRICE ) );

        List<Car> carsWithModelOne = shop.findAllCarByModel ( CAR_MODEL_ONE );
        List<Car> carsWithModelTwo = shop.findAllCarByModel ( CAR_MODEL_TWO );

        carsWithModelOne.forEach ( c -> Assert.assertEquals ( CAR_MODEL_ONE, c.getModel ( ) ) );
        carsWithModelTwo.forEach ( c -> Assert.assertEquals ( CAR_MODEL_TWO, c.getModel ( ) ) );
    }
}

