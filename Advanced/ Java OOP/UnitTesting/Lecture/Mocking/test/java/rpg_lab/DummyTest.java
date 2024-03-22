package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class DummyTest {
    private static final int ATTACK_POINTS = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int EXPECTED_DUMMY_HEALTH = 10;
    private static final int EXPECTED_EXPERIENCE_AFTER_DUMMY_DIES = 10;
    private static final int EXPECTED_EXPERIENCE_WILLE_DUMMY_ALIVE = 0;
    private Dummy dummy;
    @Before
    public void setUp(){
        WeaponInventory loot = Mockito.mock ( WeaponInventory.class );
        Mockito.when ( loot.dropRandomWeapon ()).thenReturn ( Mockito.mock ( Weapon.class ));

        this.dummy = new Dummy ( DUMMY_HEALTH, DUMMY_EXPERIENCE, loot );
    }

    @Test
    public void dummyLosesHealthWhenAttacked(){

        this.dummy.takeAttack ( ATTACK_POINTS );

        Assert.assertEquals (
                "Wrong dummy health after attacked!",
                EXPECTED_DUMMY_HEALTH,
                dummy.getHealth () );
    }
    @Test(expected = IllegalStateException.class)
    public void deadDummyCanNotBeAttacked(){

        this.dummy.takeAttack ( DUMMY_HEALTH );
        this.dummy.takeAttack ( DUMMY_HEALTH );

    }
    @Test
    public void deadDummyGivesXp(){

        dummy.takeAttack ( DUMMY_HEALTH );

        Assert.assertEquals (
                "Wrong given experience after dummy dies!",
                EXPECTED_EXPERIENCE_AFTER_DUMMY_DIES,
                dummy.giveExperience ());
    }
    @Test (expected = IllegalStateException.class)
    public void aliveDummyDoNotGivesXp(){

        dummy.takeAttack ( ATTACK_POINTS );

        Assert.assertEquals (
                "Wrong given experience wille dummy is alive",
                EXPECTED_EXPERIENCE_WILLE_DUMMY_ALIVE,
                dummy.giveExperience () );
    }
    @Test
    public void deadDummyGivesLoot(){
        dummy.takeAttack ( DUMMY_HEALTH );

        Weapon weapon = dummy.dropLoot ();
    }
    @Test (expected = IllegalStateException.class)
    public void aliveDummyDoNotGivesLoot(){

        dummy.takeAttack ( ATTACK_POINTS );

        Weapon weapon = dummy.dropLoot ();
    }
}
