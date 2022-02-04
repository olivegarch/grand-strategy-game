package game;

/**
 * The Event interface
 * Represents a single event,
 * a generic label for actions that advance through each day.
 *
 * @author OliveGarch
 */
public interface Event {


    /**
     * Handles event updates when day is advanced.
     */
    void advanceDay();

    /**
     * Returns if the event is complete or not
     * @return True if complete, False otherwise
     */
    boolean isComplete();

    /**
     * Returns a description of the event in the form:
     * "fighting the enemy in a foreign land"
     * "moving to the hills"
     * @return the string describing the event action
     */
    String getActionDescription();

    /**
     * Returns the name if the army that is performing the event
     * @return the army name
     */
    String getArmyName();
}
