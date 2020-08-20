package com.home.henry.trie_17;

import java.util.List;

/**
 * 648. Replace Words
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 * You need to output the sentence after the replacement.
 */
public class L648_ReplaceWords_003 {

    public String replaceWords(List<String> dict, String sentence) {
        String[] token = sentence.split(" ");
        TrieNode trie = buildTrie(dict);
        return replaceWords(token, trie);
    }

    private String replaceWords(String[] tokens, TrieNode root) {
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            sb.append(getShortestReplacement(token, root));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String getShortestReplacement(String token, TrieNode root) {
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();
        for (char c : token.toCharArray()) {
            sb.append(c);
            if (temp.children[c - 'a'] != null) {
                if (temp.children[c - 'a'].isWord) {
                    return sb.toString();
                }
                temp = temp.children[c - 'a'];
            } else {
                return token;
            }
        }
        return token;
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode(' ');
        for (String word : dict) {
            TrieNode tmp = root;
            for (char c : word.toCharArray()) {
                if (tmp.children[c - 'a'] == null) {
                    tmp.children[c - 'a'] = new TrieNode(' ');
                }
                tmp = tmp.children[c - 'a'];
            }
            tmp.isWord = true;
        }
        return root;
    }

    private static class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}

