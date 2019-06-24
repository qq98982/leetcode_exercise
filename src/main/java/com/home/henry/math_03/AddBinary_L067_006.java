package com.home.henry.math_03;

/**
 * 67. Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Input: a = "11", b = "1" Output: "100"
 * Input: a = "1010", b = "1011" Output: "10101"
 */
public class AddBinary_L067_006 {

    static class Solution {
        public String addBinary(String a, String b) {
            int i = a.length() - 1;
            int j = b.length() - 1;
            int remainder = 0;
            StringBuilder sb = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int sum = remainder;
                if (i >= 0) {sum += a.charAt(i) - '0';}
                if (j >= 0) {sum += b.charAt(j) - '0';}
                sb.append(sum % 2);
                remainder = sum / 2;
                i--;j--;
            }
            if (remainder != 0) {sb.append(remainder);}
            return sb.reverse().toString();
        }
    }
}
