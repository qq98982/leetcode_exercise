package com.home.henry.string_02;

/**
 * 273. Integer to English Words
 */
public class L273_NumberToWords_020 {

    private static String[] words = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"
    };

    public static String numberToWordsSec(int num) {
        if (num == 0) {return "Zero";}
        return helperSec(num).toString().trim();
    }

    private static StringBuilder helperSec(int num) {
        StringBuilder res = new StringBuilder();

        if (num >= 1000000000) {
            res.append(helperSec(num / 1000000000)).append("Billion ").append(helperSec(num % 1000000000));
        } else if (num >= 1000000) {
            res.append(helperSec(num / 1000000)).append("Million ").append(helperSec(num % 1000000));
        } else if (num >= 1000) {
            res.append(helperSec(num / 1000)).append("Thousand ").append(helperSec(num % 1000));
        } else if (num >= 100) {
            res.append(helperSec(num / 100)).append("Hundred ").append(helperSec(num % 100));
        } else if (num >= 20) {
            res.append(words[(num - 20) / 10 + 20]).append(' ').append(words[num % 10]).append(' ');
        } else {
            res.append(words[num]).append(' ');
        }
        if (res.length() >= 2) {
            if (res.charAt(res.length() - 1) == ' ' && res.charAt(res.length() - 2) == ' ') {
                res.deleteCharAt(res.length() -1);
            }
        }
        return res;
    }

    public String numberToWords(int num) {
        if (num == 0) {return "Zero";}
        String[] s = helper(num).toString().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]).append(" ");
        }
        return sb.toString().trim();
    }

    private static String[] lessThanTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight", "Nine"};
    private static String[] lessThanTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] lessThanHundred = {"Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety"};
    private static StringBuilder helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 10) {
            sb.append(lessThanTen[num]).append(' ');
        } else if (num < 20) {
            sb.append(lessThanTwenty[num - 10]).append(' ');
        } else if (num < 100) {
            sb.append(lessThanHundred[num / 10 - 2]).append(' ').append(helper(num % 10));
        } else if (num < 1000) {
            sb.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            sb.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            sb.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            sb.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }
        return sb;
    }

    public static void main(String[] args) {
        assert numberToWordsSec(121).equals("One Hundred Twenty One");
        assert numberToWordsSec(50868).equals("Fifty Thousand Eight Hundred Sixty Eight");
        assert numberToWordsSec(1234567).equals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");
    }
}
