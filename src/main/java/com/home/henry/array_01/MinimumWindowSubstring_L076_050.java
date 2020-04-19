package com.home.henry.array_01;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 * Note: If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * Sliding window, 非常重要 这个题目根据模板做更好点
 */
public class MinimumWindowSubstring_L076_050 {

    static class Solution {
        public String minWindow(String s, String t) {
            int[] count = new int[128];
            for (char c : t.toCharArray()) {
                count[c]++;
            }

            int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
            while (end < s.length()) {
                char c1 = s.charAt(end);
                if (count[c1] > 0) {
                    counter--;
                }
                count[c1]--;
                end++;
                while (counter == 0) {
                    char c2 = s.charAt(start);
                    count[c2]++;
                    if (count[c2] > 0) {
                        counter++;
                        if (minLen > end - start) {
                            minLen = end - start;
                            minStart = start;
                        }
                    }
                    start++;
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }
    }

    public static void main(String[] args) {
        System.out.println(SolutionTemplate.minWindow("a", "b"));
        System.out.println(SolutionTemplate.minWindow("ADOBECODEBANC", "ABC"));
    }

    static class SolutionTemplate {
        public static String minWindow(String s, String t) {
            // check boundary
            if (s.isEmpty() || t.isEmpty()) {return "";}
            if (t.length() > s.length()) {return "";}
            // map save t characters
            Map<Character, Integer> map = new HashMap<>();
            for (Character c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int start = 0, end = 0, count = map.size(), len = Integer.MAX_VALUE;
            int head = 0;
            char[] sh = s.toCharArray();
            // t里面的字母放入到map中, value是个数
            while (end < s.length()) {
                // 每次进长字符串, 如果在t中有过, 那么就减去1
                char c = sh[end];
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    // 如果没有值了, 说明一个字母完成, count要减去1
                    if (map.get(c) == 0) {
                        count--;
                    }
                }
                end++;
                // 所有的字母已经在长字符串中走完了(种类和个数都是), 如果没有, 还不进这个循环
                while (count == 0) {
                    char temp = sh[start];
                    // start准备开始移动
                    // 如果在短字符串中有的, 那么就数量+1, 如果是数量1了, 那么种类+1
                    if (map.containsKey(temp)) {
                        map.put(temp, map.get(temp) + 1);
                        if (map.get(temp) == 1) {
                            // 种类加1后, 也就是start第一个字母走完
                            count++;
                            // 这里end已经++了, start还没++, 所以 len = end - start
                            if (end - start < len) {
                                // head和len是为了后面substring的
                                head = start;
                                len = end - start;
                            }
                        }
                    }
                    start++;
                }
            }
            if (len == Integer.MAX_VALUE) {
                return "";
            }
            return s.substring(head, head + len);
        }
    }
}