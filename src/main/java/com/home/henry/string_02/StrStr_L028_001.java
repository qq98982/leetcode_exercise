package com.home.henry.string_02;

/**
 * 28. Implement strStr()
 *
 * Implement strStr(). Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class StrStr_L028_001 {

    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() < 1) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    if (j == needle.length() - 1) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {return 0;}
        if (haystack.length() < needle.length()) {return -1;}
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == needle.length() - 1 + i) {
                    return i;
                }
            }
        }
        return -1;
    }

}
