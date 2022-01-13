package test;

import game.Battle;
import map.Province;
import map.Terrain;
import map.Vegetation;
import org.junit.Test;
import units.Army;

import java.util.Scanner;

/**
 * A test class for Army.
 *
 * @author OliveGarch
 */

public class TestArmy {

    public static void main(String[] args) {
        Province southfield = new Province("Southfield");
        Army army1 = new Army("army1", southfield);
        Army army2 = new Army("army2", southfield);
        Battle battle1 = new Battle(army1, army2);
        Scanner in = new Scanner(System.in);

        battle1.advanceDay();

        String input = in.nextLine();
        while (!input.equals("quit")) {
            battle1.advanceDay();
            input = in.nextLine();
        }
        in.close();
    }
}
