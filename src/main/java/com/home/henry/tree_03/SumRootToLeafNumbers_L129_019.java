package com.home.henry.tree_03;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers_L129_019 {

    public int sumNumbers(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, "", list);
        int res = 0;
        for(String s : list) {
            res += Integer.parseInt(s);
        }
        return res;
    }
    private void helper(TreeNode root, String str, List<String> list) {
        if (root == null) {return;}
        if (root.left == null && root.right == null) {
            list.add(str + root.val);
        }
        helper(root.left, str + root.val, list);
        helper(root.right, str + root.val, list);
    }

}
