package com.home.henry.string_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 2264. Largest 3-Same-Digit Number in String
 *
 * You are given a string num representing a large integer. An integer is good if it meets the following conditions:
 *
 * It is a substring of num with length 3.
 * It consists of only one unique digit.
 * Return the maximum good integer as a string or an empty string "" if no such integer exists.
 *
 * Note:
 *
 * A substring is a contiguous sequence of characters within a string.
 * There may be leading zeroes in num or a good integer.
 *
 * Input: num = "6777133339" Output: "777"
 * Explanation: There are two distinct good integers: "777" and "333".
 * "777" is the largest, so we return "777".
 *
 * Input: num = "2300019" Output: "000"
 * Explanation: "000" is the only good integer.
 *
 * Input: num = "42352338" Output: ""
 * Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
 */
public class L2264_LargestThreeSameDigitNumberInString_044 {
    public String largestGoodInteger(String num) {
        if (num.length() <= 2) {return "";}
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                map.putIfAbsent(num.charAt(i) - '0', num.substring(i, i + 3));
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (map.containsKey(i)) {
                return map.get(i);
            }
        }
        return "";
    }
}
