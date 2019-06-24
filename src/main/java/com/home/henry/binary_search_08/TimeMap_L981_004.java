package com.home.henry.binary_search_08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 981. Time Based Key-Value Store
 * Java binary search Runtime - set O(1) get (logN) Space - O(N)
 * 思路: 放一个list, 里面是一个obj, 属性是time和value, get的时候二分查找time
 */
public class TimeMap_L981_004 {

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
    public TimeMap_L981_004() {
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

    public static void main(String[] args) {
        TimeMap_L981_004 m = new TimeMap_L981_004();
        m.set("foo", "bar", 1);
        System.out.println(m.get("foo", 1));
        System.out.println(m.get("foo", 3));
        m.set("foo", "bar2", 4);
        System.out.println(m.get("foo", 4));
        System.out.println(m.get("foo", 5));
    }
}
