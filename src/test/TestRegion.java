package test;

import map.Province;
import map.Region;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The test class for Region.
 *
 * @author OliveGarch
 */
public class TestRegion {
    public static void main(String[] args) {
        Region region1 = new Region("Region1");

        try {
            File file = new File(".\\src\\map\\graphRegion1.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(region1);
    }

    public void readFile  (File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] adjList = line.split(" ");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
