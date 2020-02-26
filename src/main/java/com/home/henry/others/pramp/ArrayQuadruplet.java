package com.home.henry.others.pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayQuadruplet {


    static int[] findArrayQuadruplet(int[] arr, int s) {
        if (arr == null || arr.length < 4) {
            return new int[]{};
        }
        Set<Set<Integer>> set = new HashSet<>();
        Arrays.sort(arr);
        Map<Integer, Set<Set<Integer>>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length && i != j; j++) {
                int sum = arr[i] + arr[j];
                int diff = s - sum;
                Set<Integer> indicesSet= new HashSet<>(Arrays.asList(i,j));
                if (map.get(diff) != null) {
                    // there is a answer
                    for (Set<Integer> setEach : map.get(diff)) {
                        // add this i and j to answer
                        Set<Integer> ans = new HashSet<>(indicesSet);
                        for (Integer idx : setEach) {
                            ans.add(idx);
                        }
                        set.add(ans);
                    }
                }
                // whether find or not, put new sum composition into map's entry's set
                map.putIfAbsent(sum, new HashSet<>());
                map.get(sum).add(indicesSet);
            }

        }
        // after loop
        Set<List<Integer>> ans = new HashSet<>();
        for (Set<Integer> each : set) {
            if (each.size() == 4) {
                List<Integer> a = new ArrayList<>();
                for (Integer idx : each) {
                    a.add(arr[idx]);
                }
                Collections.sort(a);
                ans.add(a);
            }
        }
        List<List<Integer>> ansList = new ArrayList<>(ans);
        System.out.println(ansList);
        List<Integer> integers = ansList.get(0);
        int[] aa = new int[integers.size()];
        for (int i = 0; i < aa.length;i++) {
            aa[i] = integers.get(i);
        }
        return aa;
    }

    public static void main(String[] args) {
//        int[] s = findArrayQuadruplet(new int[]{4,4,4,4}, 16);
//        System.out.println(Arrays.toString(s));
    }



    /**
     function findArrayQuadruplet(arr, s):
    n = arr.length

    # if there are fewer than 4 items in arr, by
    # definition no quadruplet exists whose sum is s
    if (n < 4):
        return []

    # sort arr in an ascending order
    arr.sort()

    for i from 0 to n - 4:
        for j from i + 1 to n - 3:
            # r stores the complementing sum
            r = s - (arr[i] + arr[j])

            # check for sum r in subarray arr[j+1…n-1]
            low = j + 1, high = n - 1;

            while (low < high):
                if (arr[low] + arr[high] < r):
                    low++

                else if (arr[low] + arr[high] > r):
                    high--

                # quadruplet with given sum found
                else:
                    return [arr[i], arr[j], arr[low], arr[high]]

    return []
     */
}
