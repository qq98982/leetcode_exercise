package com.home.henry.string_02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Input: s = "anagram", t = "nagaram" Output: true
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
}
