package map;

import java.util.HashSet;

/**
 * The province class
 * Represents a single location
 * in which armies can station, battle and move to.
 *
 * @author OliveGarch
 */
public class Province {

    // fields

    private String name;
    private Weather weather;
    private Terrain terrain;
    private Vegetation vegetation;

    // constructor

    public Province(String name) {
        this.name = name;
        // TODO Add weather later
        // this.weather = weather;
        // TODO Add terrain later
        // this.terrain = terrain;
        // TODO Add vegetation later
        // this.vegetation = vegetation;
    }

    // methods

    public String getName() {
        return this.name;
    }




}
