package map;

import units.Army;

import java.util.*;

/**
 * The Province class
 *
 * Represents a single location
 * in which armies can station, battle and move to.
 *
 * @author OliveGarch
 */
public class Province {

    // fields

    private String name;
//    private List<Army> residents;
    private HashSet<Province> neighbors;

    private LinkedList<Province> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;

//    private Weather weather;
//    private Terrain terrain;
//    private Vegetation vegetation;

    // constructor

    public Province(String name) {
        this.name = name;
//        this.residents = new ArrayList<>();
        this.neighbors = new HashSet<>();

        // TODO Add weather later
        // this.weather = weather;
        // TODO Add terrain later
        // this.terrain = terrain;
        // TODO Add vegetation later
        // this.vegetation = vegetation;
    }

    /**
     * Adds a neighbor to the set of neighbors
     * @param province the neighboring province added to this province
     */
    public void addNeighbor(Province province) {
        this.neighbors.add(province);
    }

    // methods

    public Set<Province> getNeighbors() {
        return this.neighbors;
    }

//    /**
//     * Gets the residents (armies) currently in the Province
//     * @return a list of armies
//     */
//    public List<Army> getResidents() {
//        return residents;
//    }
//
//    /**
//     * Adds a resident (army) to the list of residents in the Province
//     */
//    public void addResident(Army army) {
//        residents.add(army);
//    }

    /**
     * Gets the name of the Province
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Compares if two Provinces have the same name,
     * and thus, are equal
     * @param other the other Province
     * @return true if they have the same name, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Province) {
            return this.getName().equals(( (Province)other ).getName());
        } else {
            return false;
        }
    }

    /**
     * Generates a hash code for the Province.
     * @return the hash code
     */
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Generates a string representation of the Province
     * @return the string
     */
    @Override
    public String toString() {
        return "Province{" + this.name + "}";
    }
}
