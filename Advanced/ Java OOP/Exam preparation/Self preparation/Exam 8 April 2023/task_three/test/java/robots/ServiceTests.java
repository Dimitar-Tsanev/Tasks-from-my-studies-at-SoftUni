package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
    private static final String ROBOT_NAME = "Random";
    private static final String SERVICE_NAME = "Some name";
    private static final int SERVICE_CAPACITY = 1;
    private static final int NEGATIVE_SERVICE_CAPACITY = -1;

    private Robot robot;

    @Before
    public void setUp(){
        this.robot = new Robot ( ROBOT_NAME );
    }
    @Test(expected = NullPointerException.class)
    public void testCreateServiceWithNullNameShouldThrow(){
        Service service = new Service ( null, SERVICE_CAPACITY );
    }
    @Test (expected = NullPointerException.class)
    public void testCreateServiceWithEmptyNameShouldThrow(){
        Service service = new Service( "", SERVICE_CAPACITY );
    }
    @Test (expected = NullPointerException.class)
    public void testCreateServiceWithBlancNameShouldThrow(){
        Service service = new Service ( "    ", SERVICE_CAPACITY );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testCreateServiceWithNegativeCapacityShouldThrow(){
        Service service = new Service ( SERVICE_NAME, NEGATIVE_SERVICE_CAPACITY );
    }
    @Test
    public void testCreateServiceShouldCreateService(){
        Service service = new Service ( SERVICE_NAME, SERVICE_CAPACITY );

        Assert.assertEquals ( SERVICE_NAME,service.getName () );
        Assert.assertEquals ( SERVICE_CAPACITY, service.getCapacity () );
        Assert.assertEquals ( 0, service.getCount () );
    }
    @Test
    public void testAddShouldAddRobotInService(){
        Service service = new Service ( SERVICE_NAME, SERVICE_CAPACITY );

        service.add( this.robot );

        Assert.assertEquals ( 1, service.getCount () );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowWithNoCapacity(){
        Service service = new Service ( SERVICE_NAME, SERVICE_CAPACITY );

        service.add ( this.robot );
        service.add ( this.robot );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowWhenRobotDoseNotExist(){
        Service service = new Service ( SERVICE_NAME, SERVICE_CAPACITY );

        service.remove ( ROBOT_NAME );
    }
    @Test
    public void testRemoveShouldRemoveRobotFromService(){
        Service service = new Service ( SERVICE_NAME, SERVICE_CAPACITY );

        service.add ( this.robot );
        service.remove ( ROBOT_NAME );

        Assert.assertEquals ( 0, service.getCount () );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testForSaleShouldThrowWhenRobotDoseNotExist(){
        Service service = new Service ( SERVICE_NAME, SERVICE_CAPACITY );

        service.forSale ( ROBOT_NAME );
    }
    @Test
    public void testForSaleShouldSetReadyForSaleToFalse (){
        Service service = new Service ( SERVICE_NAME, SERVICE_CAPACITY );

        service.add ( this.robot );
        Robot robot = service.forSale ( ROBOT_NAME );

        Assert.assertEquals ( 1,service.getCount () );
        Assert.assertEquals ( this.robot,robot);
        Assert.assertFalse ( robot.isReadyForSale () );
    }
}
