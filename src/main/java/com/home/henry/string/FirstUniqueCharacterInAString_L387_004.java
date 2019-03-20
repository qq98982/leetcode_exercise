package com.home.henry.string;

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
