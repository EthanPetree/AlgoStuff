package edu.neumont.csc250.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSumsTestOne(){
        //Arrange
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] expected = {0,1};

        //Act
        int[] result = TwoSum.twoSum(nums, target);

        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void twoSumsTest2(){
        int[] nums = {3,2,4};
        int target = 6;
        int[] expected = {1,2};

        int[] result = TwoSum.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

    @Test
    void twoSumsTest3(){
//Input: nums = [3,3], target = 6
//Output: [0,1]
        int[] nums = {3,3};
        int target = 6;
        int[] expected = {0,1};

        int[] result = TwoSum.twoSum(nums, target);

        assertArrayEquals(expected, result);
    }

}