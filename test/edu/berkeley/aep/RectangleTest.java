package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
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
}
