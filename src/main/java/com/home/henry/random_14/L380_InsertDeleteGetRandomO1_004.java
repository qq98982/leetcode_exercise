package com.home.henry.random_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 380. Insert Delete GetRandom O(1)
 *
 * 标准的HashSet，你能否在 O(1) 的时间内实现getRandom函数? HashSet的底层原理就是一个大数组，我们把元素通过哈希函数映射到一个索引上
 * 元素是被哈希函数「分散」到整个数组里面的，更别说还有拉链法等等解决哈希冲突的机制，基本做不到 O(1) 时间等概率随机获取元素。
 * getRandom方法，如果想「等概率」且「在 O(1) 的时间」取出元素，一定要满足：底层用数组实现，且数组必须是紧凑的。
 * 但如果用数组存储元素的话，插入，删除的时间复杂度怎么可能是 O(1) 呢？
 * 可以做到！对数组尾部进行插入和删除操作不会涉及数据搬移，时间复杂度是 O(1)。
 * 所以，如果我们想在 O(1) 的时间删除数组中的某一个元素val，可以先把这个元素交换到数组的尾部，然后再remove掉。
 * 交换两个元素必须通过索引进行交换对吧，那么我们需要一个HashMap来记录每个元素值对应的索引。
 *
 * 这个题目的follow up是如果允许数字重复, 如何处理?
 * 原理是在HashMap中使用Set去记录相应的index
 */
public class L380_InsertDeleteGetRandomO1_004 {

    /*
    Runtime: 12 ms, faster than 39.73% of Java online submissions for Insert Delete GetRandom O(1).
    Memory Usage: 44 MB, less than 88.76% of Java online submissions for Insert Delete GetRandom O(1).
     */
    public static class RandomizedSet {
        ArrayList<Integer> nums;
        HashMap<Integer, Integer> map;
        java.util.Random rand = new java.util.Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new ArrayList<Integer>();
            map = new HashMap<Integer, Integer>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            // 若 val 已存在，不用再插入
            if (map.containsKey(val)) {return false;}
            // 若 val 不存在，插入到 nums，
            // 并记录 val 对应的索引值
            nums.add(val);
            map.put(val, nums.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            // 若 val 不存在，不用再删除
            if (!map.containsKey(val)) {return false;}
            // 先拿到 val 的索引
            int oldIndex = map.get(val);
            if (oldIndex != nums.size() - 1) {
                // 交换 val 和最后一个元素
                int lastVal = nums.get(nums.size() - 1);
                nums.set(oldIndex, lastVal);
                map.put(lastVal, oldIndex);
            }
            // 删除元素 val 对应的索引
            map.remove(val);
            // 在数组中删除元素 val
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

//    The follow-up: allowing duplications.
//    For example, after insert(1), insert(1), insert(2), getRandom() should have 2/3 chance return 1 and 1/3 chance return 2.
//    Then, remove(1), 1 and 2 should have an equal chance of being selected by getRandom().
//
//    The idea is to add a set to the hashMap to remember all the locations of a duplicated number.

    public static class RandomizedSetWithDuplicate {
        ArrayList<Integer> nums;
        HashMap<Integer, Set<Integer>> map;
        java.util.Random rand = new java.util.Random();

        /** Initialize your data structure here. */
        public RandomizedSetWithDuplicate() {
            nums = new ArrayList<Integer>();
            map = new HashMap<Integer, Set<Integer>>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contain = map.containsKey(val);
            if (!contain) { map.put(val, new HashSet<>()); }
            map.get(val).add(nums.size());
            nums.add(val);
            return !contain;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            boolean contain = map.containsKey(val);
            if (!contain) { return false;}
            int loc = map.get(val).iterator().next();
            map.get(val).remove(loc);
            if (loc < nums.size() - 1) {
                int lastone = nums.get(nums.size() - 1);
                nums.set(loc, lastone);
                map.get(lastone).remove(nums.size() - 1);
                map.get(lastone).add(loc);
            }
            nums.remove(nums.size() - 1);
            if (map.get(val).isEmpty()) { map.remove(val); }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

}
