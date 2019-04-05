package com.home.henry.binary_search_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. Find K Closest Elements
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 * Example 1: Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4]
 * Example 2: Input: [1,2,3,4,5], k=4, x=-1 Output: [1,2,3,4]
 * Example 3: Input: [1,2,3,4,7,8,12], k=5, x=9 Output: [3, 4, 7, 8, 12]
 */
public class FindKClosestElements_658_018 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        // 设置最高到length - k, hi为不包含状态
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        for (int i = lo; i < lo + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindKClosestElements_658_018 f = new FindKClosestElements_658_018();
        System.out.println(f.findClosestElements(new int[] { 1, 2, 3, 4, 7, 8, 12 }, 5, 9));
    }


}
