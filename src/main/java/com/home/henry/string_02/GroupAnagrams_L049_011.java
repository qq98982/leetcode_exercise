package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 注意 res.addAll(map.values())这个方法, 也可以使用 List<List<String>> res = new ArrayList<>(map.values());
 */
public class GroupAnagrams_L049_011 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String code = compute(strs[i]);
            if (map.get(code) == null) {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                map.put(code, l);
            } else {
                map.get(code).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static String compute(String str) {
        int[] r = new int[26];
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            r[c[i] - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.length; i++) {
            if (r[i] > 0) {
                sb.append('a' + i).append(r[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams_L049_011 g = new GroupAnagrams_L049_011();
        String[] s = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        final List<List<String>> lists = g.groupAnagrams(s);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
