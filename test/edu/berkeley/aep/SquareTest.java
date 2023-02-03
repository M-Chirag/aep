package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {

    @Test
    public void squareWithSide2ShouldHaveAreaFour(){
        Square sq = new Square(2);

        assertEquals(sq.area(),4);
    }

    @Test
    public void squareWithSide2ShouldHavePerimeterEight(){
        Square sq = new Square(2);

        assertEquals(sq.perimeter(), 8);
    }
}
