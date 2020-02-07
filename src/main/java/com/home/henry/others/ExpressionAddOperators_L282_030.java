package com.home.henry.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 282. Expression Add Operators
 * 典型的back tracking问题, 三个版本, 后两个分别是用StringBuilder和char array优化
 * 后两个保留用StringBuilder要用setLength()方法, 否则leetcode不通过
 */
public class ExpressionAddOperators_L282_030 {

    static class SolutionOri {
        List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();

            helper(res, "", num, target, 0, 0, 0);
            return res;
        }

        private void helper(List<String> res, String path, String str, int target, int pos, long val,
                            long pre) {
            if (pos == str.length()) {
                if (target == val) {
                    res.add(path);
                    return;
                }
            }
            for (int i = pos; i < str.length(); i++) {
                if (i != pos && str.charAt(pos) == '0') {break;}
                long cur = Long.parseLong(str.substring(pos, i + 1));
                if (pos == 0) {
                    helper(res, path + cur, str, target, i + 1, cur, cur);
                } else {
                    helper(res, path + "+" + cur, str, target, i + 1, val + cur, cur);
                    helper(res, path + "-" + cur, str, target, i + 1, val - cur, -cur);
                    helper(res, path + "*" + cur, str, target, i + 1, val - pre + pre * cur, pre * cur);
                }
            }
        }
    }

    static class Solution {
        List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            StringBuilder path = new StringBuilder();
            helper(res, path, num.toCharArray(), target, 0, 0, 0);
            return res;
        }

        void helper(List<String> res, StringBuilder path, char[] ch, int target, int pos, long val,
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
        SumToTarget_FB.Solution s = new SumToTarget_FB.Solution();
        System.out.println(s.sumToTarget("1234567890", 100));
        System.out.println(s.sumToTarget("1230", 6));
        System.out.println(s.sumToTarget("00", 0));
        System.out.println(s.sumToTarget("34", 1));
    }
}
