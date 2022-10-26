package game;

import map.Map;
import map.Province;
import units.Army;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The Game class
 *
 * Stores information on players and global events
 *
 * @author OliveGarch
 */
public class Game {

    Player player1;
    Player player2;

    HashSet<Movement> movementEvents;
    HashSet<Battle> battleEvents;
    HashSet<Recovery> recoveryEvents;

    Map gameMap;

    public Game(String p1Name, String p2Name) {
        player1 = new Player(p1Name);
        player2 = new Player(p2Name);
        movementEvents = new HashSet<>();
        battleEvents = new HashSet<>();
        recoveryEvents = new HashSet<>();
        gameMap = new Map("Map");
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
     * Creates a movement even if the army and province(s) exist
     * @param armyName the name of the army
     * @param provinces the list of provinces the army is moving through
     * @return a String message of the status of the movement creation
     */
    public String createMovement(Player player, String armyName, ArrayList<String> provinces) {
        if (player.doesPlayerHaveArmyName(armyName)) {
            ArrayList<Province> destinations = new ArrayList<>();
            for (String destinationName : provinces) {
                if (gameMap.doesProvinceExist(destinationName)) {
                    destinations.add(gameMap.getProvinceByName(destinationName));
                } else {
                    // one of the provinces does not exist
                    return "ERROR: province " + destinationName + " does not exist";
                }
            }
            // all provinces valid
            // create the Movement object
            Army army = player.getArmyByName(armyName);
            Movement movement = new Movement(army, destinations);
            movementEvents.add(movement);
            return "Movement started for army " + armyName + " from " + destinations.get(0) + " to " + destinations.get(destinations.size() - 1);
        }
        // army does not belong to the player
        return "ERROR: army " + armyName + " does not exist for player " + player.getName();
    }

    /**
     * Checks if either of the Players have an army with the given army name
     * @param armyName the name of the army
     * @return true if an army with the name exists
     *          false otherwise
     */
    public boolean doesArmyExist(String armyName) {
        boolean p1HasArmy = player1.getArmyNames().contains(armyName);
        boolean p2HasArmy = player2.getArmyNames().contains(armyName);
        return p1HasArmy || p2HasArmy;
    }
}
