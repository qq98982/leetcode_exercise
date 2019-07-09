package com.home.henry.string_02;

/**
 * Manacher算法, 用于O(n)寻找出最短的Palindrome
 */
public class Manacher_023 {
    public static char[] manacherStringString(String str) {
        char[] c = str.toCharArray();
        char[] res = new char[c.length * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i % 2) == 0 ? '#' : c[index++];
            // 两个一样效果
            // res[i] = (i & 1) == 0 ? '#' : c[index++];
        }
        return res;
    }

    public static String maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArr = manacherStringString(str);
        int[] pArr = new int[charArr.length];
        int C = -1;
        int R = -1;
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            // i在右边界内, i`到C的长度和到i到R的距离, 哪个小, 哪个就是起码成为回文的区域
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 如果大于R, 那更新回文右边界和中心点
            if ((i + pArr[i]) > R) {
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > max) {
                max = pArr[i];
                start = 2 * C - i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start - max + 2; i < start + max; i += 2) {
            sb.append(charArr[i]);
        }
        return sb.toString();
    }
}
