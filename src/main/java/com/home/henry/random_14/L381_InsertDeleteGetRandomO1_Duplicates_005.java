package com.home.henry.random_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * For example, after insert(1), insert(1), insert(2), getRandom() should have 2/3 chance return 1 and 1/3 chance return 2.
 * Then, remove(1), 1 and 2 should have an equal chance of being selected by getRandom().
 * The idea is to add a set to the hashMap to remember all the locations of a duplicated number.
 */
public class L381_InsertDeleteGetRandomO1_Duplicates_005 {

    static class RandomizedCollection {

        List<Integer> list;
        Map<Integer, Set<Integer>> locs;
        Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            this.list = new ArrayList<Integer>();
            this.locs = new HashMap<Integer, Set<Integer>>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contains = locs.containsKey(val);
            if (!contains) {locs.put(val, new HashSet<Integer>());}
            locs.get(val).add(list.size());
            list.add(val);
            return !contains;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            boolean contains = locs.containsKey(val);
            if (!contains) {return false;}
            int loc = locs.get(val).iterator().next();
            locs.get(val).remove(loc);
            if (loc < list.size() - 1) {
                int lastOne = list.get(list.size() - 1);
                list.set(loc, lastOne);
                locs.get(lastOne).remove(list.size() - 1);
                locs.get(lastOne).add(loc);
            }
            list.remove(list.size() - 1);
            if (locs.get(val).isEmpty()) {locs.remove(val);}
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
