package com.home.henry.others.recite;

import java.util.Arrays;

public class QuickSelect {
    public static void quick(int[] arr, int start, int end, int k) {
        if (start >= end) {return;}
        int partition = partition(arr, start, end);
        if (k - 1 < partition) {
            quick(arr, start, partition - 1, k);
        } else {
            quick(arr, partition + 1, end, k);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int num = arr[start];
        int i = start, j = end + 1;
        while (true) {
            while (arr[++i] <= num) {
                if (i == end) { break;}
            }
            while (arr[--j] >= num) {
                if (j == start) { break;}
            }
            if (i >= j) { break;}
            exch(arr, i, j);
        }
        exch(arr, start, j);
        return j;
    }

    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int select(int[] arr, int k) {
        quick(arr, 0, arr.length - 1, k);
        return arr[k - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 11, 12, 15, 8, 2, 7 };
        System.out.println(Arrays.toString(arr));
        System.out.println(select(arr, 6));
        System.out.println(Arrays.toString(arr));
    }
}
