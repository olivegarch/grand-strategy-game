package game;

import map.Province;

/**
 * The Event interface
 * Represents a single event,
 * a generic label for actions that advance through each day.
 *
 * @author OliveGarch
 */
public abstract class Event {

    /**
     * Handles event updates when day is advanced.
     */
    abstract void advanceDay();

    /**
     * Returns if the event is complete or not
     * @return True if complete, False otherwise
     */
    abstract boolean isComplete();

    /**
     * Returns a description of the event in the form:
     * "fighting the enemy in a foreign land"
     * "moving to the hills"
     * @return the string describing the event action
     */
    abstract String getActionDescription();

    /**
     * Returns the province where the event occurs or starts
     * @return the province location of the event
     */
    abstract Province getLocation();

    /**
     * Returns the name of the army that is performing the event or started it
     * @return the army name
     */
    abstract String getArmyName();
}
