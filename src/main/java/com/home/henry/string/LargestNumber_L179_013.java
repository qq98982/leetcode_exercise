package com.home.henry.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Input: [10,2] Output: "210"
 * Input: [3,30,34,5,9] Output: "9534330"
 * 要熟悉Comparator的写法
 */
public class LargestNumber_L179_013 {

    public String largestNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return "0";
        }
        String[] sNum = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sNum[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(sNum, comp);
        if (sNum[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sNum.length; i++) {
            sb.append(sNum[i]);
        }
        return sb.toString();
    }
}
