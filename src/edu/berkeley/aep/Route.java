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

    Integer costTo(Airport destination, HashSet<Airport> airports) {
        int costFromNextToDestination = next.costTo(destination, airports);
        if(Airport.AIRPORT_UNREACHABLE == costFromNextToDestination){
            return Airport.AIRPORT_UNREACHABLE;
        }
        return costFromNextToDestination+cost;
    }
}

