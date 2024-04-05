package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Map;

public class ToyStoryTest {
    private static final String TOY_MANUFACTURER = "Random";
    private static final String TOY_ID = "D25A3";
    private static final String TOY_SECOND_ID = "D25A32";
    private static final String INVALID_SHELF = "Z";
    private static final String ADD_MESSAGE = "Toy:%s placed successfully!";
    private static final String REMOVE_MESSAGE = "Remove toy:%s successfully!";
    private List<String> shelf;
    private Toy toy;
    private Toy secondToy;
    private ToyStore store;

    @Before
    public void setUp () {
        this.toy = new Toy ( TOY_MANUFACTURER, TOY_ID );
        this.secondToy = new Toy ( TOY_MANUFACTURER, TOY_SECOND_ID );

        this.shelf = List.of ( "A", "B", "C", "D", "E", "F", "G" );
        this.store = new ToyStore ( );

    }

    @Test
    public void testConstructorShouldInitializeCollectionWithShelfs () {
        Map<String, Toy> toyShelfs = this.store.getToyShelf ( );

        int current = 0;

        for ( Map.Entry<String, Toy> shelf : toyShelfs.entrySet ( ) ) {
            String currentShelf = this.shelf.get ( current );

            Assert.assertEquals ( currentShelf, shelf.getKey ( ) );
            Assert.assertNull ( shelf.getValue ( ) );

            current++;
        }

    }

    @Test
    public void addShouldPutToyOnShelf () throws OperationNotSupportedException {
        store.addToy ( shelf.get ( 0 ), this.toy );

        Assert.assertEquals ( this.shelf.get ( 0 ),
                this.store.getToyShelf ( )
                        .entrySet ( )
                        .stream ( )
                        .findFirst ( ).get ( ).getKey ( ) );

        Assert.assertEquals ( this.toy,
                this.store.getToyShelf ( )
                        .entrySet ( )
                        .stream ( )
                        .findFirst ( ).get ( ).getValue ( ) );
    }

    @Test
    public void addShouldReturnStringMessage () throws OperationNotSupportedException {
        String message = store.addToy ( shelf.get ( 0 ), this.toy );

        Assert.assertEquals ( String.format ( ADD_MESSAGE, TOY_ID ), message );
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowWhenShelfInvalid () throws OperationNotSupportedException {
        store.addToy ( INVALID_SHELF, this.toy );

    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowWhenShelfIsTaken () throws OperationNotSupportedException {
        store.addToy ( shelf.get ( 0 ), this.toy );

        store.addToy ( shelf.get ( 0 ), this.secondToy );

    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowWhenToyExist () throws OperationNotSupportedException {
        store.addToy ( shelf.get ( 0 ), this.toy );

        store.addToy ( shelf.get ( 1 ), this.toy );

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeShouldThrowWhenToyDoseNotExist () throws OperationNotSupportedException {
        store.addToy ( shelf.get ( 0 ), this.secondToy );

        store.removeToy ( shelf.get ( 0 ), this.toy );
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeShouldThrowWhenShelfDoseNotExist () throws OperationNotSupportedException {
        store.addToy ( shelf.get ( 0 ), this.toy );

        store.removeToy ( INVALID_SHELF, this.toy );
    }

    @Test
    public void removeShouldRemoveCorrectly () throws OperationNotSupportedException {
        store.addToy ( shelf.get ( 0 ), this.toy );

        store.removeToy ( shelf.get ( 0 ), this.toy );

        Assert.assertEquals ( this.shelf.get ( 0 ),
                this.store.getToyShelf ( )
                        .entrySet ( )
                        .stream ( )
                        .findFirst ( ).get ( ).getKey ( ) );

        Assert.assertNull ( this.store.getToyShelf ( )
                .entrySet ( )
                .stream ( )
                .findFirst ( ).get ( ).getValue ( ) );

    }
    @Test
    public void removeShouldReturnInformation () throws OperationNotSupportedException {
        store.addToy ( shelf.get ( 0 ), this.toy );

        String message =  store.removeToy ( shelf.get ( 0 ), this.toy );;

        Assert.assertEquals ( String.format ( REMOVE_MESSAGE, TOY_ID ), message );

    }
}