package com.home.henry.array_01;

/**
 * 1014. Best Sightseeing Pair
 *
 * Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two
 * sightseeing spots i and j have distance j - i between them.
 *
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the
 * sightseeing spots, minus the distance between them.
 *
 * Return the maximum score of a pair of sightseeing spots.
 *
 * Input: [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * Note:
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 *
 * 最好观测点是选当前的点和前面的点相加后最大, 注意如果在移动,每次应该-1进行滚动更新
 */
public class BestPairSightSeeing_L1013_034_1 {
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            if (A == null || A.length == 0) {return 0;}
            int res = 0, cur = 0;
            for (int i = 0; i < A.length; i++) {
                res = Math.max(res, cur + A[i]);
                cur = Math.max(A[i], cur) - 1;
            }
            return res;
        }
    }
}
