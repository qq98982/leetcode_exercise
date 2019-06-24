package com.home.henry.stack_pq_11;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. Simplify Path
 */
public class SimplifyPath_L071_005 {

    public String simplifyPath(String path) {
        if (path == null || path.equals("")) {
            return "";
        }
        String[] pathSplit = path.split("/");
        Deque stk = new LinkedList();
        for (String single : pathSplit) {
            if (single.equals("..")) {
                stk.poll();
            } else if (!single.equals("") && !single.equals(".")) {
                stk.push(single);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stk.size() == 0) {
            return "/";
        }
        while (stk.size() != 0) {
            sb.append("/").append(stk.pollLast());
        }
        return sb.toString();
    }

}
