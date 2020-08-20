package com.home.henry.string_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * 按照Sliding window模板解题, 注意判断条件和顺序
 */
public class L003_LongestSubstringWithoutRepeatingCharacters_022 {

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args) {
        assert (Solution.lengthOfLongestSubstring("pkwwkew") == 3);
        assert (Solution.lengthOfLongestSubstring("bbbbb") == 1);
        assert (Solution.lengthOfLongestSubstring("abcabcbb") == 3);
    }

}
