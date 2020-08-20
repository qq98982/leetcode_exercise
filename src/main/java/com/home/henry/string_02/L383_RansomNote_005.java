package com.home.henry.string_02;

/**
 * 383. Ransom Note
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class L383_RansomNote_005 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (null == ransomNote || null == magazine || magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] c = new int[26];
        char[] m = magazine.toCharArray();
        for (int i = 0; i < m.length; i++) {
            c[m[i] - 'a']++;
        }
        char[] r = ransomNote.toCharArray();
        for (int i = 0; i < r.length; i++) {
            if (c[r[i] - 'a'] == 0) {
                return false;
            } else {
                c[r[i] - 'a']--;
            }
        }
        return true;
    }

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {return false;}
            int[] ch = new int[26];
            for (char c : magazine.toCharArray()) {
                ch[c - 'a']++;
            }
            for (char c : ransomNote.toCharArray()) {
                ch[c - 'a']--;
            }
            for (int n : ch) {
                if (n < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
