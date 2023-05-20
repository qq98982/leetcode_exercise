package com.home.henry.others.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class TreeNode<T> {
    private T val;
    private TreeNode<T> prev;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode<T> getPrev() {
        return prev;
    }

    public void setPrev(TreeNode<T> prev) {
        this.prev = prev;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public void helper(TreeNode<T> node, List<T> nums, int index) {
        if (index >= nums.size()) {
            return;
        }
        node.setVal(nums.get(index));
        if (2 * index + 1 >= nums.size()) {
            return;
        }
        TreeNode<T> left = new TreeNode<>();
        left.setPrev(node);
        node.setLeft(left);
        helper(left, nums, 2 * index + 1);

        TreeNode<T> right = new TreeNode<>();
        right.setPrev(this);
        node.setRight(right);
        helper(right, nums, 2 * index + 2);
    }

    public void buildTree( TreeNode<T> node, int depth, List<T> num) {
        if (depth == 0) {
            return;
        }
        helper(node, num, 0);
    }

    public static void main(String[] args) {
        int depth = 5;
        TreeNode<Integer> node = new TreeNode<>();
        int size = (int) (Math.pow(2, depth) - 1);
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            num.add(i);
        }
        node.buildTree(node, depth, num);
        node.printTree();
        List<Integer> list1 = new ArrayList<>();
        node.findPathFunc(node, 9, 27, list1);
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<>();
        node.findPathFunc(node, 15, 3, list2);
        System.out.println(list2);
    }

    private void findPathFunc(TreeNode<T> node, T first, T end, List<T> list) {
        TreeNode<T> root = findRoot(node);
        TreeNode<T> firstNode = findValue(node, first);
        TreeNode<T> endNode = findValue(node, end);
        if (firstNode == null || endNode == null) {return;}

        List<T> left = findPath(firstNode, new ArrayList<>());
        if (left.contains(end)) {
            for (int i = 0; i < left.size(); i++) {
                list.add(left.get(i));
                if (Objects.equals(left.get(i), end)) {
                    return;
                }
            }
        }
        List<T> right = findPath(endNode, new ArrayList<>());
        if (right.contains(first)) {
            for (int i = right.size() - 1; i >= 0; i--) {
                list.add(left.get(i));
                if (Objects.equals(left.get(i), first)) {
                    Collections.reverse(list);
                    return;
                }
            }
        }
        Collections.reverse(right);
        list.addAll(left);
        list.add(root.getVal());
        list.addAll(right);
    }

    private TreeNode<T> findRoot(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.getPrev() != null) {
            node = node.getPrev();
        }
        return node;
    }

    private List<T> findPath(TreeNode<T> prev, List<T> list) {
        TreeNode<T> root = findRoot(prev);
        if (prev.getVal().equals(root.getVal())) {
            return list;
        }
        list.add(prev.getVal());
        findPath(prev.getPrev(), list);
        return list;
    }

    // find a value from this TreeNode recursively
    private TreeNode<T> findValue(TreeNode<T> node, T num) {
        // if null, return null
        if (node == null) {
            return null;
        }
        // if the value is found, return the TreeNode
        if (node.getVal().equals(num)) {
            return node;
        }
        // if not found, search the left and right TreeNode
        TreeNode<T> left = this.findValue(node.left, num);
        TreeNode<T> right = this.findValue(node.right, num);
        // if not found, return null
        return left == null ? right : left;
    }

    private void printTree() {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        TreeNode<T> curr = this;
        queue.offer(curr);
        List<List<T>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<T> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode<T> poll = queue.poll();
                list.add(poll.getVal());
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(list);
        }
        System.out.println(res);
    }
}