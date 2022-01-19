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
        String helpMsg = "Commands: \n- quit" +
                "\n- help" +
                "\n[TODO]- move [province] (moves your army to an adjacent province)" +
                "\n[TODO]- attack [army] (attacks the specified army if they are in an adjacent province)" +
                "\n[TODO]- status (shows current status of your army)" +
                "\n[TODO]- loc (shows the current location of your army and the neighboring provinces)";

        String input = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(helpMsg);
        while (!input.equals("quit")) {
            System.out.print("> ");
            input = scanner.nextLine();
            String[] inputList = input.split(" ");
            if (input.equals("help")) {
                System.out.println(helpMsg);
            } else if (inputList[0].equals("move")) {
                // TODO
                if (inputList.length == 2) {
                    boolean neighborFound = false;
                    for (Province neighbor : region.getNeighbors(playerArmy.getLocation())) {
                        if (neighbor.getName().equals(inputList[1])) {
                            neighborFound = true;
                            System.out.println("Marching from " + playerArmy.getLocation().getName() +
                                    " to " + neighbor.getName() + "...");
                            playerArmy.move(neighbor);
                            break;
                        }
                    }
                    if (!neighborFound) {
                        System.out.println("ERROR: Province " + inputList[1] + " is not a neighboring province of " +
                                playerArmy.getLocation().getName());
                    }
                } else {
                    System.out.println("ERROR: Invalid use of 'move'. \n'move' takes one parameter, the target province");
                }
            } else if (inputList[0].equals("attack")) {
                // TODO
            } else if (inputList[0].equals("status")) {
                // TODO reformat? (this is fine right now though)
                System.out.println("Name: " + playerArmy.getName() +
                        "\nHealth: " + playerArmy.getCurrHP());
            } else if (inputList[0].equals("loc")) {
                // TODO reformat to look pretty
                System.out.println("Current province: " + playerArmy.getLocation() +
                        "\nNeighboring provinces: " + region.getNeighbors(playerArmy.getLocation()));
            } else if (inputList[0].equals("quit")) {
                break;
            } else {
                System.out.println("ERROR: Invalid command");
            }

        }
        System.out.println("Quitting...");

        // interpret input
    }
}
