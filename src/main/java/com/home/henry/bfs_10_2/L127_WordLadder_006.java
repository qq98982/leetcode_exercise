package com.home.henry.bfs_10_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Because we need the shortest path from one word to another and DFS is not suitable for finding the shortest path.
 * use BFS to traverse every level with all possible words that only need to replace one character from previous
 * level, once we found the endWord, return current ladder + 1
 */
public class L127_WordLadder_006 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return 0;
        }

        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        // WARNING: ladder MUST start at 1
        int ladder = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();

                // try all possible substitution (26 characters) in every position of current word
                for (int j = 0; j < curWord.length(); j++) {
                    char[] curWordArr = curWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        curWordArr[j] = c;

                        String newWord = new String(curWordArr);
                        if (newWord.equals(endWord) && dict.contains(endWord)) {
                            return ladder + 1;
                        }

                        // add possible word for next ladder (level)
                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            ladder++;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int curLevel = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return curLevel + 1;
                        }
                        map.put(temp, curLevel + 1);
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}
