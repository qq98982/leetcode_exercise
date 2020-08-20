package com.home.henry.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 282. Expression Add Operators
 *
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary
 * operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Input: num = "123", target = 6 Output: ["1+2+3", "1*2*3"]
 *
 * Input: num = "232", target = 8 Output: ["2*3+2", "2+3*2"]
 *
 * Input: num = "105", target = 5 Output: ["1*0+5","10-5"]
 *
 * Input: num = "00", target = 0 Output: ["0+0", "0-0", "0*0"]
 *
 * Input: num = "3456237490", target = 9191 Output: []
 *
 * 典型的back tracking问题, 后一个用StringBuilder和char array优化
 * 用StringBuilder要用setLength()方法截取长度, 否则leetcode不能通过
 */
public class L282_ExpressionAddOperators_030 {

    static class SolutionOri {
        List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            helper(res, "", num, target, 0, 0, 0);
            return res;
        }

        List<String> addOp(String num, int target) {
            List<String> res = new ArrayList<>();
            helper2(res, "", num, target, 0, 0, 0);
            return res;
        }

        private void helper2(List<String> res, String path, String num, int target, int pos, long val,
                             long pre) {
            if (pos == num.length() && target == val) {
                res.add(path);
                return;
            }
        }

        private void helper(List<String> res, String path, String num, int target, int pos, long val,
                            long pre) {
            if (pos == num.length()) {
                if (target == val) {
                    res.add(path);
                    return;
                }
            }
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') {break;}
                long cur = Long.parseLong(num.substring(pos, i + 1));
                // 第一个数不加符号
                if (pos == 0) {
                    helper(res, path + cur, num, target, i + 1, cur, cur);
                } else {
                    helper(res, path + "+" + cur, num, target, i + 1, val + cur, cur);
                    helper(res, path + "-" + cur, num, target, i + 1, val - cur, -cur);
                    helper(res, path + "*" + cur, num, target, i + 1, val - pre + pre * cur, pre * cur);
                }
            }
        }
    }

    static class Solution {
        public static List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            StringBuilder path = new StringBuilder();
            helper(res, path, num.toCharArray(), target, 0, 0, 0);
            return res;
        }

        static void helper(List<String> res, StringBuilder path, char[] ch, int target, int pos, long val,
                           long pre) {
            if (pos == ch.length && target == val) {
                res.add(path.toString());
                return;
            }
            long cur = 0;
            for (int i = pos; i < ch.length; i++) {
                // 如果字符已经超过1位了, 第一位是0, break
                if (i != pos && ch[pos] == '0') {break;}
                cur = cur * 10 + ch[i] - '0';
                int len = path.length();
                // 第一个数不加符号
                if (pos == 0) {
                    helper(res, path.append(cur), ch, target, i + 1, cur, cur);
                    // 重置为最初的长度
                    path.setLength(len);
                } else {
                    helper(res, path.append('+').append(cur), ch, target, i + 1, val + cur, cur);
                    path.setLength(len);
                    helper(res, path.append('-').append(cur), ch, target, i + 1, val - cur, -cur);
                    path.setLength(len);
                    // 乘法需要在这里特殊处理, 比如 2 + 3 * 4 = (5 - 3) + 3 * 4
                    helper(res, path.append('*').append(cur), ch, target, i + 1, val - pre + pre * cur,
                           pre * cur);
                    path.setLength(len);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.addOperators("1234567890", 100));
        System.out.println(Solution.addOperators("1230", 6));
        System.out.println(Solution.addOperators("00", 0));
        System.out.println(Solution.addOperators("34", 1));
    }
}
