package com.home.henry.string_02;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0. Note: A word is defined as a character sequence consists of non-space characters only.
 * 注意: 需要trim()后再toCharArray()
 */
public class L058_LengthOfLastWord_003 {

    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        char[] str = s.trim().toCharArray();
        int count = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
