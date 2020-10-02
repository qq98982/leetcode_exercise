package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections
 *
 *
 Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

 Return the intersection of these two interval lists.

 (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented
 as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

 代码大概是这样的：

 def intervalIntersection(A, B):
 i, j = 0, 0
 res = []
 while i < len(A) and j < len(B):
 # ...
 j += 1
 i += 1
 return res
 对于两个区间，我们用[a1,a2]和[b1,b2]表示在A和B中的两个区间，那么什么情况下这两个区间没有交集呢：
 只有这两种情况，写成代码的条件判断就是这样：

 if b2 < a1 or a2 < b1:
 [a1,a2] 和 [b1,b2] 无交集
 那么，什么情况下，两个区间存在交集呢？根据命题的否定，上面逻辑的否命题就是存在交集的条件：

 # 不等号取反，or 也要变成 and
 if b2 >= a1 and a2 >= b1:
 [a1,a2] 和 [b1,b2] 存在交集
 如果交集区间是[c1,c2]，那么c1=max(a1,b1)，c2=min(a2,b2)
 i,j 是否前进，只取决于a2和b2的大小关系
 */
public class L986_IntervalListIntersections_048 {
    static class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            if (A.length == 0 || B.length == 0) {return new int[][] {};}
            List<int[]> res = new ArrayList<>();
            int i = 0, j = 0;
            while (i < A.length && j < B.length) {
                int a1 = A[i][0], a2 = A[i][1];
                int b1 = B[j][0], b2 = B[j][1];
                if (b2 >= a1 && a2 >= b1) {
                    res.add(new int[] { Math.max(a1, b1), Math.min(a2, b2) });
                }
                if (b2 < a2) {
                    j++;
                } else {
                    i++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
