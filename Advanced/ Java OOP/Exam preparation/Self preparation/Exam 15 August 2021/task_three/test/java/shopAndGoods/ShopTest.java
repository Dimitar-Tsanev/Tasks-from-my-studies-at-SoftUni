package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Map;

public class ShopTest {
    private static final String GOOD_PLACED_SUCCESSFULLY = "Goods: %s is placed successfully!";
    private static final String GOOD_REMOVE_SUCCESSFULLY = "Goods: %s is removed successfully!";
    public static final String UNEXCITING_SHELVES = "Shelves21";
    private static final String FIRST_GOOD_NAME = "Some";
    private static final String SECOND_GOOD_NAME = "Name";
    private static final String FIRST_GOOD_CODE = "b1545a";
    private static final String SECOND_GOOD_CODE = "b1545b";
    private List<String> shelves;
    private Shop shop;
    private Goods firstGood;
    private Goods secondGood;

    @Before
    public void setUp () {
        this.shelves = List.of ( "Shelves1", "Shelves2", "Shelves3", "Shelves4",
                "Shelves5", "Shelves6", "Shelves7", "Shelves8", "Shelves9", "Shelves10",
                "Shelves11", "Shelves12" );

        this.firstGood = new Goods ( FIRST_GOOD_NAME, FIRST_GOOD_CODE );
        this.secondGood = new Goods ( SECOND_GOOD_NAME, SECOND_GOOD_CODE );

        this.shop = new Shop ( );
    }

    @Test
    public void testGetShelvesShouldReturnShelves () {
        int shelfPosition = 0;
        for ( String shelf : this.shop.getShelves ( ).keySet ( ) ) {
            Assert.assertEquals ( this.shelves.get ( shelfPosition ), shelf );
            shelfPosition++;
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldReturnUnmodifiableCollection () {
        this.shop.getShelves ( ).clear ( );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowWhenShelfDoseNotExist () throws OperationNotSupportedException {
        this.shop.addGoods ( UNEXCITING_SHELVES, this.firstGood );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowWhenShelfTaken () throws OperationNotSupportedException {
        this.shop.addGoods ( this.shelves.get ( 0 ), this.firstGood );
        this.shop.addGoods ( this.shelves.get ( 0 ), this.secondGood );
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsShouldThrowWhenGoodIsOnShelf () throws OperationNotSupportedException {
        this.shop.addGoods ( this.shelves.get ( 0 ), this.firstGood );
        this.shop.addGoods ( this.shelves.get ( 1 ), this.firstGood );
    }
    @Test
    public void testAddGoodsShouldAddGoodOnShelf () throws OperationNotSupportedException {
        this.shop.addGoods ( this.shelves.get ( 0 ), this.firstGood );
        this.shop.addGoods ( this.shelves.get ( 4 ), this.secondGood );

        Assert.assertEquals ( FIRST_GOOD_CODE, this.shop.getShelves ().get ( this.shelves.get ( 0 ) ).getGoodsCode () );
        Assert.assertEquals ( FIRST_GOOD_NAME, this.shop.getShelves ().get ( this.shelves.get ( 0 ) ).getName () );

        Assert.assertEquals ( SECOND_GOOD_CODE, this.shop.getShelves ().get ( this.shelves.get ( 4 ) ).getGoodsCode () );
        Assert.assertEquals ( SECOND_GOOD_NAME, this.shop.getShelves ().get ( this.shelves.get ( 4 ) ).getName () );
    }
    @Test
    public void testAddGoodsShouldReturnMessageWhenGoodIsPlaced () throws OperationNotSupportedException {
        String message = this.shop.addGoods ( this.shelves.get ( 0 ), this.firstGood );

        Assert.assertEquals ( String.format ( GOOD_PLACED_SUCCESSFULLY,FIRST_GOOD_CODE), message );
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowWhenShelfDoseNotExist () throws OperationNotSupportedException {
        this.shop.addGoods ( this.shelves.get ( 0 ), this.firstGood );

        this.shop.removeGoods ( UNEXCITING_SHELVES, this.firstGood );

    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowWhenGoodsOnShelfAreDifferent () throws OperationNotSupportedException {
        this.shop.addGoods ( this.shelves.get ( 1 ), this.firstGood );
        this.shop.addGoods ( this.shelves.get ( 2 ), this.secondGood );

        this.shop.removeGoods ( this.shelves.get ( 1 ),this.secondGood );
    }
    @Test
    public void testRemoveGoodsShouldRemoveGoodFromShelf () throws OperationNotSupportedException {
        this.shop.addGoods ( this.shelves.get ( 0 ), this.firstGood );

        this.shop.removeGoods ( this.shelves.get ( 0 ), this.firstGood );

        Assert.assertNull (  this.shop.getShelves ().get ( this.shelves.get ( 0 ) ) );
    }
    @Test
    public void testRemoveGoodsShouldReturnMessageWhenGoodIsRemoved () throws OperationNotSupportedException {
        this.shop.addGoods ( this.shelves.get ( 0 ), this.firstGood );

        String message = this.shop.removeGoods ( this.shelves.get ( 0 ), this.firstGood );

        Assert.assertEquals ( String.format ( GOOD_REMOVE_SUCCESSFULLY,FIRST_GOOD_CODE), message );
    }
}