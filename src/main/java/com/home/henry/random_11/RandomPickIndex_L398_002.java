package com.home.henry.random_11;

import java.util.Random;

/**
 * 398. Random Pick Index
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *
 * Example:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 *
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 *
 * A VERY SIMPLE Explanation: : arr =[1,2,3,3,3]
 * res = -1, count =0, i=0;
 *
 * if (rnd.nextInt(++count) == 0) CAN ALSO BE if (rnd.nextInt(++count) == COUNT-1) both are same
 *
 * i= 2, (++count = 1), hence rnd.nexrInt(1) would give 0 -> res = 0;
 *
 * i= 3, (++count =2) and rnd.nextInt(2), which is like select either 0 or 1 ...
 * that is 50% chances of both . If 0 is selected... (it could have been 1 by 50%) but if its 0
 * [JUST A WAY TO SAY NOW CHANGE THE CURR INDEX TO 3] else it was 2 before and at that stamp of time
 * there are two options either 2 or 3 and selected value if not zero remains the previous;
 *
 * i=4, res could have been 2(not 3) in this case as well... WHY because reservoir sampling only takes
 * into account the curr number, assume it as in a factory setting.
 * Now, we will calculate random out of 3 values and if it is 0 -> res = 4 else.... res =0
 */
public class RandomPickIndex_L398_002 {
    static class Solution {
        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int pick(int target) {
            int result = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target) {continue;}
                if (random.nextInt(++count) == 0) {
                    result = i;
                }
            }
            return result;
        }
    }

}
