package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 1051. Height Checker
 * Input: [1,1,4,2,1,3]
 * Output: 3 Explanation: Students with heights 4, 3 and the last 1 are not standing in the right positions.
 * 1 <= heights.length <= 100 1 <= heights[i] <= 100
 * 这个题目是看多少人按身高排列没有在正确的位置上
 * 有方法是排序, 这个方法是用bucket排序, 因为height有限定条件
 * 如果没有限定范围,可以用第二种的排序方法
 */
public class L1051_HeightChecker_038 {
    static class Solution {

        public int heightChecker(int[] heights) {
            int[] count = new int[101];
            for (int i = 0; i < heights.length; i++) {
                count[heights[i]]++;
            }
            int res = 0, curr = 0;
            for (int i = 0; i < heights.length; i++) {
                while (count[curr] == 0) {
                    curr++;
                }
                if (curr != heights[i]) {
                    res++;
                }
                count[curr]--;
            }
            return res;
        }
    }

    static class SolutionSort {
        public int heightChecker(int[] heights) {
            int[] copy = heights.clone();
            Arrays.sort(copy);
            int count = 0;
            for (int i = 0; i < copy.length; i++) {
                if (heights[i] != copy[i]) { count++; }
            }
            return count;
        }
    }
}
