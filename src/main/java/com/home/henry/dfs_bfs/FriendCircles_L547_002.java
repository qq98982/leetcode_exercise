package com.home.henry.dfs_bfs;

/**
 * 547. Friend Circles
 * 使用DFS, 这个题和number of islands不一样, 容易理解错误
 * 可以使用union find, 后面再实现
 */
public class FriendCircles_L547_002 {

    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == false) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}
