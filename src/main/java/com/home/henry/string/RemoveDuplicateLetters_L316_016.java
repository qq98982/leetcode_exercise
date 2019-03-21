package com.home.henry.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * Input: "bcabc" Output: "abc"
 * Input: "cbacdcbc" Output: "acdb
 *
 * The basic idea is to find out the smallest result letter by letter (one letter at a time). Here is the thinking process for input "cbacdcbc":
 *
 * find out the last appeared position for each letter;
 * c - 7
 * b - 6
 * a - 2
 * d - 4
 * find out the smallest index from the map in step 1 (a - 2);
 * the first letter in the final result must be the smallest letter from index 0 to index 2;
 * repeat step 2 to 3 to find out remaining letters.
 * the smallest letter from index 0 to index 2: a
 * the smallest letter from index 3 to index 4: c
 * the smallest letter from index 4 to index 4: d
 * the smallest letter from index 5 to index 6: b
 * so the result is "acdb"
 *
 * Notes:
 *
 * after one letter is determined in step 3, it need to be removed from the "last appeared position map", and the same letter should be ignored in the following steps
 * in step 3, the beginning index of the search range should be the index of previous determined letter plus one
 */
public class RemoveDuplicateLetters_L316_016 {

    public String removeDuplicateLetters(String s) {
        if (null == s || s.length() == 0) {return "";}
        Map<Character, Integer> lastPosMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPosMap.put(s.charAt(i), i);
        }
        char[] result = new char[lastPosMap.size()];
        int begin = 0, end = findMinLastPos(lastPosMap);
        for (int i = 0; i < result.length; i++) {
            char minChar = 'z' + 1;
            for (int k = begin; k <= end; k++) {
                if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    begin = k + 1;
                }
            }
            result[i] = minChar;
            if (i == result.length - 1) {
                break;
            }
            lastPosMap.remove(minChar);
            if (s.charAt(end) == minChar) {
                end = findMinLastPos(lastPosMap);
            }
        }
        return new String(result);
    }

    private int findMinLastPos(Map<Character, Integer> lastPosMap) {
        if (lastPosMap == null || lastPosMap.isEmpty()) {
            return -1;
        }
        int minLastPos = Integer.MAX_VALUE;
        for (int lastPos : lastPosMap.values()) {
            minLastPos = Math.min(minLastPos, lastPos);
        }
        return minLastPos;
    }

}
