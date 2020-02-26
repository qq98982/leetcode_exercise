package com.home.henry.others.pramp;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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
        Map<String, Integer> map = new HashMap<>();
        for (String s : strs) {
            // string[] loop finished, get a map
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // map key -> string, value -> count
        int max = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        // create a bucket, iterate String[], with help of map
        Set<String>[] bucket = new LinkedHashSet[max + 1];
        for (int i = 0; i < bucket.length;i++) {
            bucket[i] = new LinkedHashSet<String>();
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
        for(String[] s : res) {
            System.out.print(s[0] + " ");
            System.out.println(s[1]);
        }
    }
}
