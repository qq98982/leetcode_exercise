package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 *
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input
 * is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't
 * matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller
 * than end. There will be at most 104 balloons.
 *
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart
 * and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows
 * that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum
 * number of arrows that must be shot to burst all balloons.
 *
 * Input: [[10,16], [2,8], [1,6], [7,12]] Output: 2
 *
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and
 * another arrow at x = 11 (bursting the other two balloons).
 *
 * 扫描线做法 第一种做法比较0位置, 可以不用写else
 * 第二种容易理解点
 */
public class L452_MinimumNumberOfArrowsToBurstBalloons_048 {

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
