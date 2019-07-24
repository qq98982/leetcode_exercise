package com.home.henry.union_find_16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Number of Distinct Islands II
 * Given a non-empty 2D arraygridof 0's and 1's, an island is a group of1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one
 * island can be translated (and not rotated or reflected) to equal the other.
 * 这个题目我用的是UF做的
 * 如果有'1'则初始化值为本身的序号
 * 然后循环这个matrix, 如果是'1', 则计算出这个的id和root, 加入到map中, key为root, value为(id - root)的set
 * 如果和其他的点连接起来了, union下, key为两个点的共同root, 如果没有, 用本身的id做为key, 这个过程不能反过来
 * 另外, 这个问题还要旋转这个shape, 所以比较复杂, 两个方法都应该看看
 */
public class NumberOfDistinctIslandsIIUF {
    static class SolutionArrayUF {
        static class IslandUnionFind {
            int[] root;
            int count = 0;
            int[] size;

            IslandUnionFind(int[][] grid) {
                int m = grid.length;
                int n = grid[0].length;

                root = new int[m * n];
                size = new int[m * n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == 1) {
                            int id = i * n + j;
                            root[id] = id;
                            size[id] = 1;
                            count++;
                        }
                    }
                }
            }

            public int find(int p) {
                validate(p);
                int parent = p;
                while (parent != root[parent]) {
                    root[parent] = root[root[parent]];
                    parent = root[parent];
                }
                return parent;
            }

            private void validate(int p) {
                if (p < 0 || p > root.length) {
                    throw new IllegalArgumentException();
                }
            }

            public int count() {
                return count;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP != rootQ) {
                    if (size[rootP] > size[rootQ]) {
                        root[rootQ] = rootP;
                        size[rootP] += size[rootQ];
                    } else {
                        root[rootP] = rootQ;
                        size[rootQ] += size[rootP];
                    }
                    count--;
                }
            }
        }

        public int numIslands(int[][] grid) {
            int[][] distance = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            if (grid == null || grid.length == 0) { return 0;}
            if (grid[0] == null || grid[0].length == 0) { return 0;}
            IslandUnionFind uf = new IslandUnionFind(grid);
            int rows = grid.length, cols = grid[0].length;
            Map<Integer, Set<Integer>> map = new HashMap<>();

            Set<String> islands = new HashSet<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        int id1 = i * cols + j;
                        int root = uf.find(id1);
                        boolean conn = false;
                        for (int[] d : distance) {
                            int x = i + d[0];
                            int y = j + d[1];
                            if (x >= 0 && x < rows && y >= 0 && y < cols) {
                                if (grid[x][y] == 1) {
                                    conn = true;
                                    int id2 = x * cols + y;
                                    uf.union(id1, id2);
                                    root = uf.find(id2);
                                    Set<Integer> tSet = map.getOrDefault(root, new TreeSet<>());
                                    tSet.add(id1);
                                    tSet.add(id2);
                                    map.put(root, tSet);
                                }
                            }
                        }
                        if (!conn) {
                            Set<Integer> tSet = map.getOrDefault(root, new TreeSet<>());
                            tSet.add(id1);
                            map.put(root, tSet);
                        }
                    }
                }
            }
            for (Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                Set<Integer> value = entry.getValue();
                List<Point> shape = new ArrayList<>();
                int col = grid[0].length;
                // 从序号转换为point, 后面将points加入到一个shape中
                for (Integer integer : value) {
                    int x = (integer) / col;
                    int y = (integer) % col;
                    Point point = new Point(x, y);
                    shape.add(point);
                }
                // shape旋转后的变成一系列的shapes
                List<List<Point>> lists = rotateAndReflect(shape);
                // 在genKey中, 将本身和变形后的shapes最后变成排行最小的一个String做为一个String放入set
                islands.add(genKey(lists));
            }

            return islands.size();
        }

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

        private String genKey(List<List<Point>> eightShapes) {
            List<String> keys = new ArrayList<>();
            for (List<Point> shape : eightShapes) {
                Collections.sort(shape);
                Point first = shape.get(0);
                keys.add(shape.stream().map(s -> new Point(s.x - first.x, s.y - first.y))
                              .map(p -> p.x + ":" + p.y)
                              .collect(Collectors.joining(",")));
            }
            Collections.sort(keys);
            return keys.get(0);
        }
    }

    static class Point implements Comparable<Point> {
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

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) {
        SolutionArrayUF s = new SolutionArrayUF();
        int[][] input = {
                { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 }
        };
        // "11011"
        // "10000"
        // "00001"
        // "11011"
        // 2
        System.out.println(s.numIslands(input));
        int[][] inputSec = {
                { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 }
        };
        // "11000"
        // "11000"
        // "00011"
        // "00011"
        // 1
        System.out.println(s.numIslands(inputSec));
        int[][] inputThd = {
                { 1, 0, 1, 0, 1 }, { 0, 1, 1, 1, 0 }, { 1, 0, 1, 0, 1 },
                { 0, 1, 0, 1, 0 }
        };
        // "10101"
        // "01110"
        // "10101"
        // "01010"
        // 2
        System.out.println(s.numIslands(inputThd));
        int[][] inputFur = {
                { 1, 0, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 1, 0, 1, 0, 1 },
                { 0, 1, 0, 1, 0 }
        };
        // "10101"
        // "01010"
        // "10101"
        // "01010"
        // 1
        System.out.println(s.numIslands(inputFur));
    }
}
