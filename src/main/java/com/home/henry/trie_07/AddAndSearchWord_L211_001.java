package com.home.henry.trie_07;

/**
 * 211. Add and Search Word - Data structure design
 * Ternary Search Trie/ Ternary Search Tree
 * A TST avoid the heavy space requirement of the traditional Trie while still keeping many of its
 * advantages.
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

    /** Initialize your data structure here. */
//    public WordDictionary() {
//
//    }

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

}
