package edu.berkeley.aep;

import java.util.HashMap;
import java.util.Objects;

public class BakingUnit {

    private int amount;

    private BakeEnum bu;

    public BakingUnit(int amount, BakeEnum bu) {
        this.amount = amount;
        this.bu = bu;
    }

    public enum BakeEnum {
        TEASPOON(1), TABLESPOON(3), OUNCE(6), CUP(48);

        private final int conversionFactor;

        BakeEnum(int conversionFactor){
            this.conversionFactor = conversionFactor;
        }

        public int convertTo(BakeEnum unit, int magnitude) {
                return magnitude * conversionFactor / unit.conversionFactor;
        }
    }

    private BakingUnit convertTo(BakeEnum unit) {
        return new BakingUnit(this.bu.convertTo(unit, amount), unit);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BakingUnit that)) return false;

        int otherAmount = that.convertTo(this.bu).amount;
        return amount == otherAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, bu);
    }

    @Override
    public String toString() {
        return "BakingUnit{" +
                "amount=" + amount +
                ", bu=" + bu +
                '}';
    }
}
