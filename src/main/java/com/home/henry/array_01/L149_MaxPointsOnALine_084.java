package com.home.henry.array_01;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return
 * the maximum number of points that lie on the same straight line.
 * Input: points = [[1,1],[2,2],[3,3]] Output: 3
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] Output: 4
 */
public class L149_MaxPointsOnALine_084 {

    private int gcd(int a, int b) {
        if (b == 0) {return a;} else {return gcd(b, a % b);}
    }

    public int maxPoints(int[][] points) {
        if (points == null) {return 0;}
        int n = points.length, result = 0;
        if (n <= 2) {return n;}
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < n; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String key = x + ":" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

}
