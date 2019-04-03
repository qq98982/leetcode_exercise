package com.home.henry.string_02;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZag_L006_014 {

    public String convert(String s, int numRows) {
        if (null == s || s.length() <= 1 || numRows <= 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder("");
        }
        for (int i = 0; i < s.length(); i++) {
            int index = i % (numRows * 2 - 2);
            if (index >= numRows) {
                index = (numRows * 2 - 2 - index);
            }
            sb[index].append(s.charAt(i));
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

}
