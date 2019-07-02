package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * 扫描线做法 第一种做法比较0位置, 可以不用写else
 * 第二种容易理解点
 */
public class MinimumNumberOfArrowsToBurstBalloons_L452_048 {

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points == null || points.length == 0) {return 0;}
            Arrays.sort(points, (i1, i2) -> Integer.compare(i1[1], i2[1]));
            int count = 1;
            int pos = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > pos) {
                    count++;
                    pos = points[i][1];
                }
            }
            return count;
        }
    }

    static class SolutionSec {
        public int findMinArrowShots(int[][] points) {
            if (points == null || points.length < 1) { return 0; }
            Arrays.sort(points, (a, b) -> (a[0] - b[0]));
            int result = 1;
            int end = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > end) {
                    result++;
                    end = points[i][1];
                } else {
                    end = Math.min(end, points[i][1]);
                }
            }
            return result;
        }
    }
}
