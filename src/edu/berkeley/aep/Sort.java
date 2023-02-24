package edu.berkeley.aep;

import java.util.Objects;

public class Sort {

    int quantity;
    public Sort(int quantity) {
        this.quantity= quantity;
    }

    boolean betterThan(Sort other){
        if (this.quantity>=other.quantity) {
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sort sort)) return false;
        if(betterThan(sort)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
