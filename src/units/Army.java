package units;

import game.Battle;
import game.Movement;
import map.Province;

import java.util.Random;

/**
 * The Army class
 * Represents a collection of soldiers moving as one unit.
 * The army can move and attack.
 *
 * @author OliveGarch
 */
public class Army {

    // fields

    private String name; // the name of the army
    private double strength; // the strength of the army, (set as 1/10 of the health)
    private int currHP; // the current health
    private int maxHP; // the maximum health
    private int speed; // how fast the army moves between province
    private Province location; // the current province of the army
    private boolean active; // whether the army is currently doing an action (involved in an event)

    // constructor

    public Army(String name, Province location){
        this.name = name;
        this.location = location;
        this.currHP = 100;
        this.maxHP = 100;
        this.speed = 10;
        this.strength = (double) this.currHP / 10;
        this.active = false;
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
     * @return a new Movement event if the movement is possible, null otherwise.
     */
    public Movement move(Province finishProv) {
        if (!this.isActive()) {
            return new Movement(this, finishProv);
        } else {
            return null;
        }
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

    /**
     * Gets the name of the current location
     * @return the name of the current location
     */
    public String getLocName() {
        return this.location.getName();
    }

    /**
     * Sets the current location to the given location
     * @param province the new location
     */
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
     * Returns if the army is currently involved in an event
     * @return true if involved, false otherwise
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Activates the army.
     */
    public void activate() {
        this.active = true;
    }

    /**
     * Deactivates the army.
     */
    public void deactivate() {
        this.active = false;
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
