package com.home.henry.others.recite;

public class Manacher {
    /**
     * 对进来的string进行处理, 变成#a#b#c#这种
     */
    private static char[] process(char[] chs) {
        char[] ch = new char[chs.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < ch.length; i++) {
            ch[i] = (i % 2) == 0 ? '#' : chs[index++];
        }
        return ch;
    }

    public static String manacher(String str) {
        char[] chs = str.toCharArray();
        char[] ch = process(chs);
        // C是中心点, R是右边界
        int C = -1, R = -1, start = 0, max = Integer.MIN_VALUE;
        int[] p = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            // 如果是右边界大于当前的i了,那么p[i]要在扩充和R - i中选一个较小的, 否则不能扩, 值是1
            // 2C - i 和 R - i 较小的是因为后面如果到了末尾, 如果还用p中的数据就是错误的
            p[i] = R > i ? Math.min(p[2 * C - i], R - i) : 1;
            while (i + p[i] < ch.length && i - p[i] > -1) {
                // 如果对称的, 则可以更新p
                if (ch[i + p[i]] == ch[i - p[i]]) {
                    p[i]++;
                } else {
                    break;
                }
            }
            // 右边界选小的
            if (i + p[i] > R) {
                R = i + p[i];
                C = i;
            }
            // 更新最大的点, 对应算出start
            if (p[i] > max) {
                max = p[i];
                start = 2 * C - i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start - max + 2; i < start + max; i += 2) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(manacher("abbcba"));
    }
}
