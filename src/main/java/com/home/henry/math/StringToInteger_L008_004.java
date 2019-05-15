package com.home.henry.math;

/**
 * 8. String to Integer (atoi)
 * 这个题目需要严格检查边界, 因为overflow以后会小于边界值,所以使用long类型, 在循环里面和完成后, 都检查overflow
 */
public class StringToInteger_L008_004 {

    static class Solution {
        public int myAtoi(String str) {
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

}
