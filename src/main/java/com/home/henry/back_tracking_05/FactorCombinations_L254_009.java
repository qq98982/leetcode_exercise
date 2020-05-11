package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 254. Factor Combinations
 *
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer  n  and return all possible combinations of its factors.
 *
 * Note:
 *
 * You may assume that  n  is always positive.
 * Factors should be greater than 1 and less than  n.
 *
 * Input: 1
 * Output: []
 * Example 2:
 *
 * Input: 37
 * Output:[]
 *
 * Input: 12
 * Output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 *
 * Input: 32
 * Output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 *
 *
 * 这道题给了我们一个正整数n，让写出所有的因子相乘的形式，而且规定了因子从小到大的顺序排列，那么对于这种需要列出所有的情况的题目，
 * 通常都是用回溯法来求解的，由于题目中说明了1和n本身不能算其因子，那么可以从2开始遍历到n，如果当前的数i可以被n整除，
 * 说明i是n的一个因子，将其存入一位数组 out 中，然后递归调用 n/i，此时不从2开始遍历，而是从i遍历到 n/i，停止的条件是当n等于1时，
 * 如果此时 out 中有因子，将这个组合存入结果 res 中
 */
public class FactorCombinations_L254_009 {

    static class Solution {
        public static List<List<Integer>> getFactors(int n) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, new ArrayList<Integer>(), n, 2);
            return res;
        }

        private static void helper(List<List<Integer>> res, List<Integer> list, int n, int factor) {
            if (n == 1) {
                res.add(new ArrayList<Integer>(list));
                return;
            }
            for (int i = factor; i <= n; i++) {
                if (n % i != 0) {continue;}
                list.add(i);
                helper(res, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.getFactors(8));
        System.out.println(Solution.getFactors(32));
    }
}
