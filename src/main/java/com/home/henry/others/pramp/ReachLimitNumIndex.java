package com.home.henry.others.pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [1, 6, 7, 15, 33] limit = 21, return [3, 1]
 */
public class ReachLimitNumIndex {
    // if it is order
    public static int[] solution(int[] arr, int limit) {
        int start = 0, end = arr.length - 1;
        // it looks like it is an sorted array
        while (start < end) {
            if (arr[start] < limit - arr[end]) {
                start++;
            } else if (arr[start] > limit - arr[end]) {
                end--;
            } else {
                return new int[] {end, start};
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] solutionUnorder(int[] arr, int limit) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if (map.get(limit - arr[i]) != null) {
                start = i;
                end = map.get(limit - arr[i]);
                break;
            }
        }
        return new int[] {end, start};
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 6, 7, 8,  15, 33}; int limit = 21;
        System.out.println(Arrays.toString(solution(a, limit)));
        int[] b = new int[] {1, 8, 7,6,11,33, 15};
        System.out.println(Arrays.toString(solutionUnorder(b, 21)));
    }
}
