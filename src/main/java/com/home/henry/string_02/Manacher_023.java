package com.home.henry.string_02;

/**
 * Manacher算法, 用于O(n)寻找出最短的Palindrome
 */
public class Manacher_023 {
    public static char[] manacherStringString(String str) {
        char[] c = str.toCharArray();
        char[] res = new char[c.length * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i % 2) == 0 ? '#' : c[index++];
            // 两个一样效果
            // res[i] = (i & 1) == 0 ? '#' : c[index++];
        }
        return res;
    }

    public static String maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArr = manacherStringString(str);
        int[] pArr = new int[charArr.length];
        int C = -1;
        int R = -1;
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            // i在右边界内, i`到C的长度和到i到R的距离, 哪个小, 哪个就是起码成为回文的区域
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 如果大于R, 那更新回文右边界和中心点
            if ((i + pArr[i]) > R) {
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > max) {
                max = pArr[i];
                start = 2 * C - i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start - max + 2; i < start + max; i += 2) {
            sb.append(charArr[i]);
        }
        return sb.toString();
    }

    private static char[] preHandle(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }
        return sb.toString().toCharArray();
    }

    /**
     * 第二个方法
     * 1、先对字符串进行预处理，两个字符之间加上特殊符号#
     * 2、然后遍历整个字符串，用一个数组来记录以该字符为中心的回文长度，为了方便计算右边界，数组中记录长度的一半（向下取整）
     * 3、每一次遍历的时候，如果该字符在已知回文串最右边界的覆盖下，那么就计算其相对最右边界回文串中心对称的位置，得出已知回文串的长度
     * 4、判断该长度和右边界，如果达到了右边界，那么需要进行中心扩展探索。当然，如果第3步该字符没有在最右边界的范围内，则直接进行中心扩展探索。
     *    进行中心扩展探索的时候，同时又更新右边界
     * 5、最后得到最长回文之后，去掉其中的特殊符号
     * 参考 https://mp.weixin.qq.com/s?__biz=MzIzMTE1ODkyNQ==&mid=2649410225&idx=1&sn=ed045e8edc3c49a436a328e5f0f37a55&chksm=f0b60f53c7c18645b4c04a69ad314723cce94ed56994d6f963c2275a2db8d85f973f15f508e4&mpshare=1&scene=23&srcid=1001JCsBlpxgUWjgixasChNQ#rd
     */
    public static String findLongestPalindromeString(String s) {
        char[] sArr = preHandle(s);
        // 处理后的字串长度
        int len = s.length();
        // 右边界
        int rightSide = 0;
        // 右边界对应的回文串中心
        int rightSideCenter = 0;
        // 保存以每个字符为中心的回文长度一半（向下取整）
        int[] halfLenArr = new int[len];
        // 记录回文中心
        int center = 0;
        // 记录最长回文长度
        int longestHalf = 0;
        for (int i = 0; i < len; i++) {
            // 是否需要中心扩展
            boolean needCalc = true;
            // 如果在右边界的覆盖之内
            if (rightSide > i) {
                // 计算相对rightSideCenter的对称位置, i是已经乘过2的
                int leftCenter = 2 * rightSideCenter - i;
                // 对称点记录的值相等
                halfLenArr[i] = halfLenArr[leftCenter];
                // 如果根据已知条件计算得出的最长回文小于右边界，则不需要扩展了
                if (i + halfLenArr[i] < rightSide) {
                    needCalc = false;
                }
                // 如果超过了右边界，进行调整
                if (i + halfLenArr[leftCenter] > rightSide) {
                    // ----- | -----
                    // |-----------|
                    halfLenArr[i] = rightSide - i;
                }
            }
            if (needCalc) {
                while (i - 1 - halfLenArr[i] >= 0 && i + 1 + halfLenArr[i] < len) {
                    if (sArr[i + 1 + halfLenArr[i]] == sArr[i - 1 - halfLenArr[i]]) {
                        halfLenArr[i]++;
                    } else {
                        break;
                    }
                }
                // 更新右边界及中心
                rightSide = i + halfLenArr[i];
                rightSideCenter = i;
                // 记录最长回文串
                if (halfLenArr[i] > longestHalf) {
                    center = i;
                    longestHalf = halfLenArr[i];
                }

            }
        }
        // 去掉之前添加的#
        StringBuffer sb = new StringBuffer();
        for (int i = center - longestHalf + 1; i <= center + longestHalf; i += 2) {
            sb.append(sArr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] testStrArr = new String[] {
                "aca",
                "abcdcef",
                "a",
                "",
                "adaelele",
                "cabadabae",
                "aaaabcdefgfedcbaa",
                "aaba",
                "aaaaaaaaa"
        };
        for (String str : testStrArr) {
            System.out.println(String.format("原字串 : %s", str));
            System.out.println(String.format("最长回文串 : %s", maxLcpsLength(str)));
            System.out.println();
        }

    }
}
