package com.home.henry.trie_17;

/**
 * 211. Add and Search Word - Data structure design
 *
 * Ternary Search Trie/ Ternary Search Tree
 * A TST avoid the heavy space requirement of the traditional Trie while still keeping many of its
 * advantages.
 *
 * 3路trie和普通的trie结构, 推荐3路trie
 */
public class AddAndSearchWord_L211_001 {

    private Node root;

    private class Node {
        char data;
        boolean isLastChar;
        Node left, equal, right;

        private Node(char d) {
            data = d;
            isLastChar = false;
            left = right = equal = null;
        }
    }

    private Node insert(Node curr, String word, int wordIndex) {
        if (curr == null) {
            curr = new Node(word.charAt(wordIndex));
        }
        if (word.charAt(wordIndex) < curr.data) {
            curr.left = insert(curr.left, word, wordIndex);
        } else if (word.charAt(wordIndex) > curr.data) {
            curr.right = insert(curr.right, word, wordIndex);
        } else {
            if (wordIndex < word.length() - 1) {
                curr.equal = insert(curr.equal, word, wordIndex + 1);
            } else {
                curr.isLastChar = true;
            }
        }
        return curr;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root = insert(root, word, 0);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(root, word, 0);
    }

    private boolean find(Node curr, String word, int wordIndex) {
        if (curr == null) {
            return false;
        }

        if (word.charAt(wordIndex) == '.') {
            if (wordIndex == word.length() - 1) {
                return curr.isLastChar;
            } else {
                return find(curr.left, word, wordIndex) || find(curr.equal, word, wordIndex + 1) || find(
                        curr.right, word, wordIndex);
            }
        }

        if (word.charAt(wordIndex) < curr.data) {
            return find(curr.left, word, wordIndex);
        } else if (word.charAt(wordIndex) > curr.data) {
            return find(curr.right, word, wordIndex);
        } else {
            if (wordIndex == word.length() - 1) {
                return curr.isLastChar;
            }
            return find(curr.equal, word, wordIndex + 1);
        }
    }

    static class Solution {
        class WordDictionary {

            /** Initialize your data structure here. */
            class Trie {
                Trie[] children;
                boolean isComplete = false;

                public Trie() {
                    children = new Trie[26];
                }
            }

            Trie root;

            public WordDictionary() {
                root = new Trie();
            }

            /** Adds a word into the data structure. */
            public void addWord(String word) {

                Trie curr = root;

                for (char c : word.toCharArray()) {
                    Trie childNode = curr.children[c - 'a'];
                    if (childNode == null) {
                        childNode = new Trie();
                        curr.children[c - 'a'] = childNode;
                    }
                    curr = childNode;
                }
                curr.isComplete = true;
            }

            /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
            public boolean search(String word) {
                char[] ch = word.toCharArray();
                return find(ch, root, 0);
            }

            private boolean find(char[] ch, Trie curr, int pos) {

                if (pos == ch.length) { return curr.isComplete; }
                if (pos > ch.length) { return false; }

                if (ch[pos] == '.') {
                    for (int i = 0; i < 26; i++) {
                        if (curr.children[i] != null && find(ch, curr.children[i], pos + 1)) { return true; }
                    }
                } else {
                    return curr.children[ch[pos] - 'a'] != null && find(ch, curr.children[ch[pos] - 'a'],
                                                                        pos + 1);
                }
                return false;
            }
        }
    }
}
