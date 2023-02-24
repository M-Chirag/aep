package edu.berkeley.aep;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuantityTest {

    @Test
    public void oneFootShouldEqualTwelveInches() {
        var oneFoot = new ArithmeticQuantity(1, Unit.FOOT);
        var twelveInches = new ArithmeticQuantity(12, Unit.INCH);
        assertEquals(oneFoot, twelveInches);
    }

    @Test
    public void oneYardShouldEqualThreeFeet() {
        var oneYard = new ArithmeticQuantity(1, Unit.YARD);
        var threeFeet = new ArithmeticQuantity(3, Unit.FOOT);
        assertEquals(oneYard, threeFeet);
    }

    @Test
    public void oneMileShouldEqual1760Yards() {
        var oneMile = new ArithmeticQuantity(1, Unit.MILE);
        var oneMileInYards = new ArithmeticQuantity(1760, Unit.YARD);
        assertEquals(oneMile, oneMileInYards);
    }

    @Test
    public void oneTbspShouldEqualThreeTsp() {
        var oneTbsp = new ArithmeticQuantity(1, Unit.TBSP);
        var threeTsp = new ArithmeticQuantity(3, Unit.TSP);
        assertEquals(oneTbsp, threeTsp);
    }

    @Test
    public void oneOzShouldEqualTwoTbsp() {
        var oneTbsp = new ArithmeticQuantity(1, Unit.OZ);
        var twoTbsp = new ArithmeticQuantity(2, Unit.TBSP);
        assertEquals(oneTbsp, twoTbsp);
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        var oneOz = new ArithmeticQuantity(8, Unit.OZ);
        var oneCup = new ArithmeticQuantity(1, Unit.CUP);
        assertEquals(oneOz, oneCup);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        var twoInches = new ArithmeticQuantity(2, Unit.INCH);
        var fourInches = new ArithmeticQuantity(4, Unit.INCH);
        assertEquals(fourInches, twoInches.add(twoInches));
    }

    @Test
    public void twoTablespoonsPlusOneOzShouldEqualTwelveTeaspoons() {
        var twoTablespoons = new ArithmeticQuantity(2, Unit.TBSP);
        var oneOz = new ArithmeticQuantity(1, Unit.OZ);
        var twelveTeaspoons = new ArithmeticQuantity(12, Unit.TSP);
        assertEquals(twelveTeaspoons, twoTablespoons.add(oneOz));
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotBeAbleToAddFeetAndTeaspoons() {
        var oneFoot = new ArithmeticQuantity(1, Unit.FOOT);
        var oneTeaspoon = new ArithmeticQuantity(1, Unit.TSP);
        assertEquals(oneFoot, oneFoot.add(oneTeaspoon));
    }

    @Test
    public void oneHundredCelsiusShouldEqual212F() {
        var oneHundredCelsius = new ScaledQuantity(100, Unit.CELSIUS);
        var twoHundredTwelveFahrenheit = new ScaledQuantity(212, Unit.FAHRENHEIT);
        assertEquals(oneHundredCelsius, twoHundredTwelveFahrenheit);
    }

    @Test
    public void thirtyTwoFahrenheitShouldEqualZeroCelsius() {
        var zeroCelsius = new ScaledQuantity(0, Unit.CELSIUS);
        var thirtyTwoFahrenheit = new ScaledQuantity(32, Unit.FAHRENHEIT);
        assertEquals(thirtyTwoFahrenheit, zeroCelsius);
    }


}