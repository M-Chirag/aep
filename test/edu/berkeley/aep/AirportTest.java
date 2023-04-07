package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirportTest {

    static Airport a = new Airport("a");
    static Airport b = new Airport("b");
    static Airport c = new Airport("c");
    static Airport d = new Airport("d");
    static Airport h = new Airport("h");
    static Airport e = new Airport("e");
    static Airport f = new Airport("f");
    static Airport g = new Airport("g");

    static{
        h.addNeighbor(b);
        b.addNeighbor(a);
        b.addNeighbor(c);
        c.addNeighbor(e);
        a.addNeighbor(f);
        c.addNeighbor(d);
        e.addNeighbor(b);
        d.addNeighbor(e);
    }

    @Test
    public void hShouldReachItself(){
        Airport a = new Airport("a");
        assertTrue(a.reachTo(a));
    }

    @Test
    public void bCanReachC() {
        Airport a = new Airport("a");
        Airport c = new Airport("c");
        Airport b = new Airport("b");
        b.addNeighbor(a);
        b.addNeighbor(c);
        assertTrue(b.reachTo(c));
    }
    @Test
    public void hCanReachC() {
        assertTrue(h.isReachable(e));
        assertFalse(h.isReachable(g));
    }

    @Test
    public void numberOfHopsToCFromHShouldBeTwo(){
        assertEquals(h.numOfAirports(d), 3);
    }

}
