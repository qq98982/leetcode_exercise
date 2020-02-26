package com.home.henry.others.pramp;

/**
 * Shifted Array Search
 * A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and you don’t
 * have a pre-shifted copy of it. For instance, the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after
 * shifting it twice to the left.
 *
 * Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the
 * index of num in shiftArr. If num isn’t in shiftArr, return -1. Assume that the offset can be any value
 * between 0 and arr.length - 1.
 *
 * Explain your solution and analyze its time and space complexities.
 *
 * input:  shiftArr = [9, 12, 17, 2, 4, 5], num = 2 # shiftArr is the
 *                                                  # outcome of shifting
 *                                                  # [2, 4, 5, 9, 12, 17]
 *                                                  # three times to the left
 *
 * output: 3 # since it’s the index of 2 in arr
 */
public class ShiftSearch {

    static class Solution {
        static int shiftedArrSearch(int[] shiftArr, int num) {
            // binary search for index of num
            // (arr.length - index + 1) is the shift right res
            // index + 1 is shift left res
            // which is small chose it
            int start = 0, end = shiftArr.length - 1;
            int index = -1;
            while (start + 1 < end) {
                int mid = (end - start) / 2 + start;
                if (shiftArr[mid] == num) {
                    index = mid;
                    break;
                } else if (shiftArr[mid] > num) {
                    if (shiftArr[mid] > shiftArr[end]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                } else {
                    if (shiftArr[mid] > shiftArr[end]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
            }
            if (shiftArr[start] == num) {
                index = start;
            } else if (shiftArr[end] == num) {
                index = end;
            }
            int a = shiftArr.length - index;
            int b = index + 1;
            return Math.min(a, b);
        }

        public static void main(String[] args) {

            assert 3 == shiftedArrSearch(new int[] { 9, 12, 17, 2, 4, 5 }, 2);
            assert 2 == shiftedArrSearch(new int[] { 3, 4, 5, 1, 2 }, 1);
        }
    }

}
