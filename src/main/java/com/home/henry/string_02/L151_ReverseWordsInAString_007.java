package com.home.henry.string_02;

/**
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 * Input: "  hello world!  " Output: "world! hello"
 * Note: split(" ")会有空的字符, 需要trim()
 */
public class L151_ReverseWordsInAString_007 {

    public String reverseWords(String s) {
        if (null == s || s.isEmpty()) {
            return "";
        }
        s = s.trim();
        String[] str = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]).append(' ');
        }
        return sb.toString().trim();
    }
}
