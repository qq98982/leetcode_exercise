package com.home.henry.array_01;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Input: [100, 4, 200, 1, 3, 2] Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
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

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (set.isEmpty()) {
                    // 加速从7ms到5ms
                    break;
                }
                // 下面的边界MAX_VALUE, MIN_VALUE没有考虑也可以通过
                int curr = nums[i];
                int up = 0, down = 0, tmp = curr - 1;
                while (set.contains(curr)) {
                    set.remove(curr);
                    up++;
                    if (curr < Integer.MAX_VALUE) {
                        curr++;
                    } else {
                        break;
                    }
                }
                while (set.contains(tmp)) {
                    set.remove(tmp);
                    down++;
                    if (tmp > Integer.MIN_VALUE) {
                        tmp--;
                    } else {
                        break;
                    }
                }

                res = Math.max(res, up + down);
            }
            return res;
        }
    }
}
