package test;

import map.Province;
import map.Region;

import java.io.*;

/**
 * The test class for Region.
 * Reads a file and generates a Region containing the Provinces in the file.
 *
 * @author OliveGarch
 */
public class TestRegion {
    public static void main(String[] args) {
        Region region = new Region("Region1");
        File file = new File(".\\src\\map\\graphRegion1.txt");
        region.generateMap(file);
        System.out.println(region);
    }
}
