package com.home.henry.array_01;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * Input: gas  = [1,2,3,4,5] cost = [3,4,5,1,2] Output: 3
 * Input: gas  = [2,3,4] cost = [3,4,3] Output: -1
 */
public class L134_GasStation_007 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int sum = 0;
        int total = 0;
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum = sum + gas[i] - cost[i];
            total = total + gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }
        return total < 0 ? -1 : index + 1;
    }
}
