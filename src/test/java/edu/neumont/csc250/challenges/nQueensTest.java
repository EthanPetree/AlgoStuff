package edu.neumont.csc250.challenges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class nQueensTest {
    @Test
    void nQueenValidationTests(){
        int[] queens = {1, 3, 0, 2};

        boolean result = nQueensChallenge.validate(queens, 3);

        assertEquals(true, result);
    }

    @Test
    void nQueenFindsAllSolutionsForN4(){
        ArrayList<int[]> solutions = new ArrayList<>();

        nQueensChallenge.nQueens(4, 0, 0, new int[4], solutions);

        assertEquals(2, solutions.size());
    }

    @Test void nQueenContainsCorrectSolutionFor4(){
        ArrayList<int[]> solutions = new ArrayList<>();
        int[] expected = {1,3,0,2};

        nQueensChallenge.nQueens(4, 0, 0, new int[4], solutions);

        assertArrayEquals(expected, solutions.getFirst());
    }

    @Test
    void nQueenFindsAllSolutionsForN5(){
        ArrayList<int[]> solutions = new ArrayList<>();

        nQueensChallenge.nQueens(5, 0, 0, new int[5], solutions);

        assertEquals(10, solutions.size());
    }

    @Test
    void nQueenFindsAllSolutionsForN9(){
        ArrayList<int[]> solutions = new ArrayList<>();

        nQueensChallenge.nQueens(9, 0, 0, new int[9], solutions);

        assertEquals(352, solutions.size());
    }
}