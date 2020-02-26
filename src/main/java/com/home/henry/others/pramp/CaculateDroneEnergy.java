package com.home.henry.others.pramp;

public class CaculateDroneEnergy {


    static int calcDroneMinEnergy(int[][] route) {
        if (route == null || route.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (route[0] == null || route[0].length == 0) {
            return Integer.MIN_VALUE;
        }
        int res = route[0][2];
        int init = 0;
        for (int i = 1; i < route.length; i++) {
            int signal = 1;
            // 0 - 10 < 0 signal = 1
            if (route[i][2] - route[i - 1][2] < 0) {
                signal = 1;
            } else {
                signal = -1;
            }
            res += route[i][2] * signal;
            if (res < 0) {
                init += Math.abs(res);
            }
        }
        return init;

    }

    public static void main(String[] args) {
        int[][] route = {{0, 2, 10},
                {3, 5, 0},
                {9, 20, 6},
                {10, 12, 15},
                {10, 10, 8}};
        System.out.print(calcDroneMinEnergy(route));
    }

}
