package com.home.henry.string_02;

import com.home.henry.tool.GenerateRandomStringArray;

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
 *
 * 后一种方法要好点
 */
public class L014_LongestCommonPrefix_002 {

    public static String longestCommonPrefix(String[] strs) {
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

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {return "";}
        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            len = Math.min(str.length(), len);
        }
        if (len == 0) {return "";}
        String str = strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != str.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = GenerateRandomStringArray.generateStringArray();
        assert longestCommonPrefix(strings).equals(longestCommonPrefix2(strings));
    }
}
