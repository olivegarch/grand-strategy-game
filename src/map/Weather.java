package map;

/**
 * Represents the different weather of a province.
 *
 * @author OliveGarch
 */
public enum Weather {

    // TODO fill out attack and defence modifiers
    /** Stormy weather */
    STORM("Storm", 0, 0),
    /** Clear weather */
    CLEAR("Clear", 0, 0),
    /** Rainy weather */
    RAIN("Rain", 0, 0),
    /** Snowy weather */
    SNOW("Snow", 0, 0);

    private final String display;
    private final double attackMod;
    private final double defenceMod;

    Weather(String display, double attackMod, double defenceMod) {
        this.display = display;
        this.attackMod = attackMod;
        this.defenceMod = defenceMod;
    }

    /**
     * Returns the string representation of the weather.
     * @return the name of the weather
     */
    @Override
    public String toString() {return this.display;}
}