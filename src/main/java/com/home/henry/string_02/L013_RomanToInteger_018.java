package com.home.henry.string_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 13. Roman to Integer
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written
 * as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle
 * applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed
 * to be within the range from 1 to 3999.
 *
 * 非常好的做法, 放入map中, 根据规律找到prev比当前大的时候要减去2倍的prev
 */
public class L013_RomanToInteger_018 {

    public static int romanToInt(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] c = s.toCharArray();
        int total = map.get(c[0]);
        int prev = map.get(c[0]);
        for (int i = 1; i < c.length; i++) {
            int cur = map.get(c[i]);
            if (cur <= prev) {
                total += cur;
            } else {
                total += cur - 2 * prev;
            }
            prev = cur;
        }
        return total;
    }

    public static void main(String[] args) {
        assert Objects.equals(romanToInt("III"), 3);
        assert Objects.equals(romanToInt("IV"), 4);
        assert Objects.equals(romanToInt("IX"), 9);
        assert Objects.equals(romanToInt("LVIII"), 58);
        assert Objects.equals(romanToInt("MCMXCIV"), 1994);
    }
}
