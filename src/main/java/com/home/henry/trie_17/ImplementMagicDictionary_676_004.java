package com.home.henry.trie_17;

/**
 * 676. Implement Magic Dictionary
 */
public class ImplementMagicDictionary_676_004 {

    private TrieNode root;

    /** Initialize your data structure here. */
    public ImplementMagicDictionary_676_004() {
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (arr[i] == c) {continue;}
                char org = arr[i];
                arr[i] = c;
                if (wordComplete(arr, root)) {
                    return true;
                }
                arr[i] = org;
            }
        }
        return false;
    }

    private boolean wordComplete(char[] arr, TrieNode root) {
        TrieNode node = root;
        for (char c : arr) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    private static class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {}
    }
}
