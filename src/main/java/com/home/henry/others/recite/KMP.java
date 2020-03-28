package com.home.henry.others.recite;

import java.util.Arrays;

public class KMP {
    /**
     生成kmp需要的前缀后缀数据,最后结果是[-1,0,x...]
     x代表当前位置 [前] 有多少个完全相同的前缀和后缀字符, 取最大
     比如a b c a b c c就是[-1,0,0,0,1,2,3]
     前缀的意思是这个字符串从第一个字母算, 不加最后一个, 后缀是不加第一个字符,从最后一个字母开始算
     第5个位置上前缀后缀完全相同的是a, 第6个是a b, 第7个是a b c
     */
    private static int[] getNextArray(char[] th) {
        // 如果长度为1, 返回-1
        if (th.length == 1) {return new int[] { -1 };}
        int[] next = new int[th.length];
        next[0] = -1;
        next[1] = 0;
        // pos 指的是正常向后走的位置index, cn指的是最大前缀的位置的后一个index
        int pos = 2, cn = 0;
        while (pos < next.length) {
            if (th[pos - 1] == th[cn]) {
                // 如果最大前缀的后一个位置的值和i - 1的值一样,那么i位置的值应该+1
                next[pos++] = ++cn;
            } else if (cn > 0) {
                // 如果没有匹配上,更新cn值, 最后cn会为0(如果后面持续匹配不上)
                // 在这个分支中没有更新pos, 只更新cn, 所以出最后会匹配到cn为0, 就不走这个if了
                // 0位置的值是0
                cn = next[cn];
            } else {
                // 如果匹配不上,前后缀又没有一样的,那么就是0
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static int getIndexOf(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty() || s1.length() < s2.length()) {return -1;}
        char[] ch = s1.toCharArray();
        char[] th = s2.toCharArray();
        // 获取辅助数组
        int[] p = getNextArray(th);
        // ci是ch长数组的index, ti是th短数组的index
        int ci = 0, ti = 0;
        while (ci < ch.length && ti < th.length) {
            // 如果是相同, index都走一步
            if (ch[ci] == th[ti]) {
                ci++;
                ti++;
            } else if (p[ti] == -1) {
                // 如果是辅助数组的值已经走到-1了, 长数组的++, 准备下一个循环中匹配后一个字母
                ci++;
            } else {
                // 如果没有匹配到, 那么要用到辅助数组中的跳跃, 更新第二个数组的index, 在下个循环中继续匹配
                ti = p[ti];
            }
        }
        return ti == th.length ? ci - ti : -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNextArray("abaaababa".toCharArray())));
        System.out.println(getIndexOf("abcde","bc"));
        System.out.println(getIndexOf("abcdef","de"));
    }
}
