package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."] maxWidth = 16
 * Output: [ "This    is    an", "example  of text", "justification.  " ]
 */
public class TextJustification_L068_021 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) {
                    break;
                }
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(words[index]);
            int diff = last - index - 1;
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    builder.append(' ');
                    builder.append(words[i]);
                }
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(' ');
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k > 0; k--) {
                        builder.append(' ');
                    }
                    if (r > 0) {
                        builder.append(' ');
                        r--;
                    }
                    builder.append(' ');
                    builder.append(words[i]);
                }
            }
            res.add(builder.toString());
            index = last;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.fullJustify(
                new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16);
        System.out.println(res);
    }

    private static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            // init return list
            List<String> res = new ArrayList<>();
            // check boundary
            if (words == null || words.length == 0) {return res;}
            if (words.length == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(words[0]);
                for (int i = words[0].length(); i < maxWidth; i++) {
                    sb.append(' ');
                }
                res.add(sb.toString());
                return res;
            }
            // init index of word "index" and "last", last = index + 1
            int index = 0;
            // while (words is not finish)
            while (index < words.length) {
                int last = index + 1;
                int count = words[index].length();
                // not reach last word
                while (last < words.length) {
                    // over 1 line limit, break, else add a new word and update length, index
                    if (words[last].length() + 1 + count > maxWidth) {
                        break;
                    }
                    count += 1 + words[last].length();
                    last++;
                }
                int wordNumber = last - index, bucketNum = wordNumber - 1;
                StringBuilder builder = new StringBuilder();
                // this is last line or single word
                if (last == words.length || bucketNum == 0) {
                    // add spaces till end, final position should space
                    // stringbuilder add word and space
                    int inCount = 0;
                    for (int i = index; i < last; i++) {
                        builder.append(words[i]);
                        inCount += words[i].length();
                        if (inCount < maxWidth) {
                            builder.append(' ');
                        }
                    }
                    while (inCount < maxWidth) {
                        builder.append(' ');
                        inCount++;
                    }
                } else {
                    // not last line or single word, final position should be letter
                    // stringbuilder add word and space
                    int inCount = 0;
                    for (int i = index; i < last; i++) {
                        inCount += words[i].length();
                    }
                    int left = maxWidth - inCount;
                    int r = left % bucketNum;
                    int even = left / bucketNum;
                    for (int i = index; i < last; i++) {
                        builder.append(words[i]);
                        for (int k = even; k > 0 && i < last - 1; k--) {
                            builder.append(' ');
                        }
                        if (r > 0) {
                            builder.append(' ');
                            r--;
                        }
                    }
                }
                res.add(builder.toString());
                index = last;
            }
            return res;
        }
    }
}
