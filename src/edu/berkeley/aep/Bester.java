package edu.berkeley.aep;

public class Bester {
    private final Bestable quantities[];

    public Bester(Bestable... quantities) {
        if (quantities.length<1){
            throw new RuntimeException("Empty List");
        }
        this.quantities = quantities;
    }

    public Bestable best(){
        if (quantities.length==0) throw new RuntimeException("Empty List!");
        Bestable bestQuantity = quantities[0];
        for (Bestable quantity: quantities){
            if (quantity.betterThan(bestQuantity)){
                bestQuantity=quantity;
            }
        }
        return bestQuantity;
    }
}
