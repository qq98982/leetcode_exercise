package com.home.henry.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static int[] generate(int level) {
        if (level == 0) {return new int[0];}
        List<List<Integer>> allrow = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        allrow.add(new ArrayList<>());
        allrow.get(0).add(1);
        last.add(1);
        for (int i = 1; i < level; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prerow = allrow.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prerow.get(j - 1) + prerow.get(j));
            }
            row.add(1);
            last.addAll(row);
            allrow.add(row);
        }
        int[] res = new int[last.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = last.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(PascalsTriangle.generate(2)));
    }
}