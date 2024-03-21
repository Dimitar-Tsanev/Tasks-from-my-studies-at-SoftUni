package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final String HERO_NAME = "Some name";
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int EXPECTED_DUMMY_HEALTH = 10;
    private static final int EXPECTED_HERO_EXPERIENCE_AFTER_DUMMY_DIES = 10;
    private static final int EXPECTED_HERO_EXPERIENCE_WILLE_DUMMY_ALIVE = 0;
    private Hero hero;
    private Dummy dummy;
    @Before
    public void setUp(){
        this.hero = new Hero ( HERO_NAME );
        this.dummy = new Dummy ( DUMMY_HEALTH, DUMMY_EXPERIENCE );
    }

    @Test
    public void dummyLosesHealthWhenAttacked(){

        this.hero.attack ( dummy );

        Assert.assertEquals (
                "Wrong dummy health after attacked!",
                EXPECTED_DUMMY_HEALTH,
                dummy.getHealth () );
    }
    @Test(expected = IllegalStateException.class)
    public void deadDummyCanNotBeAttacked(){

        this.hero.attack ( dummy );
        this.hero.attack ( dummy );
        this.hero.attack ( dummy );

    }
    @Test
    public void deadDummyGivesXp(){

        hero.attack ( dummy );
        hero.attack ( dummy );

        Assert.assertEquals (
                "Wrong given experience after dummy dies!",
                EXPECTED_HERO_EXPERIENCE_AFTER_DUMMY_DIES,
                hero.getExperience () );
    }
    @Test
    public void aliveDummyDoNotGivesXp(){

        hero.attack ( dummy );

        Assert.assertEquals (
                "Wrong given experience wille dummy is alive",
                EXPECTED_HERO_EXPERIENCE_WILLE_DUMMY_ALIVE,
                hero.getExperience () );
    }
}
