package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting
 * indices of substring(s) in s that is a concatenation of each word in words exactly once and without any
 * intervening characters.
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"] Output: []
 */
public class SubstringWithConcatenationOfAllWords_L030_043 {

    public static class Solution {
        public static List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.isEmpty() || words == null || words.length == 0) {return res;}
            if (s.length() < words.length * words[0].length()) {return res;}
            Map<String, Integer> map = new HashMap<>();
            // 将所有的words放到map中, value为个数
            for (String str : words) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            int n = words.length, m = words[0].length();
            // 每个单词是同样的长度, 所有i小于等于str.length() - n * m就可以, 个数不同, 后面再匹配也不能完成
            for (int i = 0; i <= s.length() - n * m; i++) {
                int count = n, j = i;
                // 将上面的map放入临时的map中, 这样不会更改其原始数据
                Map<String, Integer> tempMap = new HashMap<>(map);
                while (count > 0) {
                    String ss = s.substring(j, j + m);
                    // 如果新切割的单词已经不在map中, 这个字母开始的已经不能用了, break
                    if (tempMap.getOrDefault(ss, 0) < 1) {
                        break;
                    }
                    // 如果有,将其在map中的数字-1, count也减1, j的index前移m位
                    tempMap.put(ss, tempMap.get(ss) - 1);
                    count--;
                    j += m;
                }
                // 如果有从i开始, 有count个单词, 正好完成了, 加入这个index到返回中
                if (count == 0) {
                    res.add(i);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        assert Solution.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }).contains(0);
        assert Solution.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }).contains(9);
        assert Solution.findSubstring("wordgoodgoodgoodbestword",
                                      new String[] { "word", "good", "best", "word" }).isEmpty();
    }

}
