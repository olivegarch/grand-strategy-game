package test;

import org.junit.Test;
import units.Army;

/**
 * A test class for Army
 *
 * @author OliveGarch
 */

public class TestArmy {

    @Test
    public void testBattle() {
        Army army1 = new Army("army1");
        Army army2 = new Army("army2");
        army1.battle(army2);
    }


}
