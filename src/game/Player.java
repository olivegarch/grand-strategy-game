package game;

import units.Army;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * The Player class
 * Represents a player in a game
 *
 * @author OliveGarch
 */
public class Player {

    String name;
    HashMap<String, Army> armyList;

    public Player(String name) {
        this.name = name;
        armyList = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    /**
     * Adds an army with a label to the army list
     * @param armyLabel the label or quick name for the army
     * @param army the army object
     */
    public void addArmy (String armyLabel, Army army) {
        armyList.put(armyLabel, army);
    }

    /**
     * Gets the collection of Army objects belonging to the Player
     * @return a collection of Army objects
     */
    public Collection<Army> getArmies() {
        return armyList.values();
    }

    /**
     * Gets the Army with the given name
     * @param armyName name of the Army
     * @return the Army object if it exists,
     *          null if it does not exist
     */
    public Army getArmyByName(String armyName) {
        return armyList.get(armyName);
    }

    /**
     * Checks if the Player has an Army by the given name
     * @param armyName name of the Army
     * @return true of the Army exists,
     *          false otherwise
     */
    public boolean doesPlayerHaveArmyName(String armyName) {
        return armyList.containsKey(armyName);
    }

    /**
     * Gets the collection of Army names belonging to the Player
     * @return a collection of Army names
     */
    public Collection<String> getArmyNames() {
        return armyList.keySet();
    }
}
