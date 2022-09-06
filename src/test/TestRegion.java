package test;

import map.Continent;
import map.Province;
import map.Region;

import java.awt.*;
import java.io.*;

/**
 * The test class for Region.
 * Reads a file and generates a Region containing the Provinces in the file.
 *
 * @author OliveGarch
 */
public class TestRegion {
    public static void main(String[] args) {
        Continent continent = new Continent("Continent1");
        File file = new File(".\\src\\data\\graphRegion1.txt");
//        continent.generateMap(file);
//        System.out.println(continent);
    }
}
