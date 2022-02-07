package test;

import map.Region;

import java.io.File;

/**
 * The test class for Region.
 * Reads a file and generates a Region containing the Provinces in the file.
 *
 * @author OliveGarch
 */
public class TestRegion2 {
    public static void main(String[] args) {
        Region region = new Region("Region1");
        File file = new File(".\\src\\map\\graphRegion2.txt");
        region.generateMap(file);
        System.out.println(region);
    }
}
