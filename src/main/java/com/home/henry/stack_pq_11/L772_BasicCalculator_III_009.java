package com.home.henry.stack_pq_11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 772 Basic Calculator III
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open(and closing parentheses), the plus+or minus sign-,non-negativeintegers and empty spaces.
 * The expression string contains only non-negative integers,+,-,*,/operators , open(and closing parentheses)and empty spaces. The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of[-2147483648, 2147483647].
 * Some examples:
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * Note:Do not use theevalbuilt-in library function.
 *
 */
public class L772_BasicCalculator_III_009 {
    static class Solution {
        public static int calculate(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            Stack<Integer> nums = new Stack<>();
            Stack<Character> operators = new Stack<>();

            int i = 0;
            int num = 0;
            int n = s.length();

            while (i < n) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = c - '0';
                    while ((i + 1) < n && Character.isDigit(s.charAt(i + 1))) {
                        num = 10 * num + (s.charAt(i + 1) - '0');
                        i++;
                    }
                    nums.push(num);
                } else if (isOperator(c)) {
                    while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                        nums.push(calculate(operators.pop(), nums.pop(), nums.pop()));
                    }
                    operators.push(c);
                } else if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        nums.push(calculate(operators.pop(), nums.pop(), nums.pop()));
                    }
                    operators.pop();
                }
                i++;
            }

            while (!operators.isEmpty()) {
                nums.push(calculate(operators.pop(), nums.pop(), nums.pop()));
            }
            return nums.isEmpty() ? 0 : nums.pop();
        }

        private static boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }

        private static int calculate(char operator, int num1, int num2) {
            int res = 0;
            switch (operator) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num2 - num1;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num2 / num1;
                    break;
            }
            return res;
        }

        // check if op2 has higher precendence than op1
        private static boolean hasPrecedence(char op1, char op2) {
            if (op2 == ')' || op2 == '(') {
                return false;
            }
            if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        assert 2 == Solution.calculate("1 + 1");
        assert 42 == Solution.calculate("42");
        assert 4 == Solution.calculate(" 6-4 / 2 ");
        assert 21 == Solution.calculate("2*(5+5*2)/3+(6/2+8)");
        assert -12 == Solution.calculate("(2+6* 3+5- (3*14/7+2)*5)+3");
        assert 4 == SolutionRecursive.calculate("1 + 3");
        assert 42 == SolutionRecursive.calculate("42");
        assert 4 == SolutionRecursive.calculate(" 6-4 / 2 ");
        assert 2 == SolutionRecursive.calculate(" (6-4)");
        assert 21 == SolutionRecursive.calculate("2*(5+5*2)/3+(6/2+8)");
        assert -12 == SolutionRecursive.calculate("(2+6* 3+5- (3*14/7+2)*5)+3");
    }

    static class SolutionRecursive {
        public static int calculate(String s) {
            Deque<Character> list = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                list.add(c);
            }
            return helper(list);
        }

        static int helper(Deque<Character> s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char sign = '+';
            while (!s.isEmpty()) {
                char c = s.pop();
                if (Character.isDigit(c)) {
                    num = 10 * num + (c - '0');
                }
                if (c == '(') {
                    num = helper(s);
                }

                if ((!Character.isDigit(c) && c != ' ') || s.isEmpty()) {
                    if (sign == '+') {
                        stack.push(num);
                    } else if (sign == '-') {
                        stack.push(-num);
                    } else if (sign == '*') {
                        stack.push(stack.pop() * num);
                    } else if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }
                    sign = c;
                    num = 0;
                }
                if (c == ')') {
                    break;
                }
            }
            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }

    }
}
