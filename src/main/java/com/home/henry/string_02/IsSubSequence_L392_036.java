package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 392. Is Subsequence
 *
 *
 Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t. t is potentially a very
 long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string by deleting some
 (can be none) of the characters without disturbing the relative positions of the remaining characters.
 (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 s = "abc", t = "ahbgdc" Return true.

 s = "axc", t = "ahbgdc" Return false.

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one
 to see if T has its subsequence. In this scenario, how would you change your code?

 follow up使用了binary search, 思路是将每个字母放到map中, value是一个list, 存储的是index
 前一个字母的index是prev, 那么后一个字母的index在list中就应该是要比prev大的, 后续也一直成立
 寻找这个后面字母的index用到了binary search
 */
public class IsSubSequence_L392_036 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {return false;}
        if (s.length() == 0 || t.length() == 0) {return true;}
        int[] ch = new int[26];
        for (char c : t.toCharArray()) {
            ch[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            ch[c - 'a']--;
        }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] < 0) {
                return false;
            }
        }
        int i = 0, j = 0;
        while (i < t.length()) {
            if (t.charAt(i) != s.charAt(j)) {
                i++;
            } else {
                i++;
                j++;
            }
            if (j == s.length()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) { return false; }
        }
        return true;
    }

    public boolean isSubsequence3(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, List<Integer>> map = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            List<Integer> idx = map.getOrDefault(t.charAt(i), new ArrayList());
            idx.add(i);
            map.put(t.charAt(i), idx);
        }

        int lastFound = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                return false;
            }

            List<Integer> idxList = map.get(s.charAt(i));
            int idx = binSearchHelper(idxList, lastFound);
            if (idx == -1) {
                return false;
            }
            lastFound = idx;
        }

        return true;
    }

    private int binSearchHelper(List<Integer> idxList, int lastFound) {
        int start = 0;
        int end = idxList.size() - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (idxList.get(mid) > lastFound) {
                result = idxList.get(mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

}
