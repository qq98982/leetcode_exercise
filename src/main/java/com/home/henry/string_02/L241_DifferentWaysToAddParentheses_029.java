package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 241. Different Ways to Add Parentheses
 *
 * Given a string of numbers and operators, return all possible results from computing all the different
 * possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Input: "2-1-1" Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Input: "2*3-4*5" Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * 加入了map做memorization
 */
public class L241_DifferentWaysToAddParentheses_029 {
    static class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            Map<String, List<Integer>> map = new HashMap<>();
            return helper(input, map);
        }

        private List<Integer> helper(String input, Map<String, List<Integer>> cache) {
            if (cache.containsKey(input)) {return cache.get(input);}
            // 是否包含运算符号
            boolean expression = false;
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                // 这个i位置的字符如果是运算符 即不是-1, 那么分别算出左边和右边的, 再算出结果加入到result中
                if ("+-*".indexOf(input.charAt(i)) != -1) {
                    List<Integer> left = helper(input.substring(0, i), cache);
                    List<Integer> right = helper(input.substring(i + 1), cache);
                    for (int l : left) {
                        for (int r : right) {
                            // 计算每一个可能的值, 加入到result中
                            int res = cal(l, r, input.charAt(i));
                            result.add(res);
                        }
                    }
                    expression = true;
                }
            }
            // 如果这个字符串整体不包含运算符, 只有数字, 因为前面没有包含这个判断, 所以也要额外加入到result中
            if (!expression) {
                result.add(Integer.parseInt(input));
            }
            // 放入cache中
            cache.put(input, result);
            return result;
        }

        private static Integer cal(Integer l, Integer r, Character c) {
            int res;
            switch (c) {
                case '+':
                    res = l + r;
                    break;
                case '-':
                    res = l - r;
                    break;
                case '*':
                    res = l * r;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + c);
            }
            return res;
        }
    }
}
