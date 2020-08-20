package com.home.henry.array_01;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * Input: citations = [3,0,6,1,5] Output: 3
 */
public class L274_HIndex_008 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = 0;
        for (int i = citations.length - 1, j = 1; i >= 0 && j <= citations.length; i--, j++) {
            if (citations[i] >= j) {
                n++;
            }
        }
        return n;
    }

    public int hindex(int[] citation) {
        Arrays.sort(citation);
        int n = 0;
        for (int i = citation.length - 1, j = 1; i >= 0 && j <= citation.length; j++, i--) {
            if (citation[i] >= j) {
                n++;
            }
        }
        return n;
    }

    /**
     * Java bucket sort O(n) solution with detail explanation
     * This type of problems always throw me off, but it just takes some getting used to. The idea behind it is some bucket sort mechanisms.
     * First, you may ask why bucket sort. Well, the h-index is defined as the number of papers with reference greater than the number.
     * So assume n is the total number of papers, if we have n+1 buckets, number from 0 to n,
     * then for any paper with reference corresponding to the index of the bucket, we increment the count for that bucket.
     * The only exception is that for any paper with larger number of reference than n, we put in the n-th bucket.
     * Then we iterate from the back to the front of the buckets, whenever the total count exceeds the index of the bucket,
     * meaning that we have the index number of papers that have reference greater than or equal to the index.
     * Which will be our h-index result. The reason to scan from the end of the array is that we are looking for the greatest h-index.
     * For example, given array [3,0,6,5,1], we have 6 buckets to contain how many papers have the corresponding index.
     */

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
