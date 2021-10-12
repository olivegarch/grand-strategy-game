package map;

/**
 * Represents the physical terrain of the province.
 *
 * @author OliveGarch
 */
public enum Terrain {

    // TODO fill out attack and defence modifiers
    /** Flat terrain */
    FLATLANDS("Flatlands", 0, 0),
    /** Hilly terrain */
    HILLS("Hills", 0, 0),
    /** Mountainous terrain */
    MOUNTAINS("Mountains", 0, 0);

    private final String display;
    private final double attackMod;
    private final double defenceMod;

    Terrain(String display, double attackMod, double defenceMod) {
        this.display = display;
        this.attackMod = attackMod;
        this.defenceMod = defenceMod;
    }

    /**
     * Returns the string representation of the weather.
     * @return the name of the terrain
     */
    @Override
    public String toString() {return this.display;}
}
