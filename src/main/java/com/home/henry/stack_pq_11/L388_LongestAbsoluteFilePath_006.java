package com.home.henry.stack_pq_11;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 388. Longest Absolute File Path
 * pop()的地方是返回上层
 */
public class L388_LongestAbsoluteFilePath_006 {

    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        // dummy stack
        stack.push(0);
        int maxLen = 0;
        for (String s : input.split("\n")) {
            // number o= "\t"
            int lev = s.lastIndexOf("\t") + 1;
            // find parent
            while (lev + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + s.length() - lev + 1;
            stack.push(len);
            // check if it is file
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        L388_LongestAbsoluteFilePath_006 l = new L388_LongestAbsoluteFilePath_006();
        System.out.println(l.lengthLongestPath(s));
    }

    // shorter and faster
    public int lengthLongestPathSec(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String s : paths) {
            int lev = s.lastIndexOf("\t") + 1, curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if (s.contains(".")) { maxLen = Math.max(maxLen, curLen - 1); }
        }
        return maxLen;
    }


}
