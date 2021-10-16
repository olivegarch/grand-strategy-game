package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The Region class
 * Represents a graph map of provinces.
 *
 * @author OliveGarch
 */
public class Region {

    private String name;
    private Map<Province, List<Province>> regionMap = new Map<Province, List<Province>>();


    public Region(String name, String fileName) throws FileNotFoundException {
        this.name = name;
        // read in full data
        Scanner data = new Scanner(new File(fileName));
        while (data.hasNextLine()) {
            // read in one line
            String line = data.nextLine();
            String[] provinceFields = line.split(" ");
            Province newProvince = new Province(provinceFields[0]);
            regionMap.put(newProvince);
        }
    }

    // graph mutator methods

    /**
     * Adds a Province to the regionMap
     * @param name the name of the Province added
     */
    private void addProvince(String name) {
        regionMap.putIfAbsent(new Province(name), new List<Province>());
    }

    /**
     * Removes a Province from the regionMap
     * @param name the name of the Province removed
     */
    private void removeProvince(String name) {
        // TODO
    }

    /**
     * Creates a "border" between 2 Provinces in regionMap
     * @param name1 first Province name
     * @param name2 second Province name
     */
    private void addBorder(String name1, String name2) {
        // TODO
    }

    /**
     * Gets the neighbor list of the given Province.
     * @param province the Province with neighbors
     * @return the list of Provinces
     */
    public List<Province> getNeighbors(Province province) {
        return null;
    }
}
