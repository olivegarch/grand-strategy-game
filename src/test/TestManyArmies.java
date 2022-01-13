package test;

import game.Battle;
import game.Event;
import map.Province;
import units.Army;

import java.util.Scanner;

/**
 * A test class to test advancing a day for multiple battles
 *
 * @author OliveGarch
 */
public class TestManyArmies {
    public static void main(String[] args) {
        // instantiate provinces
        Province p1 = new Province("Province 1");
        Province p2 = new Province("Province 2");
        Province p3 = new Province("Province 3");

        // instantiate 2 armies per province and the corresponding battle between them
        Army army1_1 = new Army("army1-1", p1);
        Army army1_2 = new Army("army1-2", p1);
        Battle b1 = new Battle(army1_1, army1_2);

        Army army2_1 = new Army("army2-1", p2);
        Army army2_2 = new Army("army2-2", p2);
        Battle b2 = new Battle(army2_1, army2_2);

        Army army3_1 = new Army("army3-1", p3);
        Army army3_2 = new Army("army3-2", p3);
        Battle b3 = new Battle(army3_1, army3_2);

        // make list of battles to iterate through
        Battle[] battles = {b1, b2, b3};

        // take input
        Scanner in = new Scanner(System.in);
        System.out.print("Begin battles? (enter nothing to continue, enter \"quit\" to exit)> ");
        String input = in.nextLine();

        while (!input.equals("quit")) {
            for (Event event : battles) {
                event.advanceDay();
            }
            System.out.print("> ");
            input = in.nextLine();
        }
    }
}
