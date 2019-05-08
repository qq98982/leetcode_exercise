package com.home.henry.trie_07;

/**
 * 720. Longest Word in Dictionary
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * If there is no answer, return the empty string.
 * Example 1:
 * Input: words = ["w","wo","wor","worl", "world"]  Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 */
public class LongestWordInDictionary_L720_006 {

    /**
     * Build a trie in the normal way, then do a dfs to find the longest continuous downward path from the root.
     * This is not a particularly hard question in the context of trie, the point of this solution is to
     * present a generic way of trie building and inserting that can be easily adapted to similar questions.
     */
    public static class Solution {
        public String longestWord(String[] words) {
            TrieNode root = new TrieNode();
            root.word = "-";
            for (String word : words) {
                root.insert(word);
            }
            return dfs(root, "");
        }

        private String dfs(TrieNode node, String accum) {
            if (node == null || node.word.length() == 0) {
                return accum;
            }
            String res = "";
            if (!node.word.equals("-")) {
                accum = node.word;
                for (TrieNode child : node.nexts) {
                    String currRes = dfs(child, accum);
                    if (currRes.length() > res.length() || (currRes.length() == res.length()
                                                            && currRes.compareTo(res) < 0)) {
                        res = currRes;
                    }
                }
            }
            return res;
        }
    }

    private static class TrieNode {
        private String word = "";
        private TrieNode[] nexts = new TrieNode[26];

        void insert(String s) {
            char[] chs = s.toCharArray();
            TrieNode curr = this;
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (curr.nexts[index] == null) {
                    curr.nexts[index] = new TrieNode();
                }
                curr = curr.nexts[index];
            }
            curr.word = s;
        }
    }
}
