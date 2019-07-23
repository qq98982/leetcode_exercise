package com.home.henry.others.recite;

public class BinarySearch {
    public static boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {return true;}
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] { 1, 3, 5, 7 }, 3));
        System.out.println(binarySearch(new int[] { 1, 3, 5, 7 }, 4));
        System.out.println(binarySearch(new int[] { 1, 3, 5, 7, 9 }, 8));
        System.out.println(binarySearch(new int[] { 1, 3, 5, 7, 9 }, 9));
        System.out.println(binarySearch(new int[] { 1, 3, 5, 7, 9 }, 1));
    }
}
