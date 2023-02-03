package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    // test names should be like specification -> specifying the behavior
    @Test
    public void rectangleWithSideShouldHaveArea(){
        Rectangle rectangle = new Rectangle(6,6);
        assertEquals(36, rectangle.area());
    }

    @Test
    public void testArea(){
        Rectangle rect1 = new Rectangle(10, 5);
        assertEquals("Rectangle Area is incorrect", rect1.area(),50 );
    }

    @Test
    public void testPerimeter(){
        Rectangle rect1 = new Rectangle(10,5 );
        assertEquals("Rectangle Perimeter is incorrect", rect1.perimeter(),30);
    }

    @Test
    public void squareWithSideTwoShouldHaveAreaFour(){
        Rectangle square = Rectangle.createSquare(2);
        assertEquals(4, square.area());
    }
}
