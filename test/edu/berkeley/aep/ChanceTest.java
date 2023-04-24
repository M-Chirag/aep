package edu.berkeley.aep;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ChanceTest {

    @Test
    public void notOfCoinTossShouldBeACoinToss(){
        Chance chance = new Chance(BigDecimal.valueOf(0.5));
        Chance chanceNot = new Chance(BigDecimal.valueOf(0.5));

        assertEquals(chanceNot, chance.not());
    }

    @Test
    public void andOfChanceAandBShouldBeChanceATimesChanceB(){
        Chance chanceA = new Chance(BigDecimal.valueOf(0.3));
        Chance chanceB = new Chance(BigDecimal.valueOf(0.2));

        Chance result = new Chance(BigDecimal.valueOf(0.06));
        assertEquals(chanceA.and(chanceB), result);
    }

    @Test
    public void orOfChanceAandBShouldBe(){
        Chance chanceA = new Chance(BigDecimal.valueOf(0.3));
        Chance chanceB = new Chance(BigDecimal.valueOf(0.2));

        Chance result = new Chance(BigDecimal.valueOf(0.44));

        assertEquals(chanceA.or(chanceB), result); // P(A) + P(B) - P(A).P(B)
    }

    @Test
    public void orDeMorgan(){
        Chance chanceA = new Chance(BigDecimal.valueOf(0.3));
        Chance chanceB = new Chance(BigDecimal.valueOf(0.2));

        Chance result = new Chance(BigDecimal.valueOf(0.44));

        assertEquals((chanceA.not().and(chanceB.not())).not(), result); //  !(!P(A) && !P(B))
    }
}
