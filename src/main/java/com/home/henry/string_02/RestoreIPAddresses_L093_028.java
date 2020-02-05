package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 *
 * String containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses_L093_028 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("25525511135"));
        System.out.println(s.restoreIpAddresses("88888"));
    }

    static class Solution {

        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            dfs(s, res, 0, 0, "");
            return res;
        }

        private void dfs(String ip, List<String> res, int index, int num, String restored) {
            if (num > 4) {return;}
            if (num == 4 && index == ip.length()) {
                res.add(restored);
                return;
            }
            for (int i = 1; i < 4; i++) {
                if (index + i > ip.length()) {break;}
                String s = ip.substring(index, index + i);
                if (s.startsWith("0") && s.length() > 1) {
                    continue;
                }
                if (i == 3 && Integer.parseInt(s) >= 256) {
                    continue;
                }
                dfs(ip, res, index + i, num + 1, restored + s + ((num == 3) ? "" : "."));
            }
        }

    }
}
