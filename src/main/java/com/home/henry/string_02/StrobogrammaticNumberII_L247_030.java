package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 247. Strobogrammatic Number II
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 *
 * Input:  n = 2 Output: ["11","69","88","96"]
 *
 *
 * 这道题是之前那道 Strobogrammatic Number 的拓展，那道题让我们判断一个数是否是对称数，而这道题让找出长度为n的所有的对称数，
 * 这里肯定不能一个数一个数的来判断，那样太不高效了，而且 OJ 肯定也不会答应。题目中给了提示说可以用递归来做，而且提示了递归调用 n-2，
 * 而不是 n-1。先来列举一下n为 0,1,2,3,4 的情况：
 * n = 0:   none
 * n = 1:   0, 1, 8
 * n = 2:   11, 69, 88, 96
 * n = 3:   101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986
 * n = 4:   1001, 6009, 8008, 9006, 1111, 6119, 8118, 9116, 1691, 6699, 8698, 9696, 1881, 6889, 8888, 9886, 1961, 6969, 8968, 9966
 *
 * 注意观察 n=0 和 n=2，可以发现后者是在前者的基础上，每个数字的左右增加了 [1 1], [6 9], [8 8], [9 6]，看 n=1 和 n=3 更加明显，
 * 在0的左右增加 [1 1]，变成了 101, 在0的左右增加 [6 9]，变成了 609, 在0的左右增加 [8 8]，变成了 808, 在0的左右增加 [9 6]，
 * 变成了 906, 然后在分别在1和8的左右两边加那四组数，实际上是从 m=0 层开始，一层一层往上加的，需要注意的是当加到了n层的时候，
 * 左右两边不能加 [0 0]，因为0不能出现在两位数及多位数的开头，在中间递归的过程中，需要有在数字左右两边各加上0的那种情况
 */
public class StrobogrammaticNumberII_L247_030 {
    static class Solution {
        public static List<String> findStrobogrammatic(int n) {
            return helper(n, n);
        }

        private static List<String> helper(int n, int m) {
            if (n == 0) { return new ArrayList(Arrays.asList(""));}
            if (n == 1) { return new ArrayList(Arrays.asList("0", "1", "8"));}
            List<String> list = helper(n - 2, m);
            List<String> res = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (n != m) {
                    res.add("0" + s + "0");
                }
                res.add("1" + s + "1");
                res.add("6" + s + "9");
                res.add("8" + s + "8");
                res.add("9" + s + "6");
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.findStrobogrammatic(3));
        System.out.println(Solution.findStrobogrammatic(4));
    }
}
