package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    private static final String MANUFACTURER = "None";
    private static final String MODEL = "Random";
    private static final double PRICE = 20.0;
    private Computer computer;
    private ComputerManager manager;

    @Before
    public void setUp(){
        this.computer = new Computer ( MANUFACTURER,MODEL, PRICE );
        this.manager = new ComputerManager ();

    }
    @Test
    public void testConstructorShouldInitializeCollection(){
        Assert.assertEquals ( 0,manager.getCount () );
    }
    @Test
    public void testAddShouldPutComputerInCollection(){
        this.manager.addComputer ( this.computer );

        Assert.assertEquals ( 1,this.manager.getCount () );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddWithNullComputerShouldThrow(){
        this.manager.addComputer ( null );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenAddingTheSameComputer(){
        this.manager.addComputer ( this.computer );
        this.manager.addComputer ( this.computer );
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputersShouldReturnUnmodifiableCollection(){
        this.manager.addComputer ( this.computer );

        this.manager.getComputers ().clear ();
    }
    @Test
    public void testGetComputersShouldReturnCorrectCollection(){
        this.manager.addComputer ( this.computer );

        List<Computer> computers = this.manager.getComputers ( );

        Assert.assertEquals ( computers.get ( 0 ),this.computer );
    }
    @Test
    public void testRemoveShouldRemoveCorrectComputer(){
        this.manager.addComputer ( this.computer );

        Computer computer = this.manager.removeComputer ( MANUFACTURER,MODEL );

        Assert.assertEquals ( 0, this.manager.getCount () );
        Assert.assertEquals ( MANUFACTURER, computer.getManufacturer () );
        Assert.assertEquals ( MODEL,computer.getModel () );
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowIfComputerIsNotInCollection(){
        this.manager.addComputer ( this.computer );

        Computer computer = this.manager.removeComputer ( "Some","model" );

    }
    @Test (expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWithNullManufacturer(){
        this.manager.addComputer ( this.computer );

        Computer computer = this.manager.removeComputer ( null, MODEL );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWithNullModel(){
        this.manager.addComputer ( this.computer );

        Computer computer = this.manager.removeComputer ( MANUFACTURER, null );
    }
    @Test (expected = IllegalArgumentException.class)
    public void testGetByManufacturerShouldThrowWithNull(){
        this.manager.addComputer ( this.computer );

        List <Computer> computer = this.manager.getComputersByManufacturer ( null);
    }
    @Test
    public void testGetByManufacturerShouldReturnRightCollection(){
        this.manager.addComputer ( this.computer );
        this.manager.addComputer ( new Computer ( MANUFACTURER, "some",PRICE ) );
        this.manager.addComputer ( new Computer ( MODEL,MANUFACTURER,PRICE ) );

        List <Computer> computers = this.manager.getComputersByManufacturer ( MANUFACTURER);

        Assert.assertEquals ( 2, computers.size () );
        for ( Computer computer: computers ) {
            Assert.assertEquals (MANUFACTURER, computer.getManufacturer () );
        }
    }
}