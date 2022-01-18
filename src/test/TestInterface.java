package test;

import map.Province;
import map.Region;
import units.Army;

import java.util.Scanner;

/**
 * A test class to write a PTUI for the player to interact with the game
 *
 * @author OliveGarch
 */
public class TestInterface {
    public static void main(String[] args) {
        // make region
        Region region = new Region("Region1");
        region.generateMap("Hills Plains Forest Fields Town");

        // make player army
        Province startingProv = null;
        for (Province province : region.getProvinces()) {
            startingProv = province;
            break;
        }
        Army playerArmy = new Army("Player", startingProv);

        // make computer army
        Army compArmy = new Army("Computer", startingProv);

        // welcome message
        System.out.println("WELCOME TO THE BATTLEFIELD");
        System.out.println("This is the playground to test features of the game in progress");

        // prompt user
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("quit")) {
            System.out.print("> ");
            input = scanner.nextLine();
            if (input.equals("help")) {
                System.out.println("Commands: \n- quit\n- help\n- move \n- attack");
            }
        }
        System.out.println("Quitting...");

        // interpret input
    }
}
