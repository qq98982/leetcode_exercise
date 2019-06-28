package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 164. Maximum Gap
 *
 * Suppose there are N elements in the array, the min value is min and the max value is max. Then the maximum
 * gap will be no smaller than ceiling[(max - min ) / (N - 1)].
 * Let gap = ceiling[(max - min ) / (N - 1)]. We divide all numbers in the array into n-1 buckets, where k-th
 * bucket contains all numbers in [min + (k-1)gap, min + k*gap). Since there are n-2 numbers that are not equal
 * min or max and there are n-1 buckets, at least one of the buckets are empty. We only need to store the
 * largest number and the smallest number in each bucket.
 * After we put all the numbers into the buckets. We can scan the buckets sequentially and get the max gap.
 * 有评论说Radix sort比bucket容易理解点
 * 这个问题难度大, 后面再看
 */
public class MaximumGap_L164_032 {

    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) { return 0; }
        // get the max and min value of the array
        int min = num[0];
        int max = num[0];
        for (int i : num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possible gap, ceiling of the integer division
        int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
        // store the min value in that bucket
        int[] bucketsMIN = new int[num.length - 1];
        // store the max value in that bucket
        int[] bucketsMAX = new int[num.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int i : num) {
            if (i == min || i == max) { continue; }
            // index of the right position in the buckets
            int idx = (i - min) / gap;
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
            // empty bucket
            { continue; }
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        // update the final max value gap
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }

    /**
     * The first step is to find the maximum value in nums array, it will
     * be the threshold to end while loop.
     * Then use the radix sort algorithm to sort based on each digit from Least Significant Bit
     * (LSB) to Most Significant Bit (MSB), that's exactly what's showing in the link.
     * (nums[i] / exp) % 10 is used to get the digit, for each digit, basically the digit itself serves as the
     * index to access the count array. Count array stores the index to access aux
     * array which stores the numbers after sorting based on the current digit.
     * Finally, find the maximum gap from sorted array.
     * Time and space complexities are both O(n).
     * (Actually time is O(10n) at worst case for Integer.MAX_VALUE 2147483647)
     */
    class SosutionRRadix {

        public int maximumGap(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }
            // m is the maximal number in nums
            int m = nums[0];
            for (int i = 1; i < nums.length; i++) {
                m = Math.max(m, nums[i]);
            }

            // 1, 10, 100, 1000 ...
            int exp = 1;
            // 10 digits
            int R = 10;

            int[] aux = new int[nums.length];

            // Go through all digits from LSB to MSB
            while (m / exp > 0) {
                int[] count = new int[R];

                for (int i = 0; i < nums.length; i++) {
                    count[(nums[i] / exp) % 10]++;
                }

                for (int i = 1; i < count.length; i++) {
                    count[i] += count[i - 1];
                }

                for (int i = nums.length - 1; i >= 0; i--) {
                    aux[--count[(nums[i] / exp) % 10]] = nums[i];
                }

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = aux[i];
                }
                exp *= 10;
            }
            int max = 0;
            for (int i = 1; i < aux.length; i++) {
                max = Math.max(max, aux[i] - aux[i - 1]);
            }
            return max;
        }
    }

}
