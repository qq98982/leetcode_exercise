package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1288. Remove Covered Intervals
 *
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.
 * Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 * After doing so, return the number of remaining intervals.
 *
 * Input: intervals = [[1,4],[3,6],[2,8]] Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 * Input: intervals = [[1,4],[2,3]] Output: 1
 * Input: intervals = [[0,10],[5,12]] Output: 2
 * Input: intervals = [[3,10],[4,10],[5,11]] Output: 2
 * Input: intervals = [[1,2],[1,4],[3,4]] Output: 1
 * Constraints:
 * 1 <= intervals.length <= 1000
 * intervals[i].length == 2
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * All the intervals are unique.
 *
 * 第一种根据56题做的,放入到一个list中, 第二种方法较快, 如果没有完全被盖住就++, 然后不管怎样, 都更新右边的大小
 */
public class L1288_RemoveCoveredIntervals_047 {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            if (intervals == null || intervals.length <= 1) {return intervals.length;}
            Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
            List<int[]> res = new ArrayList<>();
            int[] start = intervals[0];
            res.add(start);
            for (int[] entry : intervals) {
                if (entry[0] >= start[0] && entry[1] <= start[1]) {
                    continue;
                } else if (entry[0] == start[0] && entry[1] > start[1]) {
                    start[1] = entry[1];
                } else {
                    start = entry;
                    res.add(start);
                }
            }
            return res.size();
        }
    }

    static class SolutionSec {
        public static int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            int left = -1, right = -1, result = 0;

            for (int[] interval : intervals) {
                // 等价于 第一个元素==left或者第二个元素<=right, 都不会result++
                if (interval[0] > left && interval[1] > right) {
                    result++;
                    left = interval[0];
                }
                // 都会更新右边的大小, 右边的保持最大
                right = Math.max(right, interval[1]);
            }

            return result;
        }
    }

}
