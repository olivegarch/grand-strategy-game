package game;

import java.util.List;
import java.util.Set;

/**
 * The Clock Class
 * Used to keep track of the day and time
 * also contains methods for advancing the day for all events.
 *
 * @author OliveGarch
 */
public class Clock {

    private int day;

    /**
     * Clock constructor
     */
    public Clock() {
        this.day = 0;
    }

    /**
     * Resets the day back to 0
     */
    public void reset() {
        this.day = 0;
    }

    /**
     * Advances time by 1 day for all events
     * @param events the list of events
     */
    public void adv1day(Events events) {
        events.advanceAllEvents();
        this.day++;
    }

    /**
     * Advances time by 10 days for all events
     * @param events the list of events
     */
    public void adv10day(Events events) {
        for (int i = 0; i < 10; i++) {
            this.adv1day(events);
        }
    }
}
