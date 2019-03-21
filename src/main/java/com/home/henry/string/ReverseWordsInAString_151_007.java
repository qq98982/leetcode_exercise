package com.home.henry.string;

/**
 * Given an input string, reverse the string word by word.
 * Note: split(" ")会有空的字符, 需要trim()
 */
public class ReverseWordsInAString_151_007 {

    public String reverseWords(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        s = s.trim();
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].trim().length() == 0) {
                continue;
            }
            sb.append(str[i].trim()).append(" ");
        }
        return sb.toString().trim();
    }
}
