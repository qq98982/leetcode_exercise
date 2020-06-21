package com.home.henry.string_02;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Input: ["flower","flow","flight"] Output: "fl"
 * Input: ["dog","racecar","car"] Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note: All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix_L014_002 {

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}
