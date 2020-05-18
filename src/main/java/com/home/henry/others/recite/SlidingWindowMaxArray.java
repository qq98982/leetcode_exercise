package com.home.henry.others.recite;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Sliding Window Max Array
 */
public class SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0) {return new int[] {};}
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - k + 1];
        int index = 0;
        // 在linkedlist中, first是先加入的, last是后加入的
        for (int i = 0; i < arr.length; i++) {
            // 到addLast是加入数字进队列 (如果是队列最后一个数字小于当前数字, 就会弹出)
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            // 出队列, 保持k个数的窗口
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            // first位置一直是最大的数字
            if (i >= k - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("[5, 5, 5, 4, 6, 7] -> " + Arrays
                .toString(getMaxWindow(new int[] { 4, 3, 5, 4, 3, 3, 6, 7 }, 3)));
    }
}
