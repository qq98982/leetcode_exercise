package com.home.henry.array_01;

/**
 * 985. Sum of Even Numbers After Queries
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 *
 * Track sum of all even #s.
 * There are 4 cases for odd / even property of A[k] and queries[i][0], where k = queries[i][1]:
 * 1). even and odd, lose an even item in A; sum need to deduct A[k];
 * 2). even and even, get a bigger even item in A; sum need to add queries[i][0](same as deduct A[k] first then add both);
 * 3). odd and odd, get a bigger even item in A; sum need to add both;
 * 4). odd and even, no influence on even items in A;
 *
 * Therefore, we can simplify the above as following procedure:
 *
 * find sum of all even #s;
 * for each queries, check the item in A and after-added-up value, if
 * a) the item in A is even, deduct it from sum; according to 1) & 2).
 * b) after-added-up we have an even value, then add the new value to sum; according to 2) & 3).
 * 这个题目比较巧妙, 先加起来, 后面先判断要不要再减, 后面再完成其他的判断
 */
public class L985_SumOfEvenNumbersAfterQueries_042 {

    static class Solution {
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int[] res = new int[queries.length];
            int sum = 0, i = 0;
            for (int a : A) {
                if (a % 2 == 0) {
                    sum += a;
                }
            }
            for (int[] q : queries) {
                if (A[q[1]] % 2 == 0) {
                    sum -= A[q[1]];
                }
                A[q[1]] += q[0];
                if (A[q[1]] % 2 == 0) {
                    sum += A[q[1]];
                }
                res[i++] = sum;
            }
            return res;
        }
    }

}
