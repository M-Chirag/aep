package edu.berkeley.aep;

import java.util.Objects;

// Understands the conversion of different length units
public class LengthUnitConversion {

    private int length;

    private Unit unit;

    public LengthUnitConversion(int length, Unit unit) {
        this.length = length;
        this.unit = unit;
    }

//    Delegation Example
    //using enum prevents error at run-time as the errors get caught at compile-time
    public enum Unit {

        //    instances of enum
        INCH(1), FOOT(12), YARD(36), MILE(36*1760);

        private int conversionFactor;

        Unit(int conversionFactor){
            this.conversionFactor = conversionFactor;
        }

    public int convertTo(Unit unit, int magnitude) {
        return magnitude * conversionFactor / unit.conversionFactor;
    }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LengthUnitConversion that)) return false;
        return length == that.length && unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, unit);
    }
}
