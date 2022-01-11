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
}
