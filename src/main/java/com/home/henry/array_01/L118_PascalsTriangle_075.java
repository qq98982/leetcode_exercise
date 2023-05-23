package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Input: 5
 * Output:
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 *  第一个要简洁, 第二个要好理解点
 */
public class L118_PascalsTriangle_075 {
    static class Solution {
        public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> allrows = new ArrayList<>();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                row.add(0, 1);
                for (int j = 1; j < row.size() - 1; j++) {
                    row.set(j, row.get(j) + row.get(j + 1));
                }
                allrows.add(new ArrayList<>(row));
            }
            return allrows;
        }
    }

    static class Solution2 {
        public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> allRows = new ArrayList<>();
            if (numRows == 0) {return allRows;}
            allRows.add(new ArrayList<>());
            allRows.get(0).add(1);
            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> preRow = allRows.get(i - 1);
                row.add(1);
                for (int j = 1; j < i; j++) {
                    row.add(preRow.get(j - 1) + preRow.get(j));
                }
                row.add(1);
                allRows.add(row);
            }
            return allRows;
        }
    }

}
