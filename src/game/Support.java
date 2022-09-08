package game;

import units.Army;

/**
 * The Support class
 * represents an Army's support of another Army's action.
 *
 * @author OliveGarch
 */
public class Support {
    // TODO fill with supporting stuff

    private Army supportArmy;
    private Army battleArmy;
    private Battle battle;


    public Support(Army supportArmy, Army battleArmy, Battle battle) {
        this.supportArmy = supportArmy;
        this.battleArmy = battleArmy;
        this.battle = battle;
    }
}
