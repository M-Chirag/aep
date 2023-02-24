package edu.berkeley.aep;

import java.math.BigDecimal;
import java.util.Objects;

public class Chance implements Bestable<Chance> {

    private final BigDecimal probability;


    public Chance(BigDecimal probability) {
        this.probability=probability;
    }

    public Chance not(){
        return new Chance(BigDecimal.valueOf(1).subtract(probability));
    }

    public Chance and(Chance other) {
        return new Chance(other.probability.multiply(this.probability));
    }

    public Chance or(Chance other) {
        return new Chance(other.probability.add(this.probability).subtract(other.probability.multiply(this.probability)));
    }

    @Override
    public boolean betterThan(Chance other){
        return this.probability.compareTo(other.probability)>=0;
    }
    @Override
    public String toString() {
        return "Chance{" +
                "probability=" + probability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chance chance)) return false;
        return Objects.equals(probability, chance.probability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(probability);
    }


}
