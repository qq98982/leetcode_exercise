package com.home.henry.array_01;

/**
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai)
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
public class L011_ContainerWithMostWater_028 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
