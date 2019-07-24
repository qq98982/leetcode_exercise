package com.home.henry.union_find_16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 11000
 * 10000
 * 00001
 * 00011
 * return 1.
 * 11100
 * 10001
 * 01001
 * 01110
 * return 2
 */
public class NumberOfDistinctIslandsIIDFS {
    private final int[] R = { 0, 1, 0, -1 };
    private final int[] C = { 1, 0, -1, 0 };
    private boolean[][] done;

    class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 1 } };
        System.out.println(new NumberOfDistinctIslandsIIDFS().numDistinctIslands2(grid));
        int[][] gridSec = { { 1, 1, 1, 0, 0 }, { 1, 0, 0, 0, 1 }, { 0, 1, 0, 0, 1 }, { 0, 1, 1, 1, 0 } };
        System.out.println(new NumberOfDistinctIslandsIIDFS().numDistinctIslands2(gridSec));
    }

    public int numDistinctIslands2(int[][] grid) {
        List<List<Point>> shapes = new ArrayList<>();
        done = new boolean[grid.length][grid[0].length];
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!done[i][j] && grid[i][j] == 1) {
                    List<Point> points = new ArrayList<>();
                    dfs(i, j, grid, points);
                    shapes.add(points);
                }
            }
        }
        for (List<Point> shape : shapes) {
            List<List<Point>> eightShapes = rotateAndReflect(shape);
            islands.add(genKey(eightShapes));
        }
        return islands.size();
    }

    /**
     * Generate a canonical key
     *
     * @param eighShapes
     * @return
     */
    private String genKey(List<List<Point>> eighShapes) {
        List<String> keys = new ArrayList<>();
        for (List<Point> shape : eighShapes) {
            Collections.sort(shape);
            Point first = shape.get(0);
            keys.add(
                    shape
                            .stream()
                            .map(s -> new Point(s.x - first.x, s.y - first.y))
                            .map(p -> p.x + ":" + p.y)
                            .collect(Collectors.joining(",")));
        }
        Collections.sort(keys);
        return keys.get(0);
    }

    /**
     * Rotate and reflect a given shape to 8 possible shapes
     *
     * @param shape
     * @return
     */
    private List<List<Point>> rotateAndReflect(List<Point> shape) {
        Map<Integer, List<Point>> map = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            map.put(i, new ArrayList<>());
        }
        for (Point point : shape) {
            map.get(0).add(new Point(point.x, point.y));
            map.get(1).add(new Point(-point.x, point.y));
            map.get(2).add(new Point(point.x, -point.y));
            map.get(3).add(new Point(-point.x, -point.y));
            map.get(4).add(new Point(point.y, point.x));
            map.get(5).add(new Point(-point.y, point.x));
            map.get(6).add(new Point(point.y, -point.x));
            map.get(7).add(new Point(-point.y, -point.x));
        }
        return new ArrayList<>(map.values());
    }

    private void dfs(int r, int c, int[][] grid, List<Point> points) {
        done[r][c] = true;
        points.add(new Point(c, r));
        for (int i = 0; i < 4; i++) {
            int newR = r + R[i];
            int newC = c + C[i];
            if (newR >= 0
                && newC >= 0
                && newR < grid.length
                && newC < grid[0].length
                && grid[newR][newC] == 1
                && !done[newR][newC]) {
                dfs(newR, newC, grid, points);
            }
        }
    }
}