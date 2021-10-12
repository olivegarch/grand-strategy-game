package map;

/**
 * The Region class
 * Represents a cartesian map of provinces,
 *
 * @author myname
 */
public class Region {

    private String name;
    private int[][] coordMap = new int[5][5];

    public Region(String name) {
        this.name = name;
    }

}
