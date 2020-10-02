package com.home.henry.random_14;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 710. Random Pick with Blacklist
 *
 * Given a blacklist B containing unique integers from [0, N), write a function to return a
 * uniform random integer from [0, N) which is NOT in B.
 *
 * Optimize it such that it minimizes the call to system’s Math.random().
 *
 * 1、如果想高效地，等概率地随机获取元素，就要使用数组作为底层容器。
 * 2、如果要保持数组元素的紧凑性，可以把待删除元素换到最后，然后pop掉末尾的元素，这样时间复杂度就是 O(1) 了。
 * 当然，我们需要额外的哈希表记录值到索引的映射。
 * 3、对于这题，数组中含有「空洞」（黑名单数字），也可以利用哈希表巧妙处理映射关系，让数组在逻辑上是紧凑的，方便随机取元素。
 */
public class L710_RandomPickWithBlacklist_008 {

    /*
    Runtime: 39 ms, faster than 83.77% of Java online submissions for Random Pick with Blacklist.
    Memory Usage: 50.4 MB, less than 77.82% of Java online submissions for Random Pick with Blacklist.
     */
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int sz;

        public Solution(int N, int[] blacklist) {
            sz = N - blacklist.length;
            // 先将所有黑名单数字加入 map
            for (int b : blacklist) {
                // 这里赋值多少都可以
                // 目的仅仅是把键存进哈希表
                // 方便快速判断数字是否在黑名单内
                map.put(b, -1);
            }
            int last = N - 1;
            for (int b : blacklist) {
                // 如果 b 已经映射在区间 [sz, N)
                // 可以直接忽略
                if (b >= sz) {
                    continue;
                }
                // 跳过所有黑名单中的数字
                while (map.containsKey(last)) {
                    last--;
                }
                // 将黑名单中的索引映射到合法数字
                map.put(b, last);
                last--;
            }
        }

        Random rand = new Random();

        public int pick() {
            // 随机选取一个索引
            int index = rand.nextInt(sz);
            // 这个索引命中了黑名单，
            // 需要被映射到其他位置
            if (map.containsKey(index)) {
                return map.get(index);
            }
            // 若没命中黑名单，则直接返回
            return index;
        }
    }

}
