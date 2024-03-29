package com.home.henry.array_01;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * Input: "abcabcbb" Output: 3
 * Input: "bbbbb" Output: 1
 * Input: "pwwkew" Output: 3
 *
 * 典型的sliding window可以做的题
 * 每一个字母, 如果以前count过, counter++. 正常情况下都要count+1, end的index向前移动.
 * 再进行判断, 如果counter > 0了, 移动begin, count字母如果大于1了, 重复出现才会大于1, 这个字母的count-1
 * begin的index也向右移动1, 直到counter == 0, 算出return的值
 * 这样内外循环都完成后, (while完成, 里面的while也完成), 第一个重复的字母处理完成, end是在新的位置上, begin也是在新的位置上
 */
public class L003_LongestSubstringWithoutRepeatingCharacters_054 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] count = new int[256];
            int begin = 0, end = 0, counter = 0, res = 0;
            while (end < s.length()) {
                char c1 = s.charAt(end);
                if (count[c1] > 0) {counter++;}
                count[c1]++;
                end++;
                while (counter > 0) {
                    char c2 = s.charAt(begin);
                    if (count[c2] > 1) {counter--;}
                    count[c2]--;
                    begin++;
                }
                res = Math.max(res, end - begin);
            }
            return res;
        }
    }

    static class SolutionTemplate {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {return 0;}
            if (s.length() == 1) {return 1;}
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
                    char tempc = s.charAt(start);
                    if (map.get(tempc) > 1) {
                        count--;
                    }
                    map.put(tempc, map.get(tempc) - 1);
                    start++;
                }
                res = Math.max(res, end - start);
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
}
