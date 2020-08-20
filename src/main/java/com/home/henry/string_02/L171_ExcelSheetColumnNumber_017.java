package com.home.henry.string_02;

/**
 * 171. Excel Sheet Column Number
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * Input: "A" Output: 1
 * Input: "AB" Output: 28
 * Input: "ZY" Output: 701
 */
public class L171_ExcelSheetColumnNumber_017 {

    public int titleToNumber(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < c.length; i++) {
            res *= 26;
            res += c[i] - 'A' + 1;
        }
        return res;
    }

}
