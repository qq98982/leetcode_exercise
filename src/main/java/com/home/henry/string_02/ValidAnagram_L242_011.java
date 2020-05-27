package com.home.henry.string_02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 242. Valid Anagram
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Input: s = "anagram", t = "nagaram" Output: true
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram_L242_011 {

    public boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }
        int[] r = new int[26];
        char[] c = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < c.length; i++) {
            r[c[i] - 'a']++;
            r[tc[i] - 'a']--;
        }
        for (int i = 0; i < r.length; i++) {
            if (r[i] != 0) {
                return false;
            }
        }
        Map<int[], List<String>> map = new HashMap<>();
        return true;
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] bucket = new int[26];
            char[] sch = s.toCharArray();
            char[] tch = t.toCharArray();
            if (sch.length != tch.length) {return false;}
            for (char c : sch) {
                bucket[c - 'a']++;
            }
            for (char c : tch) {
                bucket[c - 'a']--;
            }
            for (int n : bucket) {
                if (n != 0) {return false;}
            }
            return true;
        }
    }
}
