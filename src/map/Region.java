package map;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * The Region class
 * Represents a graph map of provinces.
 *
 * @author OliveGarch
 */
public class Region {

    private String name;
    private HashMap<String, Province> regionMap;

    /**
     * The constructor method
     * @param name the name of the region
     */
    public Region(String name) {
        this.name = name;
        this.regionMap = new HashMap<>();
    }

    public void generateMap(File file) {
        try {
            Scanner scanner = new Scanner(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a Province to the regionMap.
     * @param province a Province
     */
    public void addProvince(Province province) {
        regionMap.put(province.getName(), province);
    }

    /**
     * Adds Provinces to the regionMap.
     * @param provinces a set of Provinces
     */
    public void addProvinces(Set<Province> provinces) {
        for (Province province : provinces) {
            this.addProvince(province);
        }
    }

    /**
     * Given a label, returns the province with that label
     * @param label the province name
     * @return the province if found in the region map, null if not found
     */
    public Province searchProvince(String label) {
        return regionMap.get(label);
    }

    /**
     * Gets the set of the Region's Provinces
     * @return the set
     */
    public Set<Province> getProvinces() {
        return (Set<Province>) regionMap.values();
    }

    /**
     * Generates a string representation of the Region.
     * @return the string
     */
    public String toString() {
        String result = "Region{label=" + this.name + "} Provinces:";
        for (String province : regionMap.keySet()) {
            result += "\n\t" + province + ": ";
            for (Province neighbor : this.searchProvince(province).getNeighbors()) {
                result += neighbor.getName() + " ";
            }
        }
        return result;
    }
}
