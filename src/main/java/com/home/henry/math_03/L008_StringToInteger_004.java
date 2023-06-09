package com.home.henry.math_03;

/**
 * 8. String to Integer (atoi)
 * 这个题目需要严格检查边界, 因为overflow以后会小于边界值,所以使用long类型, 在循环里面和完成后, 都检查overflow
 */
public class L008_StringToInteger_004 {
    public int myAtoi(String s) {
        int len = s.length();
        if (len == 0) {return 0;}
        double num = 0;
        int i = 0;
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        if (i == len) {return 0;}
        boolean positive = s.charAt(i) == '+';
        boolean negative = s.charAt(i) == '-';
        if (positive) {
            i++;
        }
        if (negative) {
            i++;
        }
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i++) - '0');
        }
        num = negative ? -num : num;
        num = (num > Integer.MAX_VALUE) ? Integer.MAX_VALUE : num;
        num = (num < Integer.MIN_VALUE) ? Integer.MIN_VALUE : num;
        return (int) num;
    }

    public int myAtoi2(String str) {
        if (str == null) {return 0;}
        str = str.trim();
        if (str.length() == 0) {return 0;}
        int sign = 1;
        int start = 0;
        long res = 0;
        char firstChar = str.charAt(0);
        if (firstChar == '+') {
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 10) {
                break;
            }
            res = res * 10 + (str.charAt(i) - '0');
            Integer x = checkOverFlow(sign, res);
            if (x != null) {return x;}
        }
        Integer x = checkOverFlow(sign, res);
        if (x != null) {return x;}
        return (int) res * sign;
    }

    private Integer checkOverFlow(int sign, long res) {
        if (res * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return null;
    }

}
