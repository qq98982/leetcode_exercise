package com.home.henry.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_AryTreeLevelOrderTraversal_L429_008 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                currLevel.add(curr.val);
                for (Node c : curr.children) {
                    queue.offer(c);
                }
            }
            res.add(currLevel);
        }
        return res;
    }

}
