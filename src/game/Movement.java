package game;

import map.Province;
import units.Army;

/**
 * The Movement class
 * Represents a movement an army makes between 2 provinces.
 *
 * @author OliveGarch
 */
public class Movement implements Event{
    private Army army;
    private Province startProv;
    private Province finishProv;


    /**
     * Handles event updates when day is advanced.
     * Updates movement progression from start to finish
     */
    @Override
    public void advanceDay() {

    }
}
