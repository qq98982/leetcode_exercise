package com.home.henry.array_01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water
 *        +
 *    +   ++ +
 *  + ++ ++++++
 * two pointer或者用单调递减栈的方法, 还有其他几种方法
 */
public class L042_TrappingRainWater_029 {

    public static class SolutionStack {
        public  static int trap(int[] height) {
            int res = 0;
            int n = height.length;
            // 少于3个, 就不会形成水坑
            if (n < 3) {return res;}
            Deque<Integer> stack = new ArrayDeque<>();
            int currIndex = 0;
            while (currIndex < n) {
                // 右边要进来的比左边高了, 这个while完成后,最高的就是这个要进来的
                while (!stack.isEmpty() && height[currIndex] > height[stack.peek()]) {
                    // bottom是中间的空槽部分
                    int bottom = stack.pop();
                    // 如果左边为空了, 没有边界, break
                    if (stack.isEmpty()) {break;}
                    // 看是左边和右边的哪个小就取哪个计算高度
                    int h = Math.min(height[stack.peek()] - height[bottom], height[currIndex] - height[bottom]);
                    int dist = currIndex - stack.peek() - 1;
                    res += dist * h;
                }
                stack.push(currIndex++);
            }
            return res;
        }
    }

    // 双指针向中间走, 这个解法不如单调栈好理解
    class SolutionTwoPointer {
        public int trap(int[] height) {
            int left = 0, right = height.length - 1, res = 0, leftMax = 0, rightMax = 0;
            while (left < right) {
                if (height[left] < height[right]) {
                    leftMax = Math.max(height[left], leftMax);
                    res += leftMax - height[left++];
                } else {
                    rightMax = Math.max(height[right], rightMax);
                    res += rightMax - height[right--];
                }
            }
            return res;
        }

        public int trap2(int[] height) {
            int l = 0, r = height.length - 1;
            int res = 0;
            int leftMax = 0, rightMax = 0;
            while (l < r) {
                leftMax = Math.max(leftMax, height[l]);
                rightMax = Math.max(rightMax, height[r]);
                if (leftMax < rightMax) {
                    res += leftMax - height[l];
                    l++;
                } else {
                    res += rightMax - height[r];
                    r--;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        assert SolutionStack.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }) == 6;
    }
}
