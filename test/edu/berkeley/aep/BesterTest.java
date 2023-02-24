package edu.berkeley.aep;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BesterTest {

    @Test
    public void FiveOzBetterThanThreeTbpsAnd5Tbps(){
        var threeTbsp = new ScaledQuantity(3, Unit.TBSP);
        var fiveTbsp = new ScaledQuantity(5, Unit.TBSP);
        var fiveOz = new ScaledQuantity(5, Unit.OZ);
        var bester = new Bester(threeTbsp,fiveTbsp,fiveOz);
        assertEquals(fiveOz, bester.best());

    }

    @Test
    public void PointNineShouldBeBestChance(){
        var pointThree = new Chance(BigDecimal.valueOf(0.3));
        var pointFive = new Chance(BigDecimal.valueOf(0.5));
        var pointNine = new Chance(BigDecimal.valueOf(0.9));
        var bester = new Bester(pointThree,pointFive,pointNine);
        assertEquals(pointNine, bester.best());
    }
}
