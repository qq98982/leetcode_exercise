package com.home.henry.others.pramp;

import java.util.Arrays;

/**
 * [1, 6, 7, 15, 33] limit = 21, return [3, 1]
 */
public class ReachLimitNumIndex {
    // if it is order
    public static int[] solution(int[] arr, int limit) {
        int start = 0, end = arr.length - 1;
        // it looks like it is an sorted array
        // if not, should sort it
        while (start < end) {
            if (arr[start] < limit - arr[end]) {
                start++;
            } else if (arr[start] > limit - arr[end]) {
                end--;
            } else {
                return new int[] { end, start };
            }
        }
        return new int[] { -1, -1 };
    }


    public static void main(String[] args) {
        int[] a = { 1, 6, 7, 8, 15, 33 };
        int limit = 21;
        System.out.println(Arrays.toString(solution(a, limit)));
    }
}
