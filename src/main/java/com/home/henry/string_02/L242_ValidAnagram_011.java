package com.home.henry.string_02;

/**
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
public class L242_ValidAnagram_011 {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {return false;}
        if (s.length() != t.length()) {return false;}
        int[] bucket = new int[26];
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        for (char c : sch) {
            bucket[c - 'a']++;
        }
        for (char c : tch) {
            bucket[c - 'a']--;
            if (bucket[c - 'a'] < 0) {
                return false;
            }
        }
        for (int n : bucket) {
            if (n != 0) {return false;}
        }
        return true;
    }

}
