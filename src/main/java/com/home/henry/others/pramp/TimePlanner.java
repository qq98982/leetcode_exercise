package com.home.henry.others.pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimePlanner {

    public static final int[] INTS = new int[0];

    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        if (slotsA == null || slotsA.length == 0) {return INTS;}
        if (slotsB == null || slotsB.length == 0) {return INTS;}
        if (slotsA[0] == null || slotsA[0].length == 0) {return INTS;}
        if (slotsB[0] == null || slotsB[0].length == 0) {return INTS;}
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] slot : slotsA) {
            if (slot[1] - slot[0] < dur) {continue;}
            map.put(slot[1], slot[0]);
        }
        // O(N+M)
        List<Integer> list = new ArrayList<>();
        for (int[] slot : slotsB) {
            int left = slot[0], right = slot[1];
            if (right - left < dur) {continue;}
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int end = entry.getKey();
                int start = entry.getValue();
                if (left > end) {
                    // end should be delete
                    list.add(end);
                    continue;
                } else if (right < start) {
                    continue;
                }
                int maxLeft = Math.max(left, start);
                int minRight = Math.min(right, end);
                if (minRight - maxLeft >= dur) {
                    //valid
                    return new int[] { maxLeft, maxLeft + dur };
                }
            }
            for (Integer unused : list) {
                map.remove(unused);
            }
            list.clear();
        }
        return INTS;
    }

    private static final int[] EMPTY = new int[0];
    static int[] meetingPlanner2(int[][] slotsA, int[][] slotsB, int dur) {
        // check boundary
        if (slotsA == null || slotsA.length == 0) {return EMPTY;}
        if (slotsB == null || slotsB.length == 0) {return EMPTY;}
        if (slotsA[0] == null || slotsA[0].length == 0) {return EMPTY;}
        if (slotsB[0] == null || slotsB[0].length == 0) {return EMPTY;}

        for (int[] a : slotsA) {
            for (int[] b : slotsB) {
                // 1. second - first < cur 2. two slots not joint
                if (b[1] - b[0] < dur || a[0] > b[1]) {
                    continue;
                } else if (a[1] - a[0] < dur || a[1] < b[0]) {
                    continue;
                } else {
                    // caculate max start end  min end, then compare with dur
                    int start = Math.max(a[0], b[0]);
                    int end = Math.min(a[1], b[1]);
                    if (end - start >= dur) {
                        // return start and start + cur, not start--end
                        return new int[] { start, start + dur };
                    }
                }
            }
        }
        return EMPTY;
    }
    public static void main(String[] args) {
        int[][] slotsA = { { 10, 50 }, { 60, 79 }, { 95, 120 }, { 140, 210 } };
        int[][] slotsB = { { 0, 15 }, { 80, 90 }, { 160, 165 } };
        int[] ints = meetingPlanner(slotsA, slotsB, 4);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(meetingPlanner2(new int[][]{{1,10}}, new int[][]{{2,3},{5,7}}, 2)));
    }
}
