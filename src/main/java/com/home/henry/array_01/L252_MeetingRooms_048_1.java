package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 252. Meeting Rooms
 *
 * find if a person could attend all meetings
 * input: [0,30],[5,10] output: false
 * input: [5,8],[8,10] output: true
 */
public class L252_MeetingRooms_048_1 {
    static class Solution {
        public boolean canAttend(int[][] intervals) {
            Arrays.sort(intervals, (x,y) -> Integer.compare(x[0], y[0]));
            int init = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < init) {
                    return false;
                } else {
                    init = intervals[i][1];
                }
            }
            return true;
        }
    }
}
