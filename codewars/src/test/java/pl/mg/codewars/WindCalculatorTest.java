package pl.mg.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WindCalculatorTest {

    @Test
    public void correctOne() {
        assertEquals(null,WindCalculator.calculateWind("18L", 170, 15));
    }

}
