package com.home.henry.union_find_16;

/**
 * 839. Similar String Groups
 *
 * 大意是指相似的词可以放到一组中, 注意有可能不是互相相似的也可以通过其他变成一组
 * 相似的意思是指一个词可以通过swap两个字母, 变成另外一个词, 就算是相似
 * Input: ["tars","rats","arts","star"] Output: 2
 * 分别是 {"tars", "rats", "arts"} and {"star"}
 * 可以用Union Find做这个题
 */
public class L839_SimilarStringGroups_009 {
    static class Solution {
        static class UnionFind {
            int count;
            int[] parent;
            int[] size;

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
                vali(p);
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            private void vali(int p) {
                if (p < 0 || p > parent.length - 1) {
                    throw new IllegalArgumentException();
                }
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

            public int count() {
                return count;
            }
        }

        public int numSimilarGroups(String[] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            UnionFind uf = new UnionFind(A.length);
            for (int i = 0; i < A.length - 1; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    boolean similar = checkSimilar(A[i], A[j]);
                    if (similar) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.count();
        }

        private boolean checkSimilar(String s, String t) {
            int res = 0, len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != t.charAt(i) && ++res > 2) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.numSimilarGroups(new String[] { "tars", "rats", "arts", "star" }));
        // 11
        System.out.println(
                s.numSimilarGroups(new String[] {
                        "qihcochwmglyiggvsqqfgjjxu", "gcgqxiysqfqugmjgwclhjhovi",
                        "gjhoggxvcqlcsyifmqgqujwhi", "wqoijxciuqlyghcvjhgsqfmgg",
                        "qshcoghwmglygqgviiqfjcjxu", "jgcxqfqhuyimjglgihvcqsgow",
                        "qshcoghwmggylqgviiqfjcjxu", "wcoijxqiuqlyghcvjhgsqgmgf",
                        "qshcoghwmglyiqgvigqfjcjxu", "qgsjggjuiyihlqcxfovchqmwg",
                        "wcoijxjiuqlyghcvqhgsqgmgf", "sijgumvhqwqioclcggxgyhfjq",
                        "lhogcgfqqihjuqsyicxgwmvgj", "ijhoggxvcqlcsygfmqgqujwhi",
                        "qshcojhwmglyiqgvigqfgcjxu", "wcoijxqiuqlyghcvjhgsqfmgg",
                        "qshcojhwmglyiggviqqfgcjxu", "lhogcgqqfihjuqsyicxgwmvgj",
                        "xscjjyfiuglqigmgqwqghcvho", "lhggcgfqqihjuqsyicxgwmvoj",
                        "lhgocgfqqihjuqsyicxgwmvgj", "qihcojhwmglyiggvsqqfgcjxu",
                        "ojjycmqshgglwicfqguxvihgq", "sijvumghqwqioclcggxgyhfjq",
                        "gglhhifwvqgqcoyumcgjjisqx"
                }));
    }
}
