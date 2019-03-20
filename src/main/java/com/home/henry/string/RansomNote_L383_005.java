package com.home.henry.string;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 */
public class RansomNote_L383_005 {

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
            c[r[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (c[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
