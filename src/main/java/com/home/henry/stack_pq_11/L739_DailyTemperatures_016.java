package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that
 * answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class L739_DailyTemperatures_016 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ans = new int[temperatures.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = temperatures.length - 1; i >= 0; i--) {
                int num = temperatures[i];
                while (!stack.isEmpty() && temperatures[stack.peek()] <= num) {
                    stack.pop();
                }
                ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return ans;
        }
    }
}
