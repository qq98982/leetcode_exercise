package com.home.henry.array_01;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 * Input: s1 = "ab" s2 = "eidbaooo" Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Input:s1= "ab" s2 = "eidboaoo" Output: False
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * s1的permutation在s2中, 那就是说看是不是s1打乱顺序后在s2中
 * 这个也用了sliding window的方法
 * 将s1的count++, s2的--, 如果s1走完了, 如果count上所有的数字都是0, 那说明s2就是s1的permutation
 * 如果走完s1的长度了, 这个时候还没有得出结果, 那么从s2-s1的第一位开始--, 同时从第一位开始++, 有一个s1长度的差值, 这个时候
 * 完成一个数字就要判断是否count都为0, 因为有可能在小于s1长度的时候就有s1的部分值了
 * 后一个方法是根据sliding window的模板更改的, 推荐
 */
public class PermutationInString_L567_052 {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 > len2) {return false;}
            int[] count = new int[26];
            for (int i = 0; i < len1; i++) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i) - 'a']--;
            }
            if (allZero(count)) {return true;}

            for (int i = len1; i < len2; i++) {
                count[s2.charAt(i) - 'a']--;
                count[s2.charAt(i - len1) - 'a']++;
                if (allZero(count)) {return true;}
            }
            return false;
        }

        private boolean allZero(int[] count) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {return false;}
            }
            return true;
        }
    }
    private static class SolutionTemplate {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {return false;}
            Map<Character, Integer> map = new HashMap<>();
            for (Character cc : s1.toCharArray()) {
                map.put(cc, map.getOrDefault(cc, 0) + 1);
            }
            int start = 0, end = 0, count = map.size();
            while (end < s2.length()) {
                char c = s2.charAt(end);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        count--;
                    }
                }
                end++;
                while (count == 0) {
                    char tempc = s2.charAt(start);
                    if (map.containsKey(tempc)) {
                        map.put(tempc, map.get(tempc) + 1);
                        if (map.get(tempc) > 0) {
                            count++;
                        }
                        if (end - start == s1.length()) {
                            return true;
                        }
                    }
                    start++;
                }
            }
            return false;
        }
    }
}
