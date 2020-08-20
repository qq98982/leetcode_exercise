package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 932. Beautiful Array
 *
 * For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N,
 * such that:
 * For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].
 * Given N, return any beautiful array A.  (It is guaranteed that one exists.)
 * Input: 4 Output: [2,1,4,3]
 * Input: 5 Output: [3,1,2,5,4]
 * 观察左边都是奇数,右边都是偶数是符合这个定义的.在这个基础上,每个数字*2是符合要求的,然后相加也是符合要求的.
 * 用迭代的方式, 求出结果
 */
public class L932_BeautifulArray_035_1 {

    static class Solution {
        public static int[] beautifulArray(int N) {
            if (N < 1) {return new int[] {};}
            List<Integer> res = new ArrayList<>();
            res.add(1);
            while (res.size() < N) {
                List<Integer> tmp = new ArrayList<>();
                for (int n : res) {
                    if (2 * n - 1 <= N) {
                        tmp.add(2 * n - 1);
                    }
                }
                for (int n : res) {
                    if (2 * n <= N) {
                        tmp.add(2 * n);
                    }
                }
                res = tmp;
            }
            return res.stream().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.beautifulArray(8)));
    }
}
