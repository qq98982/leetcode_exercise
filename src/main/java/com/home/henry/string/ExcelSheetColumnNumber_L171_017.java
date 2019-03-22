package com.home.henry.string;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 */
public class ExcelSheetColumnNumber_L171_017 {

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
