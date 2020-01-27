package com.home.henry.string_02;

/**
 * 387. First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * s = "leetcode" return 0.
 *
 * s = "loveleetcode", return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString_L387_004 {

    public int firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return -1;
        }
        char[] c = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < c.length; i++) {
            count[c[i] - 'a']++;
        }
        for (int i = 0; i < c.length; i++) {
            if (count[c[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
