package test;

import game.Movement;
import map.Province;
import map.Region;
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
        Region region = new Region("region1");
        region.generateMap("Fields Hills Forest");
        Province startingProv = null;
        Province finishingProv = null;
        for (Province province : region.getProvinces()) {
            if (startingProv == null) {
                startingProv = province;
            } else if (finishingProv == null) {
                finishingProv = province;
            } else {
                break;
            }
        }

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
