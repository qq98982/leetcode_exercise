package com.home.henry.others;

import java.util.ArrayList;
import java.util.List;

public class NumberOfDigit {
    int[] numOfDigits(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int[] ints = new int[10];
        for (int i : arr) {
            while (i != 0) {
                ints[i % 10]++;
                i /= 10;
            }
        }
        int max = 0;
        for (int i : ints) {
            max = Math.max(max, i);
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == max) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
