package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 * 首尾相接, 然后去除可以不需要的
 * Input: [ [1,2], [2,3], [3,4], [1,3] ] Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Input: [ [1,2], [1,2], [1,2] ] Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Input: [ [1,2], [2,3] ] Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 * 扫描线算法, 这个比较是比较1的位置
 */
public class NonOverlappingIntervals_L435_047 {

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals == null || intervals.length <= 1) {return 0;}
            Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
            int end = intervals[0][1];
            int count = 1;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= end) {
                    end = intervals[i][1];
                    count++;
                }
            }
            return intervals.length - count;
        }

        public int eraseOverlapIntervalsSec(int[][] intervals) {
            int count = 0;
            if (intervals == null || intervals.length == 0) {return count;}
            if (intervals[0] == null || intervals[0].length == 0) {return count;}
            Arrays.sort(intervals, (x,y) -> Integer.compare(x[1], y[1]));
            int max = intervals[0][1];
            count = -1;
            for (int[] val : intervals) {
                if (val[0] < max) {
                    count++;
                } else {
                    max = Math.max(max, val[1]);
                }
            }
            return count;
        }
    }

}
