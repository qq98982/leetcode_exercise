package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II

 Given two arrays, write a function to compute their intersection.

 Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2]
 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9]

 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */
public class IntersectionOfTwoArraysII_L350_39_4 {

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {return new int[] {};}
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums1) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            List<Integer> list = new ArrayList<>();
            for (int n : nums2) {
                if (map.containsKey(n) && map.get(n) > 0) {
                    list.add(n);
                    map.put(n, map.get(n) - 1);
                }
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
    }
}
