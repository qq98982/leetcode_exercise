package com.home.henry.others.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode<T> {
    public T val;
    public TreeNode prev;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T x) {
        val = x;
        prev = null;
        left = null;
        right = null;
    }

}

public class FullBinaryTreeLevel {

    public static TreeNode buildTree(TreeNode node, int[] nums, int index) {
        if (index >= nums.length) {
            return null;
        }
        node = new TreeNode(nums[index]);
        node.left = buildTree(node.left, nums, 2 * index + 1);
        if (node.left != null) {
            node.left.prev = node;
        }
        node.right = buildTree(node.right, nums, 2 * index + 2);
        if (node.right != null) {
            node.right.prev = node;
        }
        return node;
    }

    public static TreeNode buildTree(int depth) {
        TreeNode root = new TreeNode(0);
        if (depth == 0) {
            return root;
        }
        int[] num = new int[(int) (Math.pow(2, depth) - 1)];
        for (int i = 0; i < num.length; i++) {
            num[i] = i;
        }
        return buildTree(root, num, 0);
    }

    public static void main(String[] args) {
        int depth = 5;
        TreeNode<Integer> root = buildTree(depth);
        printTree(root);
        List<Integer> list = new ArrayList<>();
        findPathFunc(root, 9, 27, list);
        System.out.println(list);
    }

    private static List<Integer> findPathFunc(TreeNode<Integer> root, int first, int end, List<Integer> list) {
        TreeNode<Integer> firstNode = findValue(root, first);
        TreeNode<Integer> endNode = findValue(root, end);
        if (firstNode == null || endNode == null) {return list;}

        List<Integer> left = findPath(firstNode.prev, new ArrayList<>());
        List<Integer> right = findPath(endNode.prev, new ArrayList<>());
        if (left.contains(end)) {
            List<Integer> newList = new ArrayList<>();
            newList.add(first);
            for (int i = 0; i < left.size(); i++) {
                newList.add(left.get(i));
                if (left.get(i) == end) {
                    return newList;
                }
            }
        }
        if (right.contains(first)) {
            List<Integer> newList = new ArrayList<>();
            newList.add(end);
            for (int i = right.size() - 1; i >= 0 ; i--) {
                newList.add(left.get(i));
                if (left.get(i) == first) {
                    Collections.reverse(newList);
                    return newList;
                }
            }
        }
        Collections.reverse(right);
        list.add(first);
        list.addAll(left);
        list.add(0);
        list.addAll(right);
        list.add(end);
        return list;
    }

    private static List<Integer> findPath(TreeNode<Integer> prev, List<Integer> list) {
        if (prev.val == 0) {
            return list;
        }
        list.add(prev.val);
        findPath(prev.prev, list);
        return list;
    }

    private static TreeNode findValue(TreeNode<Integer> root, int num) {
        if (root == null) {
            return null;
        }
        if (root.val == num) {
            return root;
        }
        TreeNode left = findValue(root.left, num);
        return left != null ? left : findValue(root.right, num);
    }



    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root;
        queue.offer(curr);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> every = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                every.add((Integer) poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(every);
        }
        System.out.println(res);
    }
}