package com.home.henry.string_02;

/**
 * 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 * Input: ["h","e","l","l","o"]  Output: ["o","l","l","e","h"]
 */
public class L344_ReverseString_L006 {

    public void reverseString(char[] s) {
        if (null == s || s.length < 2) {
            return;
        }
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }
}
