package com.home.henry.array_01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 *
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is
 * unique or false otherwise.
 *
 * Input: arr = [1,2,2,1,1,3] Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 *
 * Input: arr = [1,2] Output: false
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0] Output: true
 *
 * Constraints: 1 <= arr.length <= 1000 && -1000 <= arr[i] <= 1000
 */
public class L1207_UniqueNumberOfOccurrences_053 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        map.forEach((k, v) -> set.add(v));
        return map.size() == set.size() ? true : false;
    }
}
