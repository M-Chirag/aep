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

    Integer costTo(Airport destination, HashSet<Airport> visited, RouteStrategy strategy) {
        int costFromNextToDestination = next.costTo(destination, visited, strategy);
        if(Airport.AIRPORT_UNREACHABLE == costFromNextToDestination){
            return Airport.AIRPORT_UNREACHABLE;
        }
        return costFromNextToDestination+strategy.cost(this);
    }
    static RouteStrategy HOPS_STRATEGY = new RouteStrategy() {
        @Override
        public int cost(Route route) {
            return 1;
        }
    };

    static RouteStrategy COST_STRATEGY = new RouteStrategy() {
        @Override
        public int cost(Route route) {
            return route.cost;
        }
    };
}

