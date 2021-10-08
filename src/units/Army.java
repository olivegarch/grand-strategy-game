package units;

import java.util.Random;

/**
 * The army class
 * Represents a collection of soldiers moving as one unit.
 * The army can move and attack.
 * @author OliveGarch
 */
public class Army {

    // fields

    private String name;
    private int strength;
    private int currHP;
    private int maxHP;

    // constructor

    public Army(String name){
        this.name = name;
        this.strength = 10;
        this.currHP = 100;
        this.maxHP = 100;
    }

    // methods

    /**
     * A battle between 2 armies.
     * They attack each other until one is dead in the following order:
     * Defender does damage
     * Attacker does damage
     *
     * this the attacking army
     * @param enemy the defending army
     */
    public void battle(Army enemy) {
        System.out.println(this.name + " attacks " + enemy.getName());
        int day = 1;
        // defender is victorious by default
        Army victor = enemy;
        while ((this.currHP > 0) && (enemy.currHP > 0)) {
            System.out.println("========DAY" + day + "========");
            // defender does damage
            if (!enemy.isDead()) {
                enemy.doDamage(this);
            } else {
                System.out.println(enemy.getName() + " has been wiped out!");
                victor = this;
                break;
            }
            // attacker does damage
            if (!this.isDead()) {
                this.doDamage(enemy);
            } else {
                System.out.println(this.name + " has been wiped out!");
                victor = enemy;
                break;
            }
            // print army healths
            System.out.println(this.name + " health: " + this.currHP);
            System.out.println(enemy.getName() + " health: " + enemy.getCurrHP());
            day++;
        }
        System.out.println(victor.getName() + " wins the battle!\n"
        + "but with only " + getCurrHP() + " health left...");
    }

    /**
     * Gets the current HP
     * @return the current HP
     */
    public int getCurrHP() {
        return this.currHP;
    }

    /**
     * Checks if the army is dead
     * @return true if dead, false if alive
     */
    public boolean isDead() {
        return currHP == 0;
    }

    /**
     * The army does damage to the enemy army
     * @param enemy the enemy army
     */
    public void doDamage(Army enemy) {
        int damage = getDamage();
        enemy.takeDamage(damage);
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + damage + " damage");
    }

    /**
     * Subtract the health by the damage done
     * @param amount the damage done
     */
    public void takeDamage(int amount) {
         this.currHP -= amount;
         if (currHP < 0) {
             currHP = 0;
         }
    }

    /**
     * Returns random damage with a normal dist with:
     * mean= strength
     * st.dev= strength / 5
     * @return the random damage
     */
    private int getDamage() {
        double mean = strength;
        double stDev = (double) strength / 5;
        Random rand = new Random();
        double zScore = rand.nextGaussian();
        return (int) ( mean + (stDev * zScore));
    }

    public String getName() {
        return this.name;
    }
}
