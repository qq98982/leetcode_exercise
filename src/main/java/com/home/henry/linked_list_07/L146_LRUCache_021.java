package com.home.henry.linked_list_07;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 */

public class L146_LRUCache_021 {
    private static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    private static class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            this.head.next = tail;
            this.tail.prev = head;
            this.size = 0;
        }

        public void addLast(Node x) {
            x.prev = this.tail.prev;
            x.next = this.tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        // 删除链表中的 x 节点(x 一定存在)
        // 由于是双链表且给的是目标 Node 节点,时间 O(1)
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {return null;}
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }

    }

    private Map<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public L146_LRUCache_021(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    private void makeRecently(int key) {
        Node x = map.get(key);
        // 先从链表中删除这个节点
        cache.remove(x);
        // 重新插到队尾
        cache.addLast(x);
    }

    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // 链表尾部就是最近使用的元素
        cache.addLast(x);
        // 别忘了在 map 中添加 key 的映射
        map.put(key, x);
    }

    private void deleteKey(int key) {
        Node x = map.get(key);
        // 从链表中删除
        cache.remove(x);
        // 从 map 中删除
        map.remove(key);
    }

    private void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        Node deleteNode = cache.removeFirst();
        // 同时别忘了从 map 中删除它的 key
        int deleteKey = deleteNode.key;
        map.remove(deleteKey);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {return -1;}
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (cap == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

}

class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}