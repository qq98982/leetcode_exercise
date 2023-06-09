package com.home.henry.binary_search_08;

/**
 *
 */
public class L540_SingleElementInASortedArray_022 {
    /*
     * if mid is even, then it's duplicate should be in next index.
     * 	or if mid is odd, then it's duplicate  should be in previous index.
     * 	check these two conditions,
     * 	if any of the conditions is satisfied,
     * 	then pattern is not missed,
     * 	so check in next half of the array. i.e, left = mid + 1
     * 	if condition is not satisfied, then the pattern is missed.
     * 	so, single number must be before mid.
     * 	so, update end to mid.
     */
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1, n = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1]
                || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
