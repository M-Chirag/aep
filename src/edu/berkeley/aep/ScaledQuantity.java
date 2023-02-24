package edu.berkeley.aep;

public class ScaledQuantity implements Bestable<ScaledQuantity> {
    protected final int magnitude;
    protected final Unit unit;

    public ScaledQuantity(int magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        return magnitude * unit.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof ScaledQuantity otherQuantity)) return false;
        return magnitude == otherQuantity.convertTo(unit).magnitude;
    }

    protected ArithmeticQuantity convertTo(Unit unit) {
        return new ArithmeticQuantity(this.unit.convertTo(unit, magnitude), unit);
    }

    @Override
    public boolean betterThan(ScaledQuantity other){
        return this.magnitude>other.convertTo(unit).magnitude;
    }

    @Override
    public String toString() {
        return magnitude + " " + unit;
    }
}