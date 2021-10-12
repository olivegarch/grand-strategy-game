package map;

/**
 * Represents the vegetation of the province.
 *
 * @author OliveGarch
 */
public enum Vegetation {

    // TODO fill out attack and defence modifiers
    /** Barren vegetation */
    BARREN("Barren", 0, 0),
    /** Grassy vegetation */
    GRASSLAND("Grassy", 0, 0),
    /** Shrubby vegetation */
    SHRUBLAND("Shrubby", 0, 0),
    /** Forested vegetation */
    FOREST("Forested", 0, 0);

    private final String display;
    private final double attackMod;
    private final double defenceMod;

    Vegetation(String display, double attackMod, double defenceMod) {
        this.display = display;
        this.attackMod = attackMod;
        this.defenceMod = defenceMod;
    }

    /**
     * Returns the string representation of the weather.
     * @return the adjective to describe the vegetation
     */
    @Override
    public String toString() {return this.display;}
}
