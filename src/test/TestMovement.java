package test;

import game.Movement;
import map.Map;
import map.Province;
import units.Army;

import java.util.Scanner;

/**
 * This is a test class for testing movement
 *
 * @author OliveGarch
 */
public class TestMovement {
    public static void main(String[] args) {
        // make region
        Map map = new Map("Continent1");
        String provincesStr = "Fields Hills Forest";
        map.generateStdMap(provincesStr);
        String[] provinces = provincesStr.split(" ");
        Province startingProv = map.getProvinceByName(provinces[0]);
        Province finishingProv = map.getProvinceByName(provinces[1]);

        // make army
        Army army = new Army("army1", startingProv);

        // movement
        System.out.println(army.getName() + " starting province: " + army.getLocation());

        Movement movement1 = army.move(finishingProv);
        Scanner in = new Scanner(System.in);

        movement1.advanceDay();

        String input = in.nextLine();
        while (!input.equals("quit")) {
            movement1.advanceDay();
            input = in.nextLine();
        }
        in.close();

        System.out.println(army.getName() + " ending province: " + army.getLocation());


    }
}
