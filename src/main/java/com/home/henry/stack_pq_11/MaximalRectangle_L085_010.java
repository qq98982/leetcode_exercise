package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 85. Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 *
 * Input: [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 *  Output: 6
 *
 *  还是做为单调递增栈处理, 比84稍微复杂一点
 */
public class MaximalRectangle_L085_010 {

    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {return 0;}
            if (matrix[0] == null || matrix[0].length == 0) {return 0;}
            int[] height = new int[matrix[0].length + 1];
            height[matrix[0].length] = 0;
            int res = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '1') {
                        height[j]++;
                    } else {
                        height[j] = 0;
                    }
                }
                // every row, height has data
                int area = area(height);
                res = Math.max(res, area);
            }
            return res;
        }

        public static int area(int[] height) {
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            for (int i = 0; i < height.length; i++) {
                int h = height[i];
                while (!stack.isEmpty() && h < height[stack.peek()]) {
                    int hh = height[stack.pop()];
                    int start = stack.isEmpty() ? -1 : stack.peek();
                    int width = i - start - 1;
                    int area = hh * width;
                    res = Math.max(res, area);
                }
                stack.push(i);
            }
            return res;
        }
    }
}
