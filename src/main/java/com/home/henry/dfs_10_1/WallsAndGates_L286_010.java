package com.home.henry.dfs_10_1;

/**
 * 286. Walls and Gates
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * For example, given the 2D grid:
 * INF -1 0 INF
 * INF INF INF -1
 * INF -1 INF -1
 * 0 -1 INF INF
 * After running your function, the 2D grid should be:
 * 3 -1 0 1
 * 2 2 1 -1
 * 1 -1 2 -1
 * 0 -1 3 4
 */
public class WallsAndGates_L286_010 {
    static class Solution {
        public void wallsAndGate(int[][] rooms) {
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[0].length; j++) {
                    dfs(rooms, i, j, 0);
                }
            }
        }

        private void dfs(int[][] rooms, int i, int j, int dis) {
            // 不同的gate过来会选最近的, 因为如果是大于dis,会将其赋值为dis, 小于已经返回了.
            if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < dis) {
                return;
            }
            rooms[i][j] = dis;
            dfs(rooms, i + 1, j, dis + 1);
            dfs(rooms, i - 1, j, dis + 1);
            dfs(rooms, i, j + 1, dis + 1);
            dfs(rooms, i, j - 1, dis + 1);
        }
    }
}
