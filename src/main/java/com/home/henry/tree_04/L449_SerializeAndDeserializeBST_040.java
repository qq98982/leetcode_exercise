package com.home.henry.tree_04;

/**
 * 449. Serialize and Deserialize BST
 * because we need to update idx along with the recursion. If we pass int, then it's just a local variable for
 * current recursion. What we need is an object. And one more thing, why not Integer? Because Integer is
 * immutable like String. Passing in Integer is actually same as int.
 */
public class L449_SerializeAndDeserializeBST_040 {

    public String serialize(TreeNode root) {
        if (root == null) {return "#";}
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] nodeString = data.split(",");

        return deserialize(nodeString, new int[]{0});
    }

    private TreeNode deserialize(String[] arr, int[] idx) {
        if(arr[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx[0]++]));
        root.left = deserialize(arr, idx);
        root.right = deserialize(arr, idx);
        return root;
    }

}