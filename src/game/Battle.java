package game;

import map.Province;
import units.Army;

/**
 *
 * The Battle class
 * Represents a single battle, where 2 armies fight.
 *
 * @author OliveGarch
 */
public class Battle implements Event{
    // fields

    // defender
    private Army defender;
    // attacker
    private Army attacker;
    // location
    private Province location;
    // battle day
    private int day;
    // is the battle over
    private boolean battleComplete;
    // the victor
    private Army victor;

    // constructor
    public Battle(Army attacker, Army defender) {
        this.attacker = attacker;
        this.defender = defender;
        this.location = defender.getLocation();
        this.day = 0;
        this.battleComplete = false;
        this.victor = defender;
    }

    // methods

    /**
     * (DEBUG TOOL)
     * The two armies that are clashing,
     * fight until one deals no damage and flees, ending the fight.
     */
    public void fightCompletely() {
        System.out.println("Battle of " + location.getName());
        int day = 1;
        // defender is victorious by default
        Army victor = defender;
        while ((attacker.getCurrHP() > 0) && (defender.getCurrHP() > 0)) {
            System.out.println("========DAY" + day + "========");
            // defender does damage
            if (!defender.isDead()) {
                int defenderDamage = defender.doDamage(attacker);
                if (defenderDamage == 0){
                    System.out.println(defender.getName() + " flees!");
                    victor = attacker;
                    break;
                }
            } else {
                System.out.println(defender.getName() + " has been wiped out!");
                victor = attacker;
                break;
            }
            // attacker does damage
            if (!attacker.isDead()) {
                int thisDamage = attacker.doDamage(defender);
                if (thisDamage == 0){
                    System.out.println(attacker.getName() + " flees!");
                    victor = defender;
                    break;
                }

            } else {
                System.out.println(attacker.getName() + " has been wiped out!");
                victor = defender;
                break;
            }
            // print army healths
            System.out.println(attacker.getName() + " health: " + attacker.getCurrHP());
            System.out.println(defender.getName() + " health: " + defender.getCurrHP());
            day++;
        }
        System.out.println(victor.getName() + " wins the battle!\n"
                + "but with only " + victor.getCurrHP() + " health left...");
    }

    @Override
    public void advanceDay() {
        if (!this.isComplete()) {
            fightOneDay();
        }
    }

    /**
     * Plays out 1 day of the battle.
     * Assumptions: both attacker and defender are still alive.
     *              battleComplete is false.
     */
    private void fightOneDay() {
        System.out.println("Battle of " + location.getName());

        // defender is victorious by default
        this.day++;
        System.out.println("========DAY" + this.day + "========");

        // defender does damage
        int defenderDamage = defender.doDamage(attacker); // defender does damage
        if (defenderDamage == 0) { // if defender's damage is pitiful
            System.out.println(defender.getName() + " flees!"); // attacker wins
            victor = attacker;
            battleComplete = true;
        } else {
            if (!attacker.isDead()) { // if attacker survived defender's damage
                int thisDamage = attacker.doDamage(defender); // attacker does damage
                if (thisDamage == 0) { // if attacker's damage is pitiful
                    System.out.println(attacker.getName() + " flees!"); // defender wins
                    victor = defender;
                    battleComplete = true;
                } else if (defender.isDead()) { // if attacker kills defender
                    System.out.println(defender.getName() + "has been wiped out!"); // attacker wins
                    victor = attacker;
                    battleComplete = true;
                }
            } else { // if defender kills attacker
                System.out.println(attacker.getName() + " has been wiped out!"); // defender wins
                victor = defender;
                battleComplete = true;
            }
        }
        // print army healths
        System.out.println(attacker.getName() + " health: " + attacker.getCurrHP());
        System.out.println(defender.getName() + " health: " + defender.getCurrHP());

        if (battleComplete) {
            System.out.println(victor.getName() + " has emerged victorious!");
            System.out.println("...But the glory was not without cost. " + victor.getName() + " lost " + (100 - victor.getCurrHP()) + " of its best soldiers");
        }
    }

    /**
     * Returns true if the battle has been completed
     * Returns false otherwise
     * @return if the battle is over
     */
    public boolean isComplete(){
        return this.battleComplete;
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
        return attacker.getName() + " battles with " + defender.getName() + " in " + location.getName();
    }

    /**
     * Returns the name of the attacking army
     *
     * @return the attacking army name
     */
    @Override
    public String getArmyName() {
        return attacker.getName();
    }

    /**
     * Returns the name of the defending army
     *
     * @return the defending army name
     */
    public String getDefenderName() {
        return defender.getName();
    }

    /**
     * Returns the province where the event occurs or starts
     * @return the province location of the event
     */
    public Province getLocation() {
        return this.location;
    }

    @Override
    public int hashCode() {
        return attacker.hashCode() + defender.hashCode() + location.hashCode();
    }

    @Override
    public boolean equals (Object o) {
        if (o instanceof Battle) {
            return o.hashCode() == this.hashCode();
        } else {
            return false;
        }
    }
}
