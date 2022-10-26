package test;

import map.Map;

import java.io.File;

/**
 * The test class for Region.
 * Reads a file and generates a Region containing the Provinces in the file.
 *
 * @author OliveGarch
 */
public class TestRegion2 {
    public static void main(String[] args) {
        Map map = new Map("Continent1");
        File file = new File(".\\data\\graphRegion2.txt");
//        continent.generateMap(file);
        System.out.println(map);
    }
}
