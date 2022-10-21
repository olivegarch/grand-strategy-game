package game;

import units.Army;

import java.util.ArrayList;
import java.util.HashMap;

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

    /**
     * Adds an army with a label to the army list
     * @param armyLabel the label or quick name for the army
     * @param army the army object
     */
    public void addArmy (String armyLabel, Army army) {
        armyList.put(armyLabel, army);
    }
}
