package com.home.henry.string_02;

/**
 * 168. Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *    1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * Input: 1 Output: "A"
 * Input: 28 Output: "AB"
 * Input: 701 Output: "ZY"
 * 要点: 记得转换的规律, 并且reverse比较巧妙
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
            n /= 26;
        }
        return sb.reverse().toString();
    }

}
