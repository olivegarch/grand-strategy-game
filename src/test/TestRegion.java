package test;

import map.Province;
import map.Region;

/**
 * The test class for Region.
 *
 * @author OliveGarch
 */
public class TestRegion {
    public static void main(String[] args) {
        Region region1 = new Region("Region1");
        String provinces = "Hills Plains Forest Riverbed";
        region1.generateMap(provinces);
        System.out.println(region1);
    }
}
