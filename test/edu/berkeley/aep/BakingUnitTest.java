package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BakingUnitTest {

    @Test
    public void OneCupShouldBeFortyEightTSP(){
        BakingUnit cup = new BakingUnit(1, BakingUnit.BakeEnum.CUP);
        BakingUnit tsp = new BakingUnit(48, BakingUnit.BakeEnum.TABLESPOON);

        assertEquals(cup, tsp);
    }
}
