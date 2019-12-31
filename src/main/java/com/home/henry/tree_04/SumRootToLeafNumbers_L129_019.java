package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. Sum Root to Leaf Numbers
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 *
 * Input: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * Output: 1026
 * 推荐第二种方法
 */
public class SumRootToLeafNumbers_L129_019 {

    public int sumNumbers(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, "", list);
        int res = 0;
        for (String s : list) {
            res += Integer.parseInt(s);
        }
        return res;
    }

    private void helper(TreeNode root, String str, List<String> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(str + root.val);
        }
        helper(root.left, str + root.val, list);
        helper(root.right, str + root.val, list);
    }

    public int sumNumbers2(TreeNode root) {
        return helper2(root, 0);
    }

    private int helper2(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return helper2(root.left, num * 10 + root.val) + helper2(root.right, num * 10 + root.val);
    }

}
