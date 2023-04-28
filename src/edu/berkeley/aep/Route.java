package edu.berkeley.aep;

import java.util.HashSet;

//Understands the cost of flying between two airports
public class Route {


    private final Airport next;
    private final Integer cost;

    public Route(Airport next, Integer cost) {
        this.next = next;
        this.cost = cost;
    }

    Integer costTo(Airport destination, HashSet<Airport> visited, boolean calculateCost) {
        int costFromNextToDestination = next.costTo(destination, visited, calculateCost);
        if(Airport.AIRPORT_UNREACHABLE == costFromNextToDestination){
            return Airport.AIRPORT_UNREACHABLE;
        }
        int myCost = calculateCost? cost:1;
        return costFromNextToDestination+myCost;
    }
}

