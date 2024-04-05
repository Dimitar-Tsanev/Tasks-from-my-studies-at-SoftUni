package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;


public class GiftFactoryTests {
    private static final String SUCCESFULLY_CREATED_GIFT_STRING = "Successfully added gift %s with magic %.2f.";
    private static final String GIFT_TYPE_ONE = "car";
    private static final String GIFT_TYPE_TWO = "house";
    private static final double MAGIC_NEEDED_ONE = 20.00;
    private static final double MAGIC_NEEDED_TWO = 50.00;

    private Gift giftOne;
    private Gift giftTwo;

    private GiftFactory factory;

    @Before
    public void setUp () {
        this.giftOne = new Gift ( GIFT_TYPE_ONE, MAGIC_NEEDED_ONE );
        this.giftTwo = new Gift ( GIFT_TYPE_TWO, MAGIC_NEEDED_TWO );

        this.factory = new GiftFactory ( );
    }

    @Test
    public void testConstructorShouldInitializeEmptyCollection () {
        Assert.assertEquals ( 0, this.factory.getCount ( ) );
    }

    @Test
    public void testCreateGiftShouldAddGiftInCollection () {
        this.factory.createGift ( this.giftOne );

        Assert.assertEquals ( 1, this.factory.getCount ( ) );
    }

    @Test
    public void testCreateGiftShouldReturnMessageWhenAddGiftSuccessfully () {
        String message = this.factory.createGift ( this.giftOne );

        Assert.assertEquals ( String.format ( SUCCESFULLY_CREATED_GIFT_STRING, GIFT_TYPE_ONE, MAGIC_NEEDED_ONE ), message );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftShouldThrowWhenAddingGiftOfTheSameType () {
        this.factory.createGift ( this.giftOne );

        this.factory.createGift ( new Gift ( GIFT_TYPE_ONE, MAGIC_NEEDED_TWO ) );
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftShouldThrowWhenGivenTypeIsNull () {
        this.factory.removeGift ( null );

    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftShouldThrowWhenGivenTypeIsEmptyString () {
        this.factory.removeGift ( "" );

    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftShouldThrowWhenGivenTypeIsBlank () {
        this.factory.removeGift ( "     " );

    }

    @Test
    public void testRemoveGiftShouldReturnFalseWhenGiftNotInCollection () {
        this.factory.createGift ( this.giftOne );

        boolean isRemoved = this.factory.removeGift ( GIFT_TYPE_TWO );
        Assert.assertFalse ( isRemoved );
    }
    @Test
    public void testRemoveGiftShouldRemoveGift () {
        this.factory.createGift ( this.giftOne );

        boolean isRemoved = this.factory.removeGift ( GIFT_TYPE_ONE );
        Assert.assertEquals ( 0,this.factory.getCount () );
        Assert.assertTrue ( isRemoved );
    }
    @Test
    public void testGetPresentWithLeastMagicReturnNullIfCollectionEmpty(){
        Gift gift = this.factory.getPresentWithLeastMagic ();

        Assert.assertNull ( gift );
    }
    @Test
    public void testGetPresentWithLeastMagicReturnCorrect(){
        this.factory.createGift ( this.giftOne );
        this.factory.createGift ( this.giftTwo );

        Gift gift = this.factory.getPresentWithLeastMagic ();

        Assert.assertEquals ( MAGIC_NEEDED_ONE,gift.getMagic (),0.001 );
    }
    @Test
    public void testGetPresentReturnNullIfNotInCollection(){
        this.factory.createGift ( this.giftOne );

        Gift gift = this.factory.getPresent (GIFT_TYPE_TWO);

        Assert.assertNull ( gift );
    }
    @Test
    public void testGetPresentReturnCorrect(){
        this.factory.createGift ( this.giftOne );
        this.factory.createGift ( this.giftTwo );

        Gift gift = this.factory.getPresent ( GIFT_TYPE_ONE );

        Assert.assertEquals ( GIFT_TYPE_ONE, gift.getType () );
    }
    @Test
    public void testGetPresentShouldReturnCollection(){
       this.factory.createGift ( this.giftOne );
       this.factory.createGift ( this.giftTwo );

        Collection<Gift> gifts = this.factory.getPresents ();

        Assert.assertEquals ( 2, gifts.size () );
        Assert.assertTrue (  gifts.contains ( this.giftOne ));
        Assert.assertTrue (  gifts.contains ( this.giftTwo ));

    }
    @Test (expected = UnsupportedOperationException.class)
    public void testGetPresentShouldThrowWhenModified(){
        this.factory.getPresents ().add ( this.giftOne );

    }
}
