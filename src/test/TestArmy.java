package test;

import map.Province;
import map.Terrain;
import map.Vegetation;
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
        Province southfield = new Province("Southfield");
        Army army1 = new Army("army1", southfield);
        Army army2 = new Army("army2", southfield);
        army1.battle(army2);
    }


}
