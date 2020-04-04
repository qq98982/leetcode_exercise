package com.home.henry.array_01;

/**
 * 55. Jump Game
 * 可以用backtracking(复杂度高), 也可以用贪心的解法, 这里用的是贪心解法
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Input: [2,3,1,1,4] Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Input: [3,2,1,0,4] Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 * 贪心和dp都可以做, 贪心速度要快点, 要学习dp的思路
 */
public class JumpGame_L055_013 {

    static class Solution {
        public boolean canJump(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > max) {return false;}
                max = Math.max(max, nums[i] + i);
            }
            return true;
        }

        public boolean jump(int[] nums) {
            boolean[] f = new boolean[nums.length];
            f[0] = true;
            for (int i = 1; i < nums.length; i++) {
                f[i] = false;
                for (int j = 0; j < i; j++) {
                    if (f[j] && nums[j] + j >= i) {
                        f[i] = true;
                        break;
                    }
                }
            }
            return f[nums.length - 1];
        }
    }
}
