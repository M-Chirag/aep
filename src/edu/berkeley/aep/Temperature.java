package edu.berkeley.aep;

import java.util.Objects;

public class Temperature {

    private final double magnitude;
    private final Unit unit;
    public Temperature(double magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public enum Unit{
        FAHR, CELS;
    }

    Temperature convert(){
        if (this.unit.equals(Unit.CELS)){
            return convertToFahr();
        }
        else{
            return convertToCels();
        }
    }

    private Temperature convertToCels() {
        return new Temperature((this.magnitude-32)*(5/9), Unit.CELS);
    }

    private Temperature convertToFahr() {
        return new Temperature(this.magnitude*(9/5)+32, Unit.FAHR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temperature that)) return false;
        if(this.unit.equals(that.unit))
            return this.magnitude==that.magnitude;
        return magnitude==that.convert().magnitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(magnitude, unit);
    }
}
