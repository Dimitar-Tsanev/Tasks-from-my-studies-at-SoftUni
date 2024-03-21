package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {

    @Test
    public void dummyLosesHealthWhenAttacked(){
        Axe axe = new Axe ( 10, 10 );
        Dummy dummy = new Dummy ( 20, 10 );

        axe.attack ( dummy );

        Assert.assertEquals ( 10,dummy.getHealth () );
    }
    @Test(expected = IllegalStateException.class)
    public void deadDummyCanNotBeAttacked(){
        Axe axe = new Axe ( 10, 10 );
        Dummy dummy = new Dummy ( 10, 10 );

        axe.attack ( dummy );
        axe.attack ( dummy );

    }
    @Test
    public void deadDummyGivesXp(){
        Hero hero = new Hero ( "Some name" );
        Dummy dummy = new Dummy ( 10, 10 );

        hero.attack ( dummy );

        Assert.assertEquals ( 10,hero.getExperience () );
    }
    @Test
    public void aliveDummyDoNotGivesXp(){
        Hero hero = new Hero ( "Some name" );
        Dummy dummy = new Dummy ( 20, 10 );

        hero.attack ( dummy );

        Assert.assertEquals ( 0,hero.getExperience () );
    }
}
