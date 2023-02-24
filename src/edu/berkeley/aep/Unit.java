package edu.berkeley.aep;

// Understands how to convert between different types of quantity
public enum Unit {

    INCH(1, Type.LENGTH),
    FOOT(12, Type.LENGTH),
    YARD(36, Type.LENGTH),
    MILE(1760 * 36, Type.LENGTH),
    TBSP(3, Type.VOLUME),
    TSP(1,Type.VOLUME),
    OZ(6, Type.VOLUME),
    CUP(48, Type.VOLUME),
    CELSIUS(9, 0, Type.TEMPERATURE),
    FAHRENHEIT(5, -32, Type.TEMPERATURE);

    private enum Type { LENGTH, VOLUME, TEMPERATURE }
    private final int ratio;
    private final Type type;
    private final int offset;

    Unit(int ratio, int offset, Type type) {
        this.ratio = ratio;
        this.type = type;
        this.offset = offset;
    }

    Unit(int ratio, Type type) {
        this(ratio, 0, type);
    }

    public int convertTo(Unit other, int magnitude) {
        if (type != other.type) {
            throw new RuntimeException("Cannot convert a " + type + " to a " + other.type);
        }
        // This conversion takes into account scale offsets as well as ratios
        return (magnitude + this.offset) * this.ratio / other.ratio - other.offset;
    }
}