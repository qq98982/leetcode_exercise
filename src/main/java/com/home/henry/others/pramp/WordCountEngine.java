package com.home.henry.others.pramp;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implement a document scanning function wordCountEngine, which receives a string document and returns a
 * list of all unique words in it and their number of occurrences, sorted by the number of occurrences in
 * a descending order. If two or more words have the same count, they should be sorted according to their
 * order in the original sentence. Assume that all letters are in english alphabet. You function should be
 * case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.
 *
 * input:  document = "Practice makes perfect. you'll only
 *                     get Perfect by practice. just practice!"
 *
 * output: [ ["practice", "3"], ["perfect", "2"],
 *           ["makes", "1"], ["youll", "1"], ["only", "1"],
 *           ["get", "1"], ["by", "1"], ["just", "1"] ]
 */
public class WordCountEngine {
    static String[][] wordCountEngine(String doc) {
        return null;
    }

    public static String[] preProcess(String str) {
        return str.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    }

    public static void main(String[] args) {
        String str = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        String[] strs = preProcess(str);
        String[][] res = getStrings(strs);
        for (String[] s : res) {
            System.out.print(s[0] + " ");
            System.out.println(s[1]);
        }
    }

    private static String[][] getStrings(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strs) {
            // string[] loop finished, get a map
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // map key -> string, value -> count
        // max is the number of largest number of word
        int max = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        // create a bucket, iterate String[], with help of map
        // every bucket element is a set, every set contains a serial of strings
        // use linked hashset because it need string occur orders
        Set<String>[] bucket = new LinkedHashSet[max + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedHashSet<>();
        }
        for (String s : strs) {
            bucket[map.get(s)].add(s);
        }
        String[][] res = new String[map.size()][2];
        int count = 0;
        for (int i = bucket.length - 1; i > 0; i--) {
            Set<String> set = bucket[i];
            for (String s : set) {
                res[count][0] = s;
                res[count][1] = String.valueOf(i);
                count++;
            }
        }
        return res;
    }
}
