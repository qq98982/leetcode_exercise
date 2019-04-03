package com.home.henry.string_02;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * 这个题不是太推荐, 看下思路就好, 循环调用, 设定退出条件, 熟悉substring的用法, 另外注意相反方向也要比较
 */
public class ScrambleString_L087_012 {

    public boolean isScramble(String s1, String s2) {
        if (null == s1 || null == s2 || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] c = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            c[s1.charAt(i) - 'a']++;
            c[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (c[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i),
                                                                                 s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
