package pl.mg.codewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitCountingTest {

    @Test
    public void testCountBits() {
        assertEquals(5, BitCounting.countBits(1234)); 
        assertEquals(1, BitCounting.countBits(4)); 
        assertEquals(3, BitCounting.countBits(7)); 
        assertEquals(2, BitCounting.countBits(9)); 
        assertEquals(2, BitCounting.countBits(10)); 
    }

}