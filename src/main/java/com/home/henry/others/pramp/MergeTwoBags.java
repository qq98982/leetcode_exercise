package com.home.henry.others.pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Merging 2 Packages
 *
 * Given a package with a weight limit "limit" and an array "arr" of item weights, implement a function
 * getIndicesOfItemWeights that finds two items whose sum of weights equals the weight limit "limit".
 * Your function should return a pair [i, j] of the indices of the item weights, ordered such
 * that i > j. If such a pair doesn’t exist, return an empty array.
 *
 * Analyze the time and space complexities of your solution.
 * input:  arr = [4, 6, 10, 15, 16],  lim = 21
 * output: [3, 1] # since these are the indices of the # weights 6 and 15 whose sum equals to 21
 *
 * 和two sum是一样的
 */
class MergeTwoBags {

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        if (arr == null || arr.length < 2) {return new int[] {};}

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int to = limit - num;
            if (map.get(to) != null) {
                return new int[] { i, map.get(to) };
            }
            map.put(arr[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        assert getIndicesOfItemWeights(new int[] { 4, 4, 1 }, 8)[0] == 1;
        assert getIndicesOfItemWeights(new int[] { 4, 4, 1 }, 8)[1] == 0;
    }

}