package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 * <p>
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * <p>
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * <p>
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * <p>
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * <p>
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 * <p>
 * <p>
 * Input: [3,9,20,null,null,15,7] Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * <p>
 * <p>
 * Input: [1,2,3,4,5,6,7] Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * The node with value 5 and the node with value 6 have the same position according to the given scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 */
public class L987_VerticalOrderTraversalBinaryTree_009 {

    static class Solution {
        public static List<List<Integer>> verticalTraversal(TreeNode root) {
            TreeMap<Integer, TreeMap<Integer, Queue<Integer>>> map = new TreeMap<>();
            // 将结果存储到map中, 这个tree map中, key是列,比如[-3,-2,-1,0,1,2]
            // value是一个tree map, map的key是层数(只表示先后,不表示其他意义), value是一个pq(因为层数小的要先取出来),deque不行
            dfs(root, 0, 0, map);
            List<List<Integer>> list = new ArrayList<>();
            // 取出的时候第一个是最前面的列
            for (TreeMap<Integer, Queue<Integer>> tq : map.values()) {
                list.add(new ArrayList<>());
                for (Queue<Integer> nodes : tq.values()) {
                    // 取的时候不用管层数, 只管取出来当前列的所有就可以
                    while (!nodes.isEmpty()) {
                        // list在这里是依次填入的
                        list.get(list.size() - 1).add(nodes.poll());
                    }
                }
            }
            return list;
        }

        private static void dfs(TreeNode root, int vertical, int level,
                                TreeMap<Integer, TreeMap<Integer, Queue<Integer>>> map) {
            if (root == null) {return;}
            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue<>());
            }
            map.get(vertical).get(level).offer(root.val);
            // 放入的时候要关注层数, 取的时候不用关注具体层数
            dfs(root.left, vertical - 1, level + 1, map);
            dfs(root.right, vertical + 1, level + 1, map);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> list1 = Solution.verticalTraversal(root);
        // [[9], [3, 15], [20], [7]]
        System.out.println(list1);
        TreeNode rootSec = new TreeNode(1);
        rootSec.left = new TreeNode(2);
        rootSec.left.left = new TreeNode(4);
        rootSec.left.right = new TreeNode(5);
        rootSec.right = new TreeNode(3);
        rootSec.right.left = new TreeNode(6);
        rootSec.right.right = new TreeNode(7);
        List<List<Integer>> list2 = Solution.verticalTraversal(rootSec);
        // [[4], [2], [1, 5, 6], [3], [7]]
        System.out.println(list2);
        // [1,2,3,4,6,5,7]
        TreeNode rootThr = new TreeNode(1);
        rootThr.left = new TreeNode(2);
        rootThr.left.left = new TreeNode(4);
        rootThr.left.right = new TreeNode(6);
        rootThr.right = new TreeNode(3);
        rootThr.right.left = new TreeNode(5);
        rootThr.right.right = new TreeNode(7);
        List<List<Integer>> list3 = Solution.verticalTraversal(rootThr);
        // [[4],[2],[1,5,6],[3],[7]]
        System.out.println(list3);
    }
}
