package com.home.henry.binary_search_05;

class SearchInRotatedSortedArrayII_L081_007 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return false;}

        // left, right
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //mid
            int mid = (right - left) / 2 + left;
            // accelerate
            if (nums[mid] == target || nums[left] == target || nums[right] == target) {return true;}
            // if left == mid, it has duplicated number
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[left] < nums[mid]) {
                // if left part is ascending
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // if other part is ascending
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
    
}