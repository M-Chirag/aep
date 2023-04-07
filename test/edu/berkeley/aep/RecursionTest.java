package edu.berkeley.aep;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RecursionTest {

    @Test
    public void reverseHShouldBeH(){
        Recursion rString = new Recursion("h");
        assertEquals("h", rString.reverse());
    }

    @Test
    public void reverseHelloShouldBeolleH(){
        Recursion rString = new Recursion("Hello");
        assertEquals("olleH", rString.reverseHelp());
    }

    @Test
    public void reverseHappyShouldBeyppaH(){
        Recursion rString = new Recursion("Happy");
        assertEquals("yppaH", rString.reverse());
    }
}
