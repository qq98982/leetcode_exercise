package com.home.henry.others.zcy;

import java.util.Stack;

public class MaximalRectangle {
    public static int maxmalRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            // maxRecFromBottom: 以height为底计算的面积最大是多少
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    private static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int currArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, currArea);
            }
            stack.push(i);
        }
        // 栈中可能不空, 额外释放一下
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int currArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 } };
        System.out.println("6 -> " + maxmalRecSize(map));
    }
}
