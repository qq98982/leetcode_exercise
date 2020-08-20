package com.home.henry.stack_pq_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 218. The Skyline Problem
 * 扫描线算法, 起始点: 最高点   终止点: 第二高点
 */
public class L218_TheSkylineProblem_012 {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> buildingPoints = new ArrayList<>();
        // 楼的左边座标, 负的高度, 右边座标, 正的高度
        for (int[] b : buildings) {
            buildingPoints.add(new int[] {b[0], -b[2]});
            buildingPoints.add(new int[] {b[1], b[2]});
        }
        // 先按橫排, 后按竖排(同一方块的后点为负)
        Collections.sort(buildingPoints, (a, b) -> {
            // 橫不相等, 从小到大排序
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                // 右边重合, 升序, 左边重合, 降序
                // 如果重叠,  前点升序排列(去掉负数后应该是降序), 因为前点用负数保存, 所以这里都是a[1] - b[1]
                return a[1] - b[1];
            }
        });
        // 选一个能自动排序的, 一般是pq or tree map
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0);
        int preMax = 0;
        for (int[] bp : buildingPoints) {
            // 陆续加入后面的高度
            if (bp[1] < 0) {
                maxHeap.offer(-bp[1]);
            } else {
                // 如果是到了后边的线, 移除这条橫直线的前面的点
                maxHeap.remove(bp[1]);
            }
            // 当前的最高点
            int curHeight = maxHeap.peek();
            // 当前的最高点和前面的点有高度差的时候, 符合条件, 加入这个点
            if (curHeight != preMax) {
                res.add(new int[] {bp[0], curHeight});
                preMax = curHeight;
            }
        }
        return res;
    }

}
