package map;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * The Map class.
 *
 * Represents an entire Map of Provinces
 *
 * @author OliveGarch
 */
public class Map {

    // fields
    
    private String name;
    private HashMap<String, Province> provinceMap;

    // constructor

    /**
     * The Continent Constructor
     * Creates a continent given a name
     * @param label the name of the continent
     */
    public Map(String label) {
        this.name = label;
        this.provinceMap = new HashMap<>();
    }

    /**
     * Generates Provinces and borders from a file of names a relations,
     * where the neighboring provinces of each province is specified.
     * ex.
     * Hills Plains Forest
     * Hills Plains
     * Plains Hills Forest
     * Forest Plains
     *
     * @param file the pre-generated file from a filename.
     */
    public Map(String label, File file) {
        this.name = label;
        try {
            Scanner scanner = new Scanner(file);

            // read the first line and make the provinces
            String firstLine = scanner.nextLine();
            String[] provinceNames = firstLine.split(" ");

            for (String name : provinceNames) {
                this.addProvince(new Province(name));
            }

            // assign neighbors to each province
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] adjList = line.split(" ");
                Province province = this.getProvinceByName(adjList[0]);
                for (int i = 1; i < adjList.length; i++) {
                    province.addNeighbor(this.getProvinceByName(adjList[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // methods

    /**
     * Generates Provinces and borders from a string of province names,
     * where every province borders every other province.
     * ex. "Hills Plains Forest"
     * @param data the string of province names
     */
    public void generateStdMap(String data) {
        for (String name : data.split(" ")) {
            Province newProvince = new Province(name);
            this.addProvince(newProvince);
        }
        for (Province node : this.getProvinces()) {
            for (Province neighbor : this.getProvinces()) {
                node.addNeighbor(neighbor);
            }
        }
    }

    /**
     * Adds a Province to the provinceMap.
     * @param province the Province added
     */
    public void addProvince(Province province) {
        provinceMap.put(province.getName(), province);
    }

    /**
     * Given a label, returns the province with that label
     * @param label the province name
     * @return the province if found in the region map, null if not found
     */
    public Province getProvinceByName(String label) {
        return provinceMap.get(label);
    }

    /**
     * Checks if the Province of the given name exists
     * @param provinceName The province name
     * @return true if the Province exists, false otherwise
     */
    public boolean doesProvinceExist(String provinceName) {
        return provinceMap.containsKey(provinceName);
    }
    
    /**
     * Gets the set of the Region's Provinces
     * @return the set
     */
    public Collection<Province> getProvinces() {
        return provinceMap.values();
    }

    /**
     * Generates a string representation of the Region.
     * @return the string
     */
    public String toString() {
        String result = "Continent{label=" + this.name + "} Provinces:";
        for (String province : provinceMap.keySet()) {
            result += "\n\t" + province + ": ";
            for (Province neighbor : this.getProvinceByName(province).getNeighbors()) {
                result += neighbor.getName() + " ";
            }
        }
        return result;
    }
}
