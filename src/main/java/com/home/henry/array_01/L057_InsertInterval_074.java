package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. Insert Interval
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * 扫描线做法, 用了3个while, 先是加入不需要更改的,再加入需要改的,最后加入不需要改的
 */
public class L057_InsertInterval_074 {
    static class Solution {
        public static int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals == null) {return intervals;}
            List<int[]> res = new ArrayList<>();
            int i = 0;
            while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                res.add(intervals[i++]);
            }
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            res.add(newInterval);
            while (i < intervals.length) {
                res.add(intervals[i++]);
            }
            return res.toArray(new int[res.size()][2]);
        }
    }

    public static void main(String[] args) {
        int[][] res = Solution.insert(
                new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } },
                new int[] { 4, 8 });
        System.out.println("[1, 2] [3, 10] [12, 16]");
        for (int[] s : res) {
            System.out.print(Arrays.toString(s) + '\t');
        }
    }
}
