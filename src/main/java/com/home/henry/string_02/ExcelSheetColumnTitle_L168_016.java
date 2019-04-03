package com.home.henry.string_02;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 要点: 记得-1
 */
public class ExcelSheetColumnTitle_L168_016 {

    public String convertToTitle(int n) {
        if(n == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

}
