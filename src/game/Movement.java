package game;

import map.Province;
import units.Army;

/**
 * The Movement class
 * Represents a movement an army makes between 2 provinces.
 *
 * @author OliveGarch
 */
public class Movement extends Event{
    private Army army;
    private Province startProv;
    private Province finishProv;
    private boolean moveComplete;
    private int distTotal;
    private int distTraveled;

    public Movement(Army army, Province finishProv) {
        // TODO auto-check if the army can start a new movement?
        //  No, doing this check in Army
        this.army = army;
        this.army.activate();
        this.startProv = army.getLocation();
        this.finishProv = finishProv;
        this.moveComplete = false;
        this.distTraveled = 0;
        this.distTotal = 100; // for now, the default is 100 distance
    }

    /**
     * (DEBUG TOOL)
     * Resets the army's location to the specified finish province.
     */
    public void moveCompletely() {
        this.army.setLocation(finishProv);
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
                finishProv.addResident(army);
                moveComplete = true;
                army.deactivate();
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

    /**
     * Returns a description of the event in the form:
     * "fighting the enemy in a foreign land"
     * "moving to the hills"
     *
     * @return the string describing the event action
     */
    @Override
    public String getActionDescription() {
        return "moving to the " + finishProv.getName();
    }

    /**
     * Returns the province where the event occurs or starts
     *
     * @return the province location of the event
     */
    @Override
    public Province getLocation() {
        return this.startProv;
    }

    /**
     * Returns the province where the army will end its movement
     * @return the end province location
     */
    public Province getEndLocation() {
        return this.finishProv;
    }

    /**
     * Returns the name if the army that is performing the event
     *
     * @return the army name
     */
    @Override
    public String getArmyName() {
        return army.getName();
    }

    @Override
    public int hashCode() {
        return army.hashCode() + startProv.hashCode() + finishProv.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Movement) {
            return o.hashCode() == this.hashCode();
        } else {
            return false;
        }
    }
}