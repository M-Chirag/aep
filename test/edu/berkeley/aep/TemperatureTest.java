package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperatureTest {

    @Test
    public void ZeroCelsiusShouldBe32Fahrenheit(){
        Temperature zeroC = new Temperature(0, Temperature.Unit.CELS);

        Temperature thirtyTwoC = new Temperature(0, Temperature.Unit.CELS);

        assertEquals(zeroC, thirtyTwoC);
    }
}
