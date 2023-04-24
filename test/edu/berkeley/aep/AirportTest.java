package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirportTest {

    static Airport a = new Airport();
    static Airport b = new Airport();
    static Airport c = new Airport();
    static Airport d = new Airport();
    static Airport e = new Airport();
    static Airport f = new Airport();
    static Airport g = new Airport();
    static Airport h = new Airport();

    static {
        h.addRoute(b, 87);
        b.addRoute(a,179 );
        a.addRoute(f,  72);
        b.addRoute(c, 402);
        c.addRoute(d, 126);
        c.addRoute(e, 749);
        c.addRoute(e, 320);
        d.addRoute(e, 79);
        e.addRoute(b, 312);
    }

    @Test
    public void airportShouldBeAbleToReachItself() {
        assertTrue(a.canReach(a));
    }

    @Test
    public void airportShouldBeAbleToReachChild() {
        assertTrue(h.canReach(b));
    }

    @Test
    public void airportShouldNotBeAbleToReachUnconnectedAirport() {
        assertFalse(h.canReach(g));
    }

    @Test
    public void hopsFromBToCShouldBe1() {
        assertEquals(1, b.hopsTo(c));
    }

    @Test
    public void hopsFromBToDShouldBe2() {
        assertEquals(2, b.hopsTo(d));
    }

    @Test
    public void hopsFromBToEShouldBe2() {
        assertEquals(2, b.hopsTo(e));
    }

    @Test
    public void hopsFromCToBShouldBe2() {
        assertEquals(2, c.hopsTo(b));
    }

    @Test
    public void minimumCostOfBtoEIs517(){
        assertEquals(517, c.costTo(b));
    }

    @Test
    public void minimumCostOfHtoEIs694(){
        assertEquals(694, h.costTo(e));
    }
}
