/*
 * Calculator Demo Unit tests
 */
package com.demo.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    @Test
    public void testSum() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.sum(5, 5) );
    }

}
