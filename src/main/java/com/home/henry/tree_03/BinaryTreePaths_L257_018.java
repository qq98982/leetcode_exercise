package com.home.henry.tree_03;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_L257_018 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }

    private void helper(TreeNode root, String string, List<String> res) {
        if (root == null) {return;}
        if (root.left == null && root.right == null) {
            res.add(string + root.val);
        }
        helper(root.left, string + root.val + "->", res);
        helper(root.right, string + root.val + "->", res);
    }
}
