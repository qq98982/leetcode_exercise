package com.home.henry.array_01;

/**
 * 45. Jump Game II
 * 贪心和BFS的方法
 */
public class JumpGameII_L045_014 {

    /**
     * 走到当前能走到的最大值, 结果要+1
     */
    class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length < 2) {return 0;}
            int currMax = 0, maxNext = 0, res = 0;
            // 因为是如果到了最后一步, 不能再++了, 所以这里只要到nums.length - 1
            for (int i = 0; i < nums.length - 1; i++) {
                maxNext = Math.max(maxNext, nums[i] + i);
                if (i == currMax) {
                    res++;
                    currMax = maxNext;
                }
            }
            return res;
        }
    }

    /**
     * BFS比较巧妙, 应该学习
     */
    class SolutionBFS {
        public int jump(int[] nums) {
            if (nums == null || nums.length < 2) {return 0;}
            int level = 0, currMax = 0, maxNext = 0, i = 0;
            while (currMax - i + 1 > 0) {
                level++;
                while (i <= currMax) {
                    maxNext = Math.max(currMax, nums[i] + i);
                    if (maxNext >= nums.length - 1) {
                        return level;
                    }
                    i++;
                }
                currMax = maxNext;
            }
            return level;
        }
    }

}
