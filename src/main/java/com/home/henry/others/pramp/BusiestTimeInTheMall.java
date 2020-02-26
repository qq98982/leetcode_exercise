package com.home.henry.others.pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * input:  data = [ [1487799425, 14, 1],
 * [1487799425, 4,  0],
 * [1487799425, 2,  0],
 * [1487800378, 10, 1],
 * [1487801478, 18, 0],
 * [1487801478, 18, 1],
 * [1487901013, 1,  0],
 * [1487901211, 7,  1],
 * [1487901211, 7,  0] ]
 * <p>
 * output: 1487800378 # since the increase in the number of people
 * # in the mall is the highest at that point
 *
 * While the question specifies explicitly that the data is sorted by time, your peer may miss this fact.
 * Make sure your peer is aware of this as it’s an important part of the solution.
 * Another thing to pay attention to is that there could be multiple data points with the same timestamp.
 * The mall has multiple entrances and visitors could be entering and exiting at different areas of the
 * mall at the same time. This is important since data points with the same time stamp clearly cannot be
 * regarded as different periods in algorithm.
 * Pay attention to code correctness and edge cases.
 */
public class BusiestTimeInTheMall {
    static int findBusiestPeriod(int[][] data) {
        // your code goes here
        if (data == null || data.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (data[0] == null || data[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] d : data) {
            count = d[2] == 0 ? count - d[1] : count + d[1];
            map.put(d[0], count);
        }

//        int max = Integer.MIN_VALUE;
//        int res = Integer.MIN_VALUE;
//        for (Map.Entry<Integer, Integer> entry  : map.entrySet()) {
//            if (entry.getValue() > max) {
//                max = entry.getValue();
//                res = entry.getKey();
//            }
//        }
//        return res;

        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public static void main(String[] args) {
        int[][] data = {{1487799425, 14, 1},
                {1487799425, 4, 0},
                {1487799425, 2, 0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1, 0},
                {1487901211, 7, 1},
                {1487901211, 7, 0}};
        int[][] data2 =
{{1487799425,14,1},{1487799425,4,0},{1487799425,2,0},{1487800378,10,1},{1487801478,18,0},{1487801478,18,1},{1487901013,1,0},{1487901211,7,1},{1487901211,7,0}};
        System.out.println(findBusiestPeriod(data2));
    }
}
