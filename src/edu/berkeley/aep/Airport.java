package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Airport {

    public static final int AIRPORT_UNREACHABLE = -1;
    List<Airport> neighbors = new ArrayList<>();

    List<Route> routes = new ArrayList<>();

    public boolean canReach(Airport other) {
        return canReach(other, new HashSet<>());
    }

    public boolean canReach(Airport other, Set<Airport> visited) {
        if (other == this) return true;
        if (!visited.add(this)) return false;
        for (var airport: neighbors) {
            if (airport.canReach(other, visited)) return true;
        }
        return false;
    }

    public void addRoute(Airport destination, Integer cost) {
        neighbors.add(destination);
        routes.add(new Route(destination, cost));
    }

    public int hopsTo(Airport to) {
        return hopsTo(to, new HashSet<>());
    }

    public int hopsTo(Airport to, Set<Airport> visited) {
        if (to.equals(this)) {
            return 0;
        }
        if (!visited.add(this)) {
            return AIRPORT_UNREACHABLE;
        }
        int minHops = Integer.MAX_VALUE;
        for (Airport next: neighbors) {
            int hops = next.hopsTo(to, new HashSet<>(visited));
            if (hops != AIRPORT_UNREACHABLE && hops < minHops) {
                minHops = hops;
            }
        }
        if (minHops < Integer.MAX_VALUE) {
            return minHops + 1;
        }
        return AIRPORT_UNREACHABLE;
    }

    public int costTo(Airport destination){
        return costTo(destination, new HashSet<>());
    }

    int costTo(Airport destination, Set<Airport> visited) {
        if (destination.equals(this)) {
            return 0;
        }
        if (!visited.add(this)) {
            return AIRPORT_UNREACHABLE;
        }
        int minCost = Integer.MAX_VALUE;
        for (Route next: routes) {
            int cost = next.costTo(destination, new HashSet<>(visited));

            if (cost != AIRPORT_UNREACHABLE && cost < minCost) {
                minCost = cost;
            }
        }

        if (minCost < Integer.MAX_VALUE) {
            return minCost;
        }
        return AIRPORT_UNREACHABLE;
    }
}