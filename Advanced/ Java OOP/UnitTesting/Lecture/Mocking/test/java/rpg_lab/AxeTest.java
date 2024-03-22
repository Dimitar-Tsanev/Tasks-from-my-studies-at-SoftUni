package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Target target;
    @Before
    public void setUp(){
        this.axe = new Axe ( AXE_ATTACK, AXE_DURABILITY );
        this.target = Mockito.mock ( Target.class );
    }
    @Test
    public void axeLosesDurabilityAfterAttack (){

        this.axe.attack ( target );

        Assert.assertEquals ( EXPECTED_DURABILITY, this.axe.getDurabilityPoints () );
    }

    @Test(expected = IllegalStateException.class)
    public void brokenAxeCantAttack(){

        this.axe.attack ( target );
        this.axe.attack ( target );
    }
}
