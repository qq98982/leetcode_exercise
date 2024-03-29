package com.home.henry.stack_pq_11;

import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 *
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth
 * smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8 Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * 
 * Input: matrix = [[-5]], k = 1 Output: -5
 *
 * Solution: Heap
 * Build a minHeap of elements from the first row.
 * Do the following operations k-1 times :
 * Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number
 * of that element(so we can create a tuple class here), replace that root with the next element from the same column.
 * After you finish this problem, thinks more :
 * For this question, you can also build a min Heap from the first column, and do the similar
 * operations as above.(Replace the root with the next element from the same row)
 * What is more, this problem is exact the same with Leetcode373 Find K Pairs with Smallest Sums,
 * I use the same code which beats 96.42%, after you solve this problem, you can check with this link:
 * https://discuss.leetcode.com/topic/52953/share-my-solution-which-beat-96-42
 */
public class L378_KthSmallestElementInASortedMatrix_015 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            PriorityQueue<Tuple> pq = new PriorityQueue<>();
            for (int j = 0; j <= n - 1; j++) {
                pq.offer(new Tuple(0, j, matrix[0][j]));
            }
            for (int i = 0; i < k - 1; i++) {
                Tuple t = pq.poll();
                if (t.x == n - 1) { continue; }
                pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
            }
            return pq.poll().val;
        }

         private class Tuple implements Comparable<Tuple> {
            int x, y, val;

            public Tuple(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }

            @Override
            public int compareTo(Tuple that) {
                return this.val - that.val;
            }
        }
    }



}


