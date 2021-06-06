package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 227. Basic Calculator II
 *
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * Input: s = "3+2*2" Output: 7
 * Input: s = " 3/2 " Output: 1
 * Input: s = " 3+5 / 2 " Output: 5
 *
 * 这个题的解法稍微改变下, 加入Deque和递归, 就可以解决772加入的括号的问题
 */
public class L227_BasicCalculatorII_008 {

    class Solution {
        public int calculate(String s) {
            char[] ch = s.toCharArray();
            char sign = '+';
            int num = 0;
            Stack<Integer> stk = new Stack<>();
            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }
                if ((!Character.isDigit(c) && c != ' ') || i == ch.length - 1) {
                    if (sign == '+') {
                        stk.push(num);
                    } else if (sign == '-') {
                        stk.push(-num);
                    } else if (sign == '*') {
                        stk.push(stk.pop() * num);
                    } else if (sign == '/') {
                        stk.push(stk.pop() / num);
                    }
                    num = 0;
                    sign = c;
                }
            }
            int res = 0;
            while (!stk.isEmpty()) {
                res += stk.pop();
            }
            return res;
        }
    }
}
