package com.home.henry.string_02;

import java.util.Random;

/**
 * 没有小数点的转数字为汉字大写
 */
public class NumToChineseNumber {

    public static String intToChineseNumber(int num) {
        if (num == 0) {return "零";}
        StringBuilder sb = helper(num);
        return sb.toString().trim();
    }

    private static String[] lessThanTen = { "", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

    private static StringBuilder helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100000000) {
            sb.append(helper(num / 100000000)).append("亿");
            if(num % 100000000 < 10000000 && num % 100000000 != 0) {
                sb.append("零");
            }
            sb.append(helper(num % 100000000));
        } else if (num >= 10000) {
            sb.append(helper(num / 10000)).append("万");
            if(num % 10000 < 1000 && num % 10000 != 0) {
                sb.append("零");
            }
            sb.append(helper(num % 10000));
        } else if (num >= 1000) {
            sb.append(helper(num / 1000)).append("仟");
            if(num % 1000 < 100 && num % 1000 != 0) {
                sb.append("零");
            }
            sb.append(helper(num % 1000));
        } else if (num >= 100) {
            sb.append(helper(num / 100)).append("佰");
            if(num % 100 < 10 && num % 100 != 0) {
                sb.append("零");
            }
            sb.append(helper(num % 100));
        } else if (num >= 10) {
            sb.append(helper(num / 10)).append("拾").append(helper(num % 10));
        } else {
            sb.append(lessThanTen[num % 10]);
        }
        return sb;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int minimum = 0, maximum = Integer.MAX_VALUE - 1;
        for (int i = 0; i < 100; i++) {
            int randomNum = minimum + r.nextInt((maximum - minimum) + 1);
            System.out.println(randomNum);
            System.out.println(intToChineseNumber(randomNum));
        }
    }
}
