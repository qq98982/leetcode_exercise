package com.home.henry.string_02;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters_L003_022 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, count = 0, res = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) {
                count++;
            }
            end++;
            while (count > 0) {
                char tmp = s.charAt(begin);
                if (map.get(tmp) > 1) {
                    count--;
                }
                map.put(tmp, map.get(tmp) - 1);
                begin++;
            }
            res = Math.max(res, end - begin);
        }
        return res;
    }
}
