package com.home.henry.others.pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MatrixSpiralCopy {

    static int[] spiralCopy(int[][] inputMatrix) {
        // your code goes here
        if (inputMatrix == null || inputMatrix.length == 0) {return new int[] {};}
        if (inputMatrix[0] == null || inputMatrix[0].length == 0) {return new int[] {};}
        int tR = 0, tC = 0, dR = inputMatrix.length - 1, dC = inputMatrix[0].length - 1;
        int[] arr = new int[(dR + 1) * (dC + 1)];
        List<Integer> list = new ArrayList<>(arr.length);
        while (tR <= dR && tC <= dC) {
            edge(list, inputMatrix, tR++, tC++, dR--, dC--);
        }
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static List<Integer> edge(List<Integer> list, int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                list.add(m[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                list.add(m[i][tC]);
            }
        } else {
            int curC = tC, curR = tR;
            while (curC != dC) {
                list.add(m[tR][curC]);
                curC++;
            }
            while (curR != dR) {
                list.add(m[curR][dC]);
                curR++;
            }
            while (curC != tC) {
                list.add(m[dR][curC]);
                curC--;
            }
            while (curR != tR) {
                list.add(m[curR][tC]);
                curR--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(Arrays.toString(spiralCopy(arr)));
    }

}