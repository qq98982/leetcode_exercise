package com.home.henry.others.recite;

/**
 * Robin Karp版本的查找字符串
 */
public class RobinKarp {
    /**
     * 滚动哈希法(Rolling Hash)：
     * 母串是"abcde"，子串是"cde"
     * 则母串先计算"abc"的哈希值：
     * <p>
     * a×(31^2)+b×(31^1)+c×(31^0)
     * 而子串"cde"的哈希值是：
     * <p>
     * c×(31^2)+d×(31^1)+e×(31^0)
     * 与母串哈希值不匹配，于是母串向后继续计算哈希值,下标i=3指向字母d，
     * <p>
     * (a×(31^2)+b×(31^1)+c×(31^0))×31+d−a×(31^3)
     * 前n个字符的hash * 31 - 前n字符的第一字符 * 31的n次方（n是子串长度）
     * 可以计算出母串中"bcd"的哈希值，再与子串哈希值进行比较
     */
    public int strStr(String source, String target) {
        final int BASE = 100000;
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        final int m = target.length();
        if (m == 0) {
            return 0;
        }

        int targetHashCode = 0;
        for (int i = 0; i < m; i++) {
            targetHashCode = (targetHashCode * 31 + target.charAt(i)) % BASE;
        }

        // 31^m target最高位的31方
        int power = 1;
        for (int i = 0; i < target.length(); i++) {
            power = (power * 31) % BASE;
        }
        int sourceHashCode = 0;
        for (int i = 0; i < source.length(); i++) {
            sourceHashCode = (sourceHashCode * 31 + source.charAt(i)) % BASE;
            if (i < m - 1) {continue;}
            if (i >= m) {
                sourceHashCode = (sourceHashCode - source.charAt(i - m) * power) % BASE;
                if (sourceHashCode < 0) {
                    sourceHashCode += BASE;
                }
            }
            if (sourceHashCode == targetHashCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }

}
