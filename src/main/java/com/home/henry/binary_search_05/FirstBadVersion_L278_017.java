package com.home.henry.binary_search_05;

/**
 * 278. First Bad Version
 */
public class FirstBadVersion_L278_017 extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}