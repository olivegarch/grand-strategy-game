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


    public Region(String name, String fileName) throws FileNotFoundException {
        this.name = name;
        // read in full data
        try {
            Scanner data = new Scanner(new File(fileName));
            while (data.hasNextLine()) {
                // read in one line
                String line = data.nextLine();
                String[] provinceFields = line.split(" ");
                Province newProvince = new Province(provinceFields[0]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found:: Using default data");
        }
    }

    // graph mutator methods

    /**
     * Adds a Province to the regionMap.
     * @param name the name of the Province added
     */
    private void addProvince(String name) {
        regionMap.putIfAbsent(new Province(name), new HashSet<>());
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
