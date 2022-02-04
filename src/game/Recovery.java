package game;

/**
 * The Recovery class
 * Represents an army's action to "recover" and gain health
 *
 * @author OliveGarch
 */
public class Recovery implements Event {
    /**
     * Handles event updates when day is advanced.
     */
    @Override
    public void advanceDay() {

    }

    /**
     * Returns if the event is complete or not
     *
     * @return True if complete, False otherwise
     */
    @Override
    public boolean isComplete() {
        return false;
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
        return null;
    }

    /**
     * Returns the name if the army that is performing the event
     *
     * @return the army name
     */
    @Override
    public String getArmyName() {
        return null;
    }
}
