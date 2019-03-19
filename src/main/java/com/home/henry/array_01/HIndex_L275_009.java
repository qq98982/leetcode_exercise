package com.home.henry.array_01;

/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * Input: citations = [0,1,3,5,6] Output: 3
 */
public class HIndex_L275_009 {

    public int hIndex(int[] citations) {
        if (citations.length == 0 || citations[citations.length - 1] == 0) {
            return 0;
        }
        int begin = 1, end = citations.length;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (citations[citations.length - mid] == mid) {
                return mid;
            } else if (citations[citations.length - mid] < mid) {
                end = mid - 1;
            } else {
                if (citations[citations.length - mid - 1] <= mid) {
                    return mid;
                } else {
                    begin = mid + 1;
                }
            }
        }
        return begin;
    }
}
