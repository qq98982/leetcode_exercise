package com.home.henry.tree_04;

/**
 * 116. Populating Next Right Pointers in Each Node
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two
 * children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Follow up:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer
 * to point to its next right node, just like in Figure B. The serialized output is in level order as connected
 * by the next pointers, with '#' signifying the end of each level.
 *
 * 在dfs中连接子节点, 再连接右子节点和下一个点的左节点(如果不是null)
 */
public class L116_PopulatingNextRightPointersInEachNode_038 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) {return null;}
            helper(root, null);
            return root;
        }

        private void helper(Node curr, Node next) {
            if (curr == null) {return;}
            curr.next = next;
            helper(curr.left, curr.right);
            helper(curr.right, curr.next == null ? null : curr.next.left);
        }
    }
}
