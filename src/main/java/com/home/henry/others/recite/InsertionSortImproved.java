package com.home.henry.others.recite;

public class InsertionSortImproved {
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int value = arr[i];
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
        return arr;
    }
}
