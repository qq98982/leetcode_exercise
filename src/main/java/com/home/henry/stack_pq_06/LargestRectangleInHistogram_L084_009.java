package com.home.henry.stack_pq_06;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * 同类问题的可以用类似解法
 */
public class LargestRectangleInHistogram_L084_009 {

    public int largestRectangleArea(int[] heights) {
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
        return res;
    }

}
