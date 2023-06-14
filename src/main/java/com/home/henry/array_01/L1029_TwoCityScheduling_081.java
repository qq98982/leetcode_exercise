package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 1029. Two City Scheduling
 *
 * Input: costs = [[10,20],[30,200],[400,50],[30,20]] Output: 110
 *
 * Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]] Output: 1859
 *
 * Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]] Output: 3086
 */
public class L1029_TwoCityScheduling_081 {
    /*
     * The problem is to send n persons to city A
     * and n persons to city B with minimum cost.
     *
     * The idea is to send each person to city A.
     * costs = [[10,20],[30,200],[400,50],[30,20]]
     *
     * So, totalCost = 10 + 30 + 400 + 30 = 470
     *
     * Now, we need to send n persons to city B.
     * Which persons do we need to send city B?
     *
     * Here, we need to minimize the cost.
     * We have already paid money to go to city A.
     * So, Send the persons to city B who get more refund
     * so that our cost will be minimized.
     *
     * So, maintain refunds of each person
     * refund[i] = cost[i][1] - cost[i][0]
     *
     * So, refunds of each person
     *     refund = [10, 170, -350, -10]
     *
     * Here, refund +ve means we need to pay
     *              -ve means we will get refund.
     *
     * So, sort the refund array.
     *
     * refund = [-350, -10, 10, 170]
     *
     * Now, get refund for N persons,
     * totalCost += 470 + -350 + -10 = 110
     *
     * So, minimum cost is 110
     */
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length / 2;
        int[] refund = new int[N * 2];
        int minCost = 0, index = 0;
        for (int[] cost : costs) {
            refund[index++] = cost[1] - cost[0];
            minCost += cost[0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < N; i++) {
            minCost += refund[i];
        }
        return minCost;
    }
}
