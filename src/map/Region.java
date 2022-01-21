package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The Region class
 * Represents a graph map of provinces.
 *
 * @author OliveGarch
 */
public class Region {

    private String name;
    private HashMap<Province, HashSet<Province>> regionMap = new HashMap<>();


    public Region(String name) {
        this.name = name;
    }

    // graph mutator methods

    public void generateMap(String data) {
        for (String name : data.split(" ")) {
            Province newProvince = new Province(name);
            this.addProvince(newProvince);
        }
        for (Province node : this.getProvinces()) {
            for (Province neighbor : this.getProvinces()) {
                this.addBorder(node, neighbor);
            }
        }

    }

    /**
     * Adds a Province to the regionMap.
     * @param node the Province added
     */
    private void addProvince(Province node) {
        regionMap.putIfAbsent(node, new HashSet<>());
    }

    /**
     * Creates a "border" between 2 Provinces in regionMap
     * @param node1 first Province name
     * @param node2 second Province name
     */
    private void addBorder(Province node1, Province node2) {
        if ((regionMap.containsKey(node1) && regionMap.containsKey(node2)) // If both are in the graph
                && (!node1.equals(node2))) {// If they are not the same Province
            regionMap.get(node1).add(node2);
            regionMap.get(node2).add(node1);
        }
    }

    /**
     * Given a label, returns the province with that label
     * @param label the province name
     * @return the province if found in the region map, null if not found
     */
    public Province searchProvince(String label) {
        for (Province province : regionMap.keySet()) {
            if (province.getName().equals(label)) {
                return province;
            }
        }
        return null;
    }

    /**
     * Gets the set of the Region's Provinces
     * @return the set
     */
    public Set<Province> getProvinces() {
        return regionMap.keySet();
    }

    /**
     * Gets the neighbor list of the given Province
     * @param node the Province with neighbors
     * @return the list of Provinces
     */
    public HashSet<Province> getNeighbors(Province node) {
        return regionMap.get(node);
    }



    /**
     * Generates a string representation of the Region.
     * @return the string
     */
    public String toString() {
        String result = "Region{label=" + this.name + "} Provinces:";
        for (Province node : regionMap.keySet()) {
            result += "\n\t" + node + " neighbors:";
            for (Province neighbor : regionMap.get(node)) {
                result += "\n\t\t" + neighbor;
            }
        }
        return result;
    }
}
