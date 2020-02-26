package com.home.henry.others.pramp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class ShortestEditPath {

    static int shortestWordEditPath(String source, String target, String[] words) {
        // your code goes here
        // BFS
        Map<String, Integer> map = new HashMap<>();
        map.put(source, 1);
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(source);
        int level = 0;
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int curLevel = map.get(word);
            // compare with words in set
            for (int i = 0; i < word.length(); i++) {
                char[] wordchar = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordchar[i] = c;
                    String tempword = new String(wordchar);
                    if (set.contains(tempword)) {
                        if (tempword.equals(target)) {
                            // find!
                            return curLevel + 1;
                        }
                        map.put(tempword, curLevel + 1);
                        queue.offer(tempword);
                        set.remove(tempword);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String source = "bit", target = "dog";
        String[] words = { "but", "put", "big", "pot", "pog", "dog", "lot" };
        int res = shortestWordEditPath(source, target, words);
        System.out.print(res);
    }
}
