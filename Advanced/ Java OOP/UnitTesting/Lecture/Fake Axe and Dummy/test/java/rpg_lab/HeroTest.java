package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroTest {
    private static final String HERO_NAME = "Some name";
    private static final int WEAPON_ATTACK = 10;
    private static final int TARGET_EXPERIENCE = 10;
    private static final int EXPECTED_HERO_EXPERIENCE = 10;
    private Hero hero;
    private Weapon weapon;
    private Target target;
    @Before
    public void setUp(){
        this.target = new Target ( ) {
            @Override
            public int getHealth () { return 0; }
            @Override
            public void takeAttack ( int attackPoints ) {}
            @Override
            public int giveExperience () { return TARGET_EXPERIENCE; }
            @Override
            public boolean isDead () { return true; }
        };
        this.weapon = new Weapon ( ) {
            @Override
            public int getAttackPoints () { return WEAPON_ATTACK; }

            @Override
            public int getDurabilityPoints () { return 0; }

            @Override
            public void attack ( Target target ) {}
        };
        this.hero = new Hero ( HERO_NAME, this.weapon );
    }
    @Test
    public void heroGainsExperienceWhenTargetDies(){
        hero.attack ( target );

        Assert.assertEquals (
                "Hero gets wrong experience!",
                EXPECTED_HERO_EXPERIENCE,
                hero.getExperience ());
    }
}
