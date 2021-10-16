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
public class Battle {
    // fields

    // defender
    Army defender;
    // attacker
    Army attacker;
    // location
    Province location;

    // constructor
    public Battle(Army attacker, Army defender) {
        this.attacker = attacker;
        this.defender = defender;
        this.location = defender.getLocation();
    }

    // methods

    /**
     * The two armies that are clashing fight until one deals no damage.
     */
    public void fight() {
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
}
