package com.home.henry.stack_pq_06;

import java.util.Stack;

/**
 * 224. Basic Calculator
 * 重复数字位的时候使用累加的办法
 * 有(时将以前的结果存入stack和(前的符号存入, reset result, 开始重新计算, 在)时现在的result和以前的符号相乘, 加上以前的result
 */
public class BasicCalculator_L224_008 {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }

}