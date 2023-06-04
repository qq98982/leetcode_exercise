package com.home.henry.math_03;

/**
 * 8. String to Integer (atoi)
 * 这个题目需要严格检查边界, 因为overflow以后会小于边界值,所以使用long类型, 在循环里面和完成后, 都检查overflow
 */
public class L008_StringToInteger_004 {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {return Integer.MIN_VALUE;}
        int len = s.length();
        int index = 0;
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }
        boolean positive = s.charAt(index) == '+';
        boolean negative = s.charAt(index) == '-';
        if (positive) {
            index++;
        }
        if (negative) {
            index++;
        }
        long sum = 0l;
        while (index < len && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            sum = sum * 10 + (s.charAt(index++) - '0');
        }
        if (negative) {
            sum = sum * -1;
        }
        if (sum < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) sum;
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
