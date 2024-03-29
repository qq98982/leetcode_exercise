package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Input: [[1,4],[4,5]] Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * 很重要, 扫描线算法, 类似题目有252 253 435
 */
public class L056_MergeIntervals_046 {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {return intervals;}
        // init, should sort arrays
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> res = new ArrayList<>();
        int[] start = intervals[0];
        // add old one
        res.add(start);
        for (int[] entry : intervals) {
            // new one's first number is not big enough, should merge
            if (entry[0] <= start[1]) {
                // update old one's 1 from maximum of itself and new one's second number
                start[1] = Math.max(entry[1], start[1]);
            } else {
                // new array's first number is bigger than old one's second number, add and update
                start = entry;
                res.add(start);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] res = merge(arr);
        System.out.println("[1, 6] [8, 10] [15, 18]");
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}
