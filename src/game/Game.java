package game;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The Game class
 *
 *
 * @author OliveGarch
 */
public class Game {

    Player player1;
    Player player2;

    HashSet<Movement> movementEvents;
    HashSet<Battle> battleEvents;
    HashSet<Recovery> recoveryEvents;

    public Game(String p1Name, String p2Name) {
        player1 = new Player(p1Name);
        player2 = new Player(p2Name);
        movementEvents = new HashSet<>();
        battleEvents = new HashSet<>();
        recoveryEvents = new HashSet<>();
    }

    /**
     * Advance the day for all events in the following order:
     * 1. All Battles
     * 2. All Recoveries
     * 3. All Movements
     */
    public void advanceDay() {
        // battle events
        for (Event battle : battleEvents) {
            battle.advanceDay();
        }
        // recovery events
        for (Event recovery : recoveryEvents) {
            recovery.advanceDay();
        }
        // movement events
        for (Event movement : movementEvents) {
            movement.advanceDay();
        }
    }

    /**
     * Adds a movement to the movement set
     * @param movement the movement
     */
    public void addMovement(Movement movement) {
        movementEvents.add(movement);
    }

    /**
     * Adds a battle to the battle set
     * @param battle the battle
     */
    public void addBattle(Battle battle) {
        battleEvents.add(battle);
    }

    /**
     * Adds a recovery to the recovery set
     * @param recovery the recovery
     */
    public void addRecovery(Recovery recovery) {
        recoveryEvents.add(recovery);
    }
}
