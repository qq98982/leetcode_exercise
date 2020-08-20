package com.home.henry.string_02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 345. Reverse Vowels of a String
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Input: "hello" Output: "holle"
 * 方法1 速度不快, 另外要注意边界
 * 方法2 99% faster
 */
public class L345_ReverseVowelsOfAString_008 {
    public String reverseVowels(String s) {
        if (null == s || s.length() == 0) { return ""; }
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < c.length && j >= 0; i++, j--) {
            while (i < c.length - 1 && !isVowel(c[i])) {
                i++;
            }
            while (j >= 0 && !isVowel(c[j])) {
                j--;
            }
            if (i < j) {
                char t = c[i];
                c[i] = c[j];
                c[j] = t;
            }
        }
        return String.valueOf(c);
    }

    private static boolean isVowel(char ch) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        return set.contains(ch);
    }

    public String reverseVowels2(String s) {
        if (null == s || s.length() == 0) { return ""; }
        char[] c = s.toCharArray();
        int start = 0, end = c.length - 1;
        while (start < end) {
            if (isVowel2(c[start]) && isVowel2(c[end])) {
                char t = c[start];
                c[start++] = c[end];
                c[end--] = t;
            } else if (!isVowel2(c[start])) {
                start++;
            } else {
                end--;
            }
        }
        return String.valueOf(c);
    }

    private static boolean isVowel2(char ch) {
        ch = ch >= 'A' && ch <= 'Z' ? ch += 32 : ch;
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
