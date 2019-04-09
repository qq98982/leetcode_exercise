package com.home.henry.trie;

/**
 * 677. Map Sum Pairs
 */
public class MapSumPairs_L677_005 {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int weight = 0;
    }

    TrieNode root;

    public MapSumPairs_L677_005() {
        root = new TrieNode();
    }

    public void insert(String key, int value) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.weight = value;
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {return 0;}
            curr = curr.children[c - 'a'];
        }
        return dfs(curr);
    }

    private int dfs(TrieNode curr) {
        int sum = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (curr.children[c - 'a'] != null) {
                sum += dfs(curr.children[c - 'a']);
            }
        }
        return sum + curr.weight;
    }
}
