package game;

import map.Province;
import units.Army;

import java.util.PrimitiveIterator;

/**
 * The Recovery class
 * Represents an army's action to "recover" and gain health
 *
 * @author OliveGarch
 */
public class Recovery implements Event {

    // fields

    private Army army;
    private Province location;
    private boolean recoveryComplete;

    // constructor

    public Recovery(Army army) {
        this.army = army;
        this.location = army.getLocation();
    }

    // methods

    /**
     * Handles event updates when day is advanced.
     */
    @Override
    public void advanceDay() {
        this.army.recover();
        if (this.army.isFullHealth()) {
            this.recoveryComplete = true;
        }
    }

    /**
     * Returns if the event is complete or not
     *
     * @return True if complete, False otherwise
     */
    @Override
    public boolean isComplete() {
        return this.recoveryComplete;
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
        return this.getArmyName() + " recovers in " + location.getName();
    }

    /**
     * Returns the province where the event occurs or starts
     *
     * @return the province location of the event
     */
    @Override
    public Province getLocation() {
        return this.location;
    }

    /**
     * Returns the name if the army that is performing the event
     *
     * @return the army name
     */
    @Override
    public String getArmyName() {
        return this.army.getName();
    }

    @Override
    public int hashCode() {
        return army.hashCode() + location.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Recovery) {
            return o.hashCode() == this.hashCode();
        } else {
            return false;
        }
    }
}
