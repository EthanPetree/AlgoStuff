package edu.neumont.csc250.challenges;

import edu.neumont.csc250.sorting.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addBasicAdditionCase(){
        //Assemble
        int actual;
        int expected = 10;

        //Act
        actual = Calculator.add(5, 5);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void divideByZeroThrowsCorrectError(){
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
    }

    @Test
    void subtractNegativeAndPostiveNumber(){
        int expected = 40;

        //Act
        int actual = Calculator.subtract(25, -15);

        //Assert
        assertEquals(expected, actual);
    }

}