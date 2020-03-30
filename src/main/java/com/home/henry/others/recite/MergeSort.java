package com.home.henry.others.recite;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 3, 9, 2, 20, 8, 0, 5, 4 };
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static void sort(int[] arr, int[] aux, int start, int end) {
        if (start >= end) {return;}
        int mid = (end - start) / 2 + start;
        sort(arr, aux, start, mid);
        sort(arr, aux, mid + 1, end);
        merge(arr, aux, start, end);
    }

    public static void merge(int[] arr, int[] aux, int start, int end) {
        // merge array data
        // copy arr to aux
        // prepare two variables from start -> end
        // data divided by mid become two parts
        // if pre is finished, copy post part
        // if post part finished, copy pre part
        // if pre part value less than post part, copy pre, else copy post
        for (int i = start; i <= end; i++) {
            aux[i] = arr[i];
        }

        int mid = start + (end - start) / 2;
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > end) {
                arr[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

    public static int[] sort(int[] arr) {
        int[] aux = new int[arr.length];
        sort(arr, aux, 0, arr.length - 1);
        return arr;
    }
}
