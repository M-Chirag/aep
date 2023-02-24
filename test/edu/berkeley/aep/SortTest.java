package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortTest {

    @Test
    public void TenIsBetterThanFive(){
        Sort obj1 = new Sort(6);

        Sort obj2 = new Sort(5);
        assertEquals(obj1,obj2);
    }
}
