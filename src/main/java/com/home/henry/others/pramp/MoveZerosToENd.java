package com.home.henry.others.pramp;

public class MoveZerosToENd {

    static class Solution {

        /**
         [1,10,0,2,8,3,0.....]
         [1,10,2,8,3,...0,0..] O(n^2) swap with a non-zero
         two pointer from start to end is not right
         nlogn: divide two parts then merge
         [1,10,0,2,8,3,0,0,6]
         [1,10,0,2] [8,3,0,0,6]
         [1,10][0,2] -> [1,10][2,0]  [8,3][6,0,0]
         s
         ^
         [1, 10, 8, 0] slow = 2

         */
        static int[] moveZerosToEnd(int[] arr) {
            if (arr == null || arr.length == 0) {return arr;}
            int slow = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[slow++] = arr[i];
                }
            }
            int len = arr.length;
            while (slow < len) {
                arr[slow++] = 0;
            }
            return arr;
        }

        public static void main(String[] args) {
            int[] arr = { 1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0 };
            arr = moveZerosToEnd(arr);
            for (int a : arr) {
                System.out.print(a + " ");
            }
        }
    }

}
