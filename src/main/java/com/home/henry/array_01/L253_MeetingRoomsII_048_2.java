package com.home.henry.array_01;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 253. Meeting Rooms II
 *
 * find the minimum number of conference rooms required
 * input: [1,5],[4,7] output: 2
 * input: [1,5],[5,7] output: 1
 * 在计数时,有可能有些会议室用完了,要退出,但也不会重围到0, 所以其是一个动态变化的
 * 在这里用了pq, 保持对个数的track
 */
public class L253_MeetingRoomsII_048_2 {
    public int minMeetingRooms(int[][] hours) {
        if (hours == null || hours.length == 0) {return 0;}
        if (hours.length == 1) {return 1;}
        Arrays.sort(hours, (x, y) -> Integer.compare(x[0], y[0]));
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < hours.length; i++) {
            if (queue.isEmpty()) {
                count++;
                queue.offer(hours[i][1]);
            } else {
                if (hours[i][0] >= queue.peek()) {
                    queue.poll();
                } else {
                    count++;
                    queue.offer(hours[i][1]);
                }
            }
        }
        return count;
    }
}
