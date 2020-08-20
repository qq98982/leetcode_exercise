package com.home.henry.string_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 246. Strobogrammatic Number
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees
 * (looked at upside down).Write a function to determine if a number is strobogrammatic.
 * The number is represented as a string.
 *
 * Input:  "69" Output: true
 * Input:  "88" Output: true
 * Input:  "962" Output: false
 *
 * 这道题定义了一种对称数，就是说一个数字旋转 180 度和原来一样，也就是倒过来看一样，比如 609，倒过来还是 609 等等，
 * 满足这种条件的数字其实没有几个，只有 0,1,8,6,9。这道题其实可以看做求回文数的一种特殊情况，还是用双指针来检测，
 * 首尾两个数字如果相等的话，只有它们是 0,1,8 中间的一个才行，如果它们不相等的话，必须一个是6一个是9，或者一个是9一个
 * 是6，其他所有情况均返回 false
 */
public class L246_StrobogrammaticNumber_029 {
    static class Solution {
        public static boolean isStrobogrammatic(String nums) {
            if (nums == null || nums.length() == 0) {return false;}
            Map<Character, Character> map = new HashMap<>();
            map.put('0', '0');
            map.put('1', '1');
            map.put('6', '9');
            map.put('8', '8');
            map.put('9', '6');
            int left = 0, right = nums.length() - 1;
            while (left <= right) {
                // 不包含对称数返回false
                if (!map.containsKey(nums.charAt(left)) ||
                    !map.containsKey(nums.charAt(right))) {return false;}
                if (map.get(nums.charAt(left)) != nums.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
