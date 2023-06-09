package com.home.henry.others.recite;

public class BinarySearchTemplate {

    // 正常， 左边界， 右边界， 三种情况，可以做为二分法的模板
    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
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
