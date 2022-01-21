package units;

import game.Battle;
import game.Movement;
import map.Province;

import java.util.Random;

/**
 * The army class
 * Represents a collection of soldiers moving as one unit.
 * The army can move and attack.
 *
 * @author OliveGarch
 */
public class Army {

    // fields

    private String name;
    private double strength;
    private int currHP;
    private int maxHP;
    private int speed;
    private Province location;

    // constructor

    public Army(String name, Province location){
        this.name = name;
        this.location = location;
        this.currHP = 100;
        this.maxHP = 100;
        this.speed = 10;
        this.strength = (double) this.currHP / 10;
    }

    // methods

    /**
     * Starts a battle between 2 armies.
     * They attack each other until one is dead in the following order:
     * Defender does damage
     * Attacker does damage
     *
     *        this the attacking army
     * @param enemy the defending army
     * @return the battle
     */
    public Battle battle(Army enemy) {
        return new Battle(this, enemy);
    }

    /**
     * Starts a movement between 2 provinces.
     * @param finishProv the destination
     */
    public Movement move(Province finishProv) {
        return new Movement(this, finishProv);
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
     * Gets the current location
     * @return the current location
     */
    public Province getLocation() {
        return this.location;
    }

    public void setLocation(Province province) {
        this.location = province;
    }

    /**
     * The army does damage to the enemy army
     * @param enemy the enemy army
     */
    public int doDamage(Army enemy) {
        int damage = calculateDamage();
        enemy.takeDamage(damage);
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + damage + " damage");
        return damage;
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
         this.strength = (double) currHP / 10;
    }

    /**
     * Returns random damage with a normal dist with:
     * mean= strength
     * st.dev= strength / 5
     * @return the random damage
     */
    private int calculateDamage() {
        double mean = strength;
        double stDev = strength / 5;
        Random rand = new Random();
        double zScore = rand.nextGaussian();
        return (int) ( mean + (stDev * zScore));
    }

    /**
     * Returns the name of the army
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the speed of the army
     * @return the speed
     */
    public int getSpeed() {return this.speed;}
}
