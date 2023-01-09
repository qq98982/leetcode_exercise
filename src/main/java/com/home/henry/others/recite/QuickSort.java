package com.home.henry.others.recite;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {return;}
        // 找出partition的点
        int j = partition(arr, start, end);
        sort(arr, start, j - 1);
        sort(arr, j + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        // 这个是用的第一个值做为pivot
        int num = arr[start];
        // 注意这里j的值
        int i = start, j = end + 1;
        while (true) {
            // 注意while的条件和三个break的条件
            while (arr[++i] <= num) {
                if (i == end) {break;}
            }
            while (arr[--j] >= num) {
                if (j == start) {break;}
            }
            if (i >= j) {break;}
            // arr[i]大于num, arr[i]小于num, 进行交换
            exch(arr, i, j);
        }
        // 这里是用start和j进行交换
        exch(arr, start, j);
        return j;
    }

    private static void exch(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 9, 4, 2, 3, 4 };
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
