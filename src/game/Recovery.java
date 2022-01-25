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
}
