package com.home.henry.others.recite;

public class BinarySearchTemplate {
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

    public static boolean binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {return true;}
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }

    public static boolean binarySearch3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {return true;}
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] == target || nums[right] == target;
    }

    public static void main(String[] args) {
        assert binarySearch(new int[] { 1, 3, 5, 7 }, 3);
        assert !binarySearch(new int[] { 1, 3, 5, 7 }, 4);
        assert !binarySearch(new int[] { 1, 3, 5, 7, 9 }, 8);
        assert binarySearch(new int[] { 1, 3, 5, 7, 9 }, 9);
        assert binarySearch(new int[] { 1, 3, 5, 7, 9 }, 1);
        System.out.println("method 1 no errors");
        assert binarySearch2(new int[] { 1, 3, 5, 7 }, 3);
        assert !binarySearch2(new int[] { 1, 3, 5, 7 }, 4);
        assert !binarySearch2(new int[] { 1, 3, 5, 7, 9 }, 8);
        assert binarySearch2(new int[] { 1, 3, 5, 7, 9 }, 9);
        assert binarySearch2(new int[] { 1, 3, 5, 7, 9 }, 1);
        System.out.println("method 2 no errors");
        assert binarySearch3(new int[] { 1, 3, 5, 7 }, 3);
        assert !binarySearch3(new int[] { 1, 3, 5, 7 }, 4);
        assert !binarySearch3(new int[] { 1, 3, 5, 7, 9 }, 8);
        assert binarySearch3(new int[] { 1, 3, 5, 7, 9 }, 9);
        assert binarySearch3(new int[] { 1, 3, 5, 7, 9 }, 1);
        System.out.println("method 3 no errors");
    }
}
