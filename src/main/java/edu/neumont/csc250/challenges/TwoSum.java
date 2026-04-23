package edu.neumont.csc250.challenges;

public class TwoSum {
    /*
    iterate through all possible combinations to check if they add up to target, excluding the same index we are starting on
    keep track of index per combination
     */
        public static int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target && i != j){
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
}