package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each
 * bar is 1, find the area of largest rectangle in the histogram.
 *
 * 单调递增栈 同类问题的可以用类似解法
 * 要点: 最后加一个高度为0, 最左边界为-1, 然后才是0
 */
public class LargestRectangleInHistogram_L084_009 {
    static class Solution {
        static public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) {return 0;}
            // save index in stack
            Stack<Integer> stack = new Stack<>();
            int res = 0;

            // last of heights save "0", so i <=heights.length
            // count from left to right, when number < stack.peek(),  compute from right to left
            // and find max
            for (int i = 0; i <= heights.length; i++) {
                // every h of col
                int h = i == heights.length ? 0 : heights[i];
                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int start = stack.isEmpty() ? -1 : stack.peek();
                    int area = height * (i - start - 1);
                    res = Math.max(res, area);
                }
                stack.push(i);
            }
            stack.clear();
            return res;
        }
    }

    public static void main(String[] args) {
        assert Solution.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }) == 10;
    }
}
