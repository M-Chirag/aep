package edu.berkeley.aep;

import java.util.*;

// understands the connections between Airports
public class Airport {

    public static final int UNREACHABLE = -1;

    private final String name;
    private final List<Airport> neighbors;
    public Airport(String name) {
        this.name = name;
        neighbors = new ArrayList<Airport>();
    }

    public Airport(String name, List<Airport> neighbors){
        this.name = name;
        this.neighbors = Collections.unmodifiableList(neighbors);
    }
    public boolean reachTo(Airport other) {
        if(this.neighbors.contains(other) || this.equals(other)){
            return true;
        }
        for(Airport neighbor: neighbors){
            reachTo(neighbor);
        }
        return false;
    }

    public boolean isReachable(Airport destination) {
        Set<Airport> visit = new HashSet<>();
        return dfs(this, destination, null,visit);
    }


    private boolean dfs(Airport curr, Airport target, Airport parent, Set<Airport> visit) {
        if (curr == target) {
            return true;
        }
        for (Airport neighbor: curr.neighbors) {
            if (neighbor != parent && visit.add(neighbor) ) {
                boolean reached = dfs(neighbor, target, curr, visit);
                if (reached) {
                    return true;
                }
            }
        }
        return false;
    }

    public int numOfHops(Airport destination) {
        Set<Airport> visit = new HashSet<>();
        visit.add(this);
        int minHops = Integer.MAX_VALUE;
        int hops = dfsHelper(this, destination, visit);
        if (hops >= 0 && hops < minHops) {
            minHops = hops;
        }
        return minHops == Integer.MAX_VALUE ? -1 : minHops;
    }

    private int dfsHelper(Airport curr, Airport target, Set<Airport> visit) {
        if (curr == target) {
            return 0;
        }
        int minNeighborHops = Integer.MAX_VALUE;
        for (Airport neighbor : curr.neighbors) {
            if (!visit.contains(neighbor)) {
                visit.add(neighbor);
                int hops = dfsHelper(neighbor, target, visit);
                if (hops >= 0 && hops + 1 < minNeighborHops) {
                    minNeighborHops = hops + 1;
                }
                visit.remove(neighbor);
            }
        }

        if (minNeighborHops == Integer.MAX_VALUE) {
            return UNREACHABLE;
        } else {
            return minNeighborHops;
        }
    }

    public void addNeighbor(Airport other){
        this.neighbors.add(other);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", neighbors=" + neighbors +
                '}';
    }
}

