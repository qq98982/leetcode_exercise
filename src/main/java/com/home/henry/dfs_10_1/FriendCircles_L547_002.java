package com.home.henry.dfs_10_1;

/**
 * 547. Friend Circles
 *
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive
 * in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect
 * friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
 * then the ith and jth students are direct friends with each other, otherwise not. And you have to output the
 * total number of friend circles among all the students.
 *
 * Example 1:
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 * 使用DFS, 这个题和number of islands不一样, 容易理解错误
 * 可以使用union find, 后面再实现
 */
public class FriendCircles_L547_002 {

    public static int findCircleNum(int[][] M) {
        // 因为是相互关系, 所以只需要访问一次就可以, 否则就会重复计算
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            // 如果没有访问过, 对其进行dfs遍历
            if (!visited[i]) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    private static void dfs(int[][] M, boolean[] visited, int i) {
        // 从这一行的第一个开始, 到结束
        for (int j = 0; j < M.length; j++) {
            // 如果是关联并没有访问过, 将其更改为访问过, 并对其进行dfs访问
            if (M[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        assert findCircleNum(new int[][] { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } })
               == 1;
        assert findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }) == 2;
    }
}
