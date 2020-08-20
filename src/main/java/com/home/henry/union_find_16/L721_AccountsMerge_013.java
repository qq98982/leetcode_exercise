package com.home.henry.union_find_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 721. Accounts Merge
 *
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 * ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 *
 * list中的名字和邮件, 有些不全, 所以根据邮件可以匹配到是不是一个人, 如果有相同的邮件 认为是同一个人, 放到一个list中
 *
 * 思路也是使用Union Find, 先是将所有的email放到map中, 如果下次有相同的email, 然后将email的两个所在组union起来
 * 建立一个map, key是同一个email组的最高级, values是这个组的所有emails的set, 放到set中时可以用subList(1, ...)只放email
 * 遍历刚才的那个map, 里面的所有的email放到一个list中, 然后在0位置上加上当前这个组的0位置的姓名(他们是都相同的)
 */
public class L721_AccountsMerge_013 {

    static class Solution {
        static class UnionFind {
            private int[] parent, size;
            private int count;

            UnionFind(int n) {
                parent = new int[n];
                size = new int[n];
                count = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public int find(int p) {
                valid(p);
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void valid(int p) {
                if (p < 0 || p > parent.length - 1) { throw new IllegalArgumentException();}
            }

            public int count() {
                return count;
            }

            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {return;}
                if (size[rootP] > size[rootQ]) {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }
                count--;
            }
        }

        // 先是将所有的email放到map中, 如果下次有相同的email, 然后将email的两个所在组union起来
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            List<List<String>> res = new ArrayList<>();
            if (accounts == null || accounts.size() == 0) {
                return res;
            }
            Map<String, Integer> emailMap = new HashMap<>();
            UnionFind uf = new UnionFind(accounts.size());
            for (int i = 0; i < accounts.size(); i++) {
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    String currEmail = accounts.get(i).get(j);
                    if (emailMap.containsKey(currEmail)) {
                        uf.union(i, emailMap.get(currEmail));
                    } else {
                        emailMap.put(currEmail, i);
                    }
                }
            }
            // 建立一个map, key是同一个email组的最高级, values是这个组的所有emails的set
            Map<Integer, Set<String>> emailSetsMap = new HashMap<>();
            for (int i = 0; i < accounts.size(); i++) {
                int root = uf.find(i);
                if (!emailSetsMap.containsKey(root)) {
                    emailSetsMap.put(root, new HashSet<>());
                }
                List<String> emails = accounts.get(i);
                emailSetsMap.get(root).addAll(emails.subList(1, emails.size()));
            }
            // 遍历刚才的那个map, 里面的所有的email放到一个list中, 然后在0位置上加上当前这个组的0位置的姓名(他们是都相同的)
            for (int key : emailSetsMap.keySet()) {
                List<String> one = new ArrayList<>(emailSetsMap.get(key));
                Collections.sort(one);
                one.add(0, accounts.get(key).get(0));
                res.add(one);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        list.add(Arrays.asList("John", "johnnybravo@mail.com"));
        list.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        list.add(Arrays.asList("Mary", "mary@mail.com"));
        // [[John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com], [John, johnnybravo@mail.com], [Mary, mary@mail.com]]
        System.out.println(s.accountsMerge(list));
    }
}
