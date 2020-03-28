package com.home.henry.others.recite;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    /**
     * Sliding window template
     */
    public static int lengthOfLongestSubStringMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, count = 0, res = Integer.MIN_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) {
                count++;
            }
            end++;
            while (count > 0) {
                char sc = s.charAt(start);
                if (map.get(sc) > 1) {
                    count--;
                }
                map.put(sc, map.get(sc) - 1);
                start++;
            }
            res = Math.max(res, end - start);
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

}
