package com.home.henry.others.pramp;

import java.util.Arrays;

public class ArrayOfArrayProducts {
    /**
     * input:  arr = [8, 10, 2]
     * output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]
     *
     * input:  arr = [2, 7, 3, 4]
     * output: [84, 24, 56, 42] # by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3]
     *
     * 全部乘起来以后再除的方法不行，　比如有[2,7,0,3,4]　所以要用两个arr记录左右分别的乘积
     */
    static class Solution {
        private static final int[] EMPTY = new int[0];
        static int[] arrayOfArrayProducts(int[] arr) {
            if (arr == null || arr.length == 0) {return EMPTY;}
            if (arr.length == 1) {return arr;}
            int[] left = new int[arr.length];
            int[] right = new int[arr.length];
            left[0] = 1;
            right[arr.length - 1] = 1;
            for (int i = 1; i < arr.length; i++) {
                left[i] = left[i - 1] * arr[i - 1];
            }
            for (int i = arr.length - 2; i >= 0; i--) {
                right[i] = right[i + 1] * arr[i + 1];
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = left[i] * right[i];
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.arrayOfArrayProducts(new int[]{2,7,3,4})));

    }
}
