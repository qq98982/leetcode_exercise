package com.home.henry.array_01;

/**
 * 832. Flipping an Image
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * 每一行先左右反转, 然后0->1, 1->0
 */
public class FlippingAnImage_L832_035 {
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            if (A == null || A.length == 0) { return A; }

            for (int[] row : A) {
                for (int i = 0, j = row.length - 1; i <= j; i++, j--) {
                    int temp = row[i];
                    row[i] = 1 - row[j];
                    row[j] = 1 - temp;
                }
            }
            return A;
        }
    }
}
