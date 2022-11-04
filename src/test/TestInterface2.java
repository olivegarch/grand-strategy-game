package test;

import command.Action;
import command.MoveArmyAction;
import game.*;
import map.Map;
import map.Province;
import units.Army;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * A test class to write a PTUI for the player to interact with the game
 *
 * @author OliveGarch
 */
public class TestInterface2 {
    public static void main(String[] args) {

        // make the players
        Player player1 = new Player("Alex");
        Player player2 = new Player("Computer");

        // make the game
        Game game = new Game(player1, player2);

        // make the map
        Map map = new Map("Map1");
        map.generateStdMap("Hills Forest Fields Town");

        // make player armies
        player1.addArmy(new Army("AlexArmy", map.getProvinceByName("Hills")));
        player2.addArmy(new Army("CompArmy", map.getProvinceByName("Forest")));

        HashMap<String, Action> commands = new HashMap<>();
        commands.put("move", new MoveArmyAction(game));



        // welcome message
        System.out.println("WELCOME TO THE BATTLEFIELD");
        System.out.println("This is the playground to test features of the game in progress");

        // prompt user
        String helpMsg = "Commands: " +
                "\n- quit" +
                "\n- help" +
                "\n- day (advances the time forward one day)"+
                "\n[TODO]- move [army name] [province] (moves your army to an adjacent province)" +
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

            // Display help message //
            if (input.equals("help")) {
                System.out.println(helpMsg);

            // Advance one day //
            }
            else if (input.equals("day")) {
                game.advanceDay();

            // Move between provinces //
            }
            else if (input.equals("move")) {
                // TODO prevent moving while already performing a movement.
                //  Alternatively, you can allow another movement,
                //  but it replaces the old one, starting over from 0.
                //  (Kinda like HOI4)

                // TODO test out making move while already performing an action.


//                ArrayList<String> destinations = new ArrayList<>();
//                destinations.add(inputList[2]);
//                game.createMovement(player1, inputList[1], destinations);

//                if (inputList.length == 2) {
//                    boolean neighborFound = false;
//                    for (Province neighbor : playerArmy.getLocation().getNeighbors()) {
//                        if (neighbor.getName().equalsIgnoreCase(inputList[1])) {
//                            neighborFound = true;
//                            Movement newMove = (playerArmy.move(neighbor));
//                            if (newMove == null) {
//                                System.out.println(playerArmy.getName() + " cannot move, already occupied in an action");
//                            } else {
//
//                            }
//                            System.out.println("Marching from " + playerArmy.getLocName() +
//                                    " to " + neighbor.getName() + "...");
//                            break;
//                        }
//                    }
//                    if (!neighborFound) {
//                        System.out.println("ERROR: Province " + inputList[1] + " is not a neighboring province of " +
//                                playerArmy.getLocation().getName());
//                    }
//                } else {
//                    System.out.println("ERROR: Invalid use of 'move'. \nUSAGE: move [target province]");
//                }

//            // Attack another army //
//            }
//            else if (input.equals("attack")) {
//                // TODO prevent moving while in battle,
//                //  to escape a battle, the command "retreat" has to be given
//                // TODO prevent duplicate battles
//                if (inputList.length == 2) {
//
//                }
//
//            // Display status //
            }
            else if (input.equals("status")) {
                // TODO reformat? (this is fine right now though)
                System.out.println("Name: " + player1.getArmyByName("AlexArmy").getName() +
                        "\nHealth: " + player1.getArmyByName("AlexArmy").getCurrHP());

            // Display location //
            }
            else if (input.equals("loc")) {
                // TODO reformat to look pretty
                System.out.println("Current province: " + player1.getArmyByName("AlexArmy").getLocName() +
                        "\nNeighboring provinces: " + player1.getArmyByName("AlexArmy").getLocation().getNeighbors());

            // quit //
            }
            else if (input.equals("quit")) {
                System.out.println("Goodbye");
                break;
            }
            else {
                System.out.println("Invalid command. Type 'help' for a list of commands.");
            }

        }
        System.out.println("Quitting...");

        // interpret input
    }
}
