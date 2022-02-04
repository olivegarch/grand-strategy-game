package game;

import java.util.HashSet;

/**
 * The Events class
 *
 * Used to hold a set of events,
 * which advance days and check if there are duplicate events
 *
 * @author OliveGarch
 */
public class Events {
    // fields

    HashSet<Event> events;

    // constructor

    public Events() {
        this.events = new HashSet<>();
    }

    // methods

    /**
     * Adds an event to the events set
     * Prints a message stating if the event already exists in the set
     * @param event the new event added
     * @return if there were no duplicates, returns true
     *         if there was a duplicate, returns false
     */
    public boolean addEvent(Event event) {
        if (events.contains(event)) {
            return false;
        } else {
            events.add(event);
            return true;
        }
    }

    /**
     * Advances the day on all events stored
     */
    public void advanceAllEvents() {
        for (Event event : events) {
            event.advanceDay();
            if (event.isComplete()) {
                events.remove(event);
            }
        }
    }
}
