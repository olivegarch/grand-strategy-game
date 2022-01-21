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
    private boolean moveComplete;
    private int distTotal;
    private int distTraveled;

    public Movement(Army army, Province finishProv) {
        this.army = army;
        this.startProv = army.getLocation();
        this.finishProv = finishProv;
        this.moveComplete = false;
        this.distTraveled = 0;
        this.distTotal = 100; // for now, the default is 100 distance
    }

    /**
     * Handles event updates when day is advanced.
     * Updates movement progression from start to finish
     */
    @Override
    public void advanceDay() {
        // TODO test this out
        if (!this.isComplete()) {
            distTraveled += army.getSpeed();
            System.out.println(army.getName() + " marched " + army.getSpeed() + " miles today from " +
                    startProv.getName() + " to " + finishProv.getName());
            if (distTraveled >= distTotal) { // movement complete
                System.out.println(army.getName() + " arrived at " + finishProv.getName());
                army.setLocation(finishProv);
                moveComplete = true;
            }
        } else {
            System.out.println("Movement to " + finishProv.getName() + " complete!");
        }
    }

    /**
     * Returns if the event is complete or not
     * @return True if complete, False otherwise
     */
    @Override
    public boolean isComplete() {
        return this.moveComplete;
    }
}