package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. Permutation Sequence
 *
 * 找到第k个permutation, 先计算出来每组permutation的数目, 然后再根据这个找到合适的数字
 * 不能用bf找到全部的permutation.根据k找到对应的factor个数,算出index,然后加入
 * 后面还要删除当前加过的值.
 * 为了好算,k要-1.
 */
public class PermutationSequence_L060_010 {

    static class Solution {

        public String getPermutation(int n, int k) {
            // list [1, 2, 3, 4]
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            int[] factor = new int[n];
            factor[0] = 1;
            for (int i = 1; i < n; i++) {
                factor[i] = i * factor[i - 1];
            }
            // factor [1, 1, 2 ,6]
            StringBuilder sb = new StringBuilder();
            k = k - 1;
            for (int i = n; i > 0; i--) {
                int index = k / factor[i - 1];
                k = k % factor[i - 1];
                sb.append(list.get(index));
                list.remove(index);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getPermutation(4, 18));
    }
}
