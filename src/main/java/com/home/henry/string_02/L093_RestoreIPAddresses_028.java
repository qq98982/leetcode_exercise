package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 *
 * String containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 *
 * 一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP，二是只要遇到需要求出所有可能情况首先考虑用递归 。
 * 这道题并非是求字符串的子序列或配准问题，更符合第二种情况，所以我们要用递归来解。
 */
public class L093_RestoreIPAddresses_028 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("25525511135"));
        System.out.println(s.restoreIpAddresses("88888"));
    }

    // 一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP，二是只要遇到需要求出所有可能情况首先考虑用递归 。
    // 这道题并非是求字符串的子序列或配准问题，更符合第二种情况，所以我们要用递归来解。
    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            helper(s, res, 0, 0, "");
            return res;
        }

        // num是ip的第几位, index是ip string的index
        private void helper(String ip, List<String> res, int index, int num, String restored) {
            // 如果num大于4, 停止
            if (num > 4) {return;}
            // 如果 num = 4并且index=ip string的长度了,加入返回结果
            if (num == 4 && index == ip.length()) {
                res.add(restored);
                return;
            }
            for (int i = 1; i < 4; i++) {
                if (index + i > ip.length()) {return;}
                // 截取index到index+3(不包含)
                String str = ip.substring(index, index + i);
                // 如果是0开始并且是大于1, 比如01,03, 不符合要求
                if (str.startsWith("0") && str.length() > 1) {
                    return;
                }
                // 如果是已经3位了,但是结果大于255, 不符合要求
                if (i == 3 && Integer.parseInt(str) >= 256) {
                    return;
                }
                // 如果num是3了就不用加"."了, 其他要加"."分隔
                helper(ip, res, index + i, num + 1, restored + str + ((num == 3) ? "" : "."));
            }
        }

    }
}
