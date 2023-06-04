package com.home.henry.array_01;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 253. Meeting Rooms II
 *
 * find the minimum number of conference rooms required
 * input: [1,5],[4,7] output: 2
 * input: [1,5],[5,7] output: 1
 * Input: intervals = [[0,30],[5,10],[15,20]] Output: 2
 * Input: intervals = [[7,10],[2,4]] Output: 1
 * 在计数时,有可能有些会议室用完了,要退出,但也不会重围到0, 所以其是一个动态变化的
 * 在这里用了pq, 保持对个数的track
 */
public class L253_MeetingRoomsII_048_2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {return 0;}
        if (intervals.length == 1) {return 1;}
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int endTime = queue.peek();
            if (endTime <= intervals[i][0]) {
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }

        return queue.size();
    }
}
