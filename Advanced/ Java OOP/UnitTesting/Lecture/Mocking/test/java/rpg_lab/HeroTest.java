package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HeroTest {
    private static final String HERO_NAME = "Some name";
    private static final int TARGET_EXPERIENCE = 10;
    private static final int EXPECTED_HERO_EXPERIENCE = 10;
    private Hero hero;
    private Target target;

    @Before
    public void setUp () {
        Weapon weapon = Mockito.mock ( Weapon.class );
        this.target = Mockito.mock ( Target.class );

        Mockito.when ( target.isDead ( ) ).thenReturn ( true );
        Mockito.when ( target.giveExperience ( ) ).thenReturn ( TARGET_EXPERIENCE );
        Mockito.when ( target.dropLoot ( ) ).thenReturn ( weapon );

        this.hero = new Hero ( HERO_NAME, weapon );
    }

    @Test
    public void heroGainsExperienceWhenTargetDies () {
        hero.attack ( target );

        Assert.assertEquals (
                "Hero gets wrong experience!",
                EXPECTED_HERO_EXPERIENCE,
                hero.getExperience ( ) );
    }

    @Test
    public void heroGainsLootWhenTargetDies () {
        List<Weapon> weapons = new ArrayList<> ();
        for ( Weapon weapon:hero.getInventory () ){
            weapons.add(weapon);
        }
        int inventorySizeBefore = weapons.size ();

        hero.attack ( target );

        List<Weapon> weaponsAfterAttack = new ArrayList<> ();
        for ( Weapon weapon:hero.getInventory () ){
            weaponsAfterAttack.add ( weapon );
        }
        int inventorySizeAfter = weaponsAfterAttack.size ();
        Assert.assertEquals ( inventorySizeBefore + 1, inventorySizeAfter );
    }
}
