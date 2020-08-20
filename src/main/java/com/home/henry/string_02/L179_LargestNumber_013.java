package com.home.henry.string_02;

import java.util.Arrays;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Input: [10,2] Output: "210"
 * Input: [3,30,34,5,9] Output: "9534330"
 * 要熟悉Comparator的写法
 */
public class L179_LargestNumber_013 {

    public String largestNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return "0";
        }
        String[] sNum = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sNum[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sNum, (x, y) -> (x + y).compareTo(y + x));
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
