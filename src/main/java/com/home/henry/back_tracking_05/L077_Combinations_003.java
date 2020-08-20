package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Example:
 * Input: n = 4, k = 2
 * Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * Notice it from 1 to n
 */
public class L077_Combinations_003 {

    // 这道题让求1到n共n个数字里k个数的组合数的所有情况，还是要用深度优先搜索DFS来解，根据以往的经验，像这种要求出所有结果的集合，
    // 一般都是用DFS调用递归来解。那么我们建立一个保存最终结果的大集合res，还要定义一个保存每一个组合的小集合out，
    // 每次放一个数到out里，如果out里数个数到了k个，则把out保存到最终结果中，否则在下一层中继续调用递归
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, new ArrayList<>(), n, k, 1);
            return res;
        }

        private void helper(List<List<Integer>> res, ArrayList<Integer> list, int n, int k, int start) {
            if (k == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            // 这里可以是i<=n-k+1提高速度,从30ms到4ms
            for (int i = start; i <= n; i++) {
                list.add(i);
                helper(res, list, n, k - 1, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    //基于这个公式 C ( n, k ) = C ( n - 1, k - 1) + C ( n - 1, k ) 所用的思想。
    //从 n 个数字选 k 个，我们把所有结果分为两种，包含第 n 个数和不包含第 n 个数。这样的话，就可以把问题转换成
    //从 n - 1 里边选 k - 1 个，然后每个结果加上 n
    //从 n - 1 个里边直接选 k 个。
    //把上边两个的结果合起来就可以了。
    static class Soluton {
        public List<List<Integer>> combine(int n, int k) {
            if (k == n || k == 0) {
                List<Integer> row = new LinkedList<>();
                for (int i = 1; i <= k; ++i) {
                    row.add(i);
                }
                return new LinkedList<>(Arrays.asList(row));
            }
            // n - 1 里边选 k - 1 个
            List<List<Integer>> result = combine(n - 1, k - 1);
            //每个结果加上 n
            result.forEach(e -> e.add(n));
            //把 n - 1 个选 k 个的结果也加入
            result.addAll(combine(n - 1, k));
            return result;
        }
    }
}
