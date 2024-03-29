package test;

import game.Clock;
import game.Events;
import game.Movement;
import map.Map;
import map.Province;
import units.Army;

import java.util.Scanner;

/**
 * A test class to write a PTUI for the player to interact with the game
 *
 * @author OliveGarch
 */
public class TestInterface {
    public static void main(String[] args) {

        // make continent
        Map map = new Map("Mainland");
        map.generateStdMap("Hills Plains Forest Fields Town");

        // make player army
        Province startingProv = null;
        for (Province province : map.getProvinces()) {
            startingProv = province;
            break;
        }
        Army playerArmy = new Army("Player", startingProv);

        // make computer army
        Army compArmy = new Army("Computer", startingProv);

        // make event list
        Events events = new Events();

        // make global clock
        Clock clock = new Clock();

        // welcome message
        System.out.println("WELCOME TO THE BATTLEFIELD");
        System.out.println("This is the playground to test features of the game in progress");

        // prompt user
        String helpMsg = "Commands: " +
                "\n- quit" +
                "\n- help" +
                "\n- day (advances the time forward one day)"+
                "\n[TODO]- move [province] (moves your army to an adjacent province)" +
                "\n[TODO]- attack [army] (attacks the specified army if they are in an adjacent province)" +
                "\n[TODO]- status (shows current status of your army)" +
                "\n[TODO]- loc (shows the current location of your army and the neighboring provinces)" +
                "\n[TODO]- scout (show other armies in the same region as your army)";

        String input = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(helpMsg);
        while (!input.equals("quit")) {
            System.out.print("> ");
            input = scanner.nextLine();
            String[] inputList = input.split(" ");

            // Display help message //
            if (input.equals("help")) {
                System.out.println(helpMsg);

            // Advance one day //
            }
            else if (input.equals("day")) {
                clock.adv1day(events);

            // Move between provinces //
            }
            else if (inputList[0].equals("move")) {
                // TODO prevent moving while already performing a movement.
                //  Alternatively, you can allow another movement,
                //  but it replaces the old one, starting over from 0.
                //  (Kinda like HOI4)

                // TODO test out making move while already performing an action.

                if (inputList.length == 2) {
                    boolean neighborFound = false;
                    for (Province neighbor : playerArmy.getLocation().getNeighbors()) {
                        if (neighbor.getName().equalsIgnoreCase(inputList[1])) {
                            neighborFound = true;
                            Movement newMove = (playerArmy.move(neighbor));
                            if (newMove == null) {
                                System.out.println(playerArmy.getName() + " cannot move, already occupied in an action");
                            } else {

                            }
                            System.out.println("Marching from " + playerArmy.getLocName() +
                                    " to " + neighbor.getName() + "...");
                            break;
                        }
                    }
                    if (!neighborFound) {
                        System.out.println("ERROR: Province " + inputList[1] + " is not a neighboring province of " +
                                playerArmy.getLocation().getName());
                    }
                } else {
                    System.out.println("ERROR: Invalid use of 'move'. \nUSAGE: move [target province]");
                }

            // Attack another army //
            }
            else if (inputList[0].equals("attack")) {
                // TODO prevent moving while in battle,
                //  to escape a battle, the command "retreat" has to be given
                // TODO prevent duplicate battles
                if (inputList.length == 2) {

                }

            // Display status //
            } else if (inputList[0].equals("status")) {
                // TODO reformat? (this is fine right now though)
                System.out.println("Name: " + playerArmy.getName() +
                        "\nHealth: " + playerArmy.getCurrHP());

            // Display location //
            }
            else if (inputList[0].equals("loc")) {
                // TODO reformat to look pretty
                System.out.println("Current province: " + playerArmy.getLocName() +
                        "\nNeighboring provinces: " + playerArmy.getLocation().getNeighbors());

            // quit //
            }
            else if (inputList[0].equals("quit")) {
                break;
            }
            else {
                System.out.println("ERROR: Invalid command");
            }

        }
        System.out.println("Quitting...");

        // interpret input
    }
}
