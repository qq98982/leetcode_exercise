package com.home.henry.binary_search_08;

import java.util.Arrays;

/**
 * 1011. Capacity To Ship Packages Within D Days
 *
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 *
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on
 * the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 *
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being
 * shipped within days days.
 *
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Input: weights = [3,2,2,4,1,4], days = 3 Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 *
 * Input: weights = [1,2,3,1,1], days = 4 Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 */
public class L1011_CapacityToShipPackagesWithinDDays_023 {
    /*
     * Given the number of bags,
     * return the minimum capacity of each bag,
     * so that we can put items one by one into all bags.
     *
     * We binary search the final result.
     * The left bound is max(A),
     * The right bound is sum(A).
     */
    public int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0 || days <= 0) {return 0;}

        int max = Arrays.stream(weights).max().getAsInt();
        int sum = Arrays.stream(weights).sum();

        int start = max, end = sum;

        while (start <= end) {
            int guess = start + (end - start) / 2;

            if (canShipEverything(weights, guess, days)) {
                end = guess - 1;
            } else {
                start = guess + 1;
            }
        }
        return start;
    }

    private boolean canShipEverything(int[] weights, int min, int days) {
        int count = 1;
        int capacity = 0;

        for (int w : weights) {
            capacity += w;
            if (capacity > min) {
                count++;
                capacity = w;
            }
        }
        return count <= days;
    }
}
