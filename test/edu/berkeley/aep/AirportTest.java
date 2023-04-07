package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AirportTest {

    @Test
    public void hShouldReachItself(){
        Airport a = new Airport();
        assertTrue(a.reachTo(a));
    }

    @Test
    public void bCanReachC() {
        Airport a = new Airport();
        Airport c = new Airport();
        Airport b = new Airport();
        b.addNeighbor(a);
        b.addNeighbor(c);
        assertTrue(b.reachTo(c));
    }
    @Test
    public void hCanReachC() {
        Airport a = new Airport();
        Airport c = new Airport();
        Airport b = new Airport();
        Airport h = new Airport();
        h.addNeighbor(b);
        b.addNeighbor(a);
        b.addNeighbor(c);
        assertTrue(b.reachTo(c));
    }

}
