package com.home.henry.array_01;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * 很巧妙的方法, 放入set中, 然后取出其中一个值, 向下删除, 向上删除, 知道连续的数目, 然后找下一个数字
 */
public class LongestConsecutiveSequence_L128_031 {

    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {return 0;}
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }

            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int down = nums[i] - 1;
                while (set.contains(down)) {
                    set.remove(down);
                    down--;
                }

                int up = nums[i] + 1;
                while (set.contains(up)) {
                    set.remove(up);
                    up++;
                }

                res = Math.max(res, up - down - 1);
            }
            return res;
        }
    }
}
