package com.home.henry.binary_search_08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981. Time Based Key-Value Store
 * Java binary search Runtime - set O(1) get (logN) Space - O(N)
 * 思路: 放一个list, 里面是一个obj, 属性是time和value, get的时候二分查找time
 * 推荐tree map方法
 */
public class TimeMap_L981_004 {
    static class TimeMap {

        private class TimeData {
            private int time;
            private String value;

            TimeData(int time, String value) {
                this.time = time;
                this.value = value;
            }
        }

        private Map<String, List<TimeData>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new TimeData(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {return "";}
            List<TimeData> list = map.get(key);
            int left = 0, right = list.size();
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (list.get(mid).time > timestamp) {
                    right = mid;
                } else if (list.get(mid).time < timestamp) {
                    left = mid + 1;
                } else {
                    return list.get(mid).value;
                }
            }
            if (left == 0) {return "";}
            return list.get(left - 1).value;
        }
    }



    public static void main(String[] args) {
        TimeMap m = new TimeMap();
        m.set("foo", "bar", 1);
        System.out.println(m.get("foo", 1));
        System.out.println(m.get("foo", 3));
        m.set("foo", "bar2", 4);
        System.out.println(m.get("foo", 4));
        System.out.println(m.get("foo", 5));
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        System.out.println(treeMap.get(null));
    }

    static class TimeMap2 {

        private Map<String, TreeMap<Integer, String>> map;
        /** Initialize your data structure here. */
        public TimeMap2() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> tmap = map.get(key);
            if (tmap == null) {return "";}
            if (tmap.floorKey(timestamp) == null) {return "";}
            String res = tmap.get(tmap.floorKey(timestamp));
            return res == null ? "" : res;
        }
    }

    class TimeMap3 {
        private class Data {
            Integer timestamp;
            String value;
            Data(Integer timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }
        private Map<String, List<Data>> map;
        /** Initialize your data structure here. */
        public TimeMap3() {
            this.map = new HashMap<String, List<Data>>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<Data>());
            map.get(key).add(new Data(timestamp, value));
        }

        public String get(String key, int timestamp) {
            List<Data> mget = map.get(key);
            if (mget == null) {return "";}
            return binarySearch(mget, timestamp);
        }
        private String binarySearch(List<Data> list, int timestamp) {
            int start = 0, end = list.size() - 1;
            while (start + 1 < end) {
                int mid = (end - start) / 2 + start;
                if (list.get(mid).timestamp <= timestamp) {
                    start = mid;
                } else if (list.get(mid).timestamp > timestamp) {
                    end = mid;
                }
            }
            if (list.get(end).timestamp <= timestamp) {
                return list.get(end).value;
            } else if (list.get(start).timestamp <= timestamp) {
                return list.get(start).value;
            } else {
                return "";
            }
        }
    }
}
