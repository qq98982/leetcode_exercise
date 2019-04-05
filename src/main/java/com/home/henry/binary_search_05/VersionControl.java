package com.home.henry.binary_search_05;

public class VersionControl {
    private boolean[] nums;

    VersionControl() {
        this.nums = new boolean[] { false, false, false, true, true };
    }

    boolean isBadVersion(int mid) {
        if (nums[mid - 1] == true) {
            return true;
        } else {
            return false;
        }
    }
}
