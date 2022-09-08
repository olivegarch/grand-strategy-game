package map;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * The Continent class.
 *
 * Represents an entire continuous continent,
 * of Provinces with border information,
 * where they are separated into regions.
 *
 * @author OliveGarch
 */
public class Continent {

    // fields
    
    private String name;
    private HashMap<String, Province> continentMap;

    // constructor

    /**
     * The Continent Constructor
     * Creates a continent given a name
     * @param label the name of the continent
     */
    public Continent(String label) {
        this.name = label;
        this.continentMap = new HashMap<>();
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
    public Continent(String label, File file) {
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
                Province province = this.searchProvince(adjList[0]);
                for (int i = 1; i < adjList.length; i++) {
                    province.addNeighbor(this.searchProvince(adjList[i]));
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
     * Adds a Province to the continentMap.
     * @param province the Province added
     */
    public void addProvince(Province province) {
        continentMap.put(province.getName(), province);
    }

    /**
     * Given a label, returns the province with that label
     * @param label the province name
     * @return the province if found in the region map, null if not found
     */
    public Province searchProvince(String label) {
        return continentMap.get(label);
    }

    /**
     * Gets the set of the Region's Provinces
     * @return the set
     */
    public Collection<Province> getProvinces() {
        return continentMap.values();
    }

    /**
     * Generates a string representation of the Region.
     * @return the string
     */
    public String toString() {
        String result = "Continent{label=" + this.name + "} Provinces:";
        for (String province : continentMap.keySet()) {
            result += "\n\t" + province + ": ";
            for (Province neighbor : this.searchProvince(province).getNeighbors()) {
                result += neighbor.getName() + " ";
            }
        }
        return result;
    }
}
