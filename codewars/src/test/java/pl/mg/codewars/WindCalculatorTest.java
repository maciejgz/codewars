package pl.mg.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WindCalculatorTest {

    @Test
    public void correctOne() {
        assertEquals("Headwind 15 knots. Crosswind 3 knots from your left.",WindCalculator.calculateWind("18L", 170, 15));
    }
    
    @Test
    public void correctTwo(){
        assertEquals("Headwind 10 knots. Crosswind 17 knots from your left.", WindCalculator.calculateWind("22", 160, 20));
    }

}
