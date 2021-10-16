package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Region class
 * Represents a cartesian map of provinces,
 *
 * @author myname
 */
public class Region {

    private String name;
    private Province[][] coordMap = new Province[5][5];

    public Region(String name, String fileName) throws FileNotFoundException {
        this.name = name;
        // read in full data
        Scanner data = new Scanner(new File(fileName));
        while (data.hasNextLine()) {
            // read in one line
            String line = data.nextLine();
            // split into array
            // create province in coordMap at (line#, char#)
        }
    }

}
