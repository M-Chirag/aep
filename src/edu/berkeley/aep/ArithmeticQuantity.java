package edu.berkeley.aep;

import java.util.ArrayList;

// Understands various physical units and how to compare them
public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(int magnitude, Unit unit) {
        super(magnitude, unit);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        return new ArithmeticQuantity(other.convertTo(unit).magnitude + magnitude, unit);
    }


    public static ScaledQuantity best(ScaledQuantity... quantities){
        if (quantities.length==0) throw new RuntimeException("Empty List!");
        ScaledQuantity bestQuantity = quantities[0];
        for (ScaledQuantity quantity: quantities){
            if (quantity.betterThan(bestQuantity)){
                bestQuantity=quantity;
            }
        }
        return bestQuantity;
    }
}