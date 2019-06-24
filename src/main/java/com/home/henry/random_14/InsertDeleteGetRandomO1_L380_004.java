package com.home.henry.random_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 380. Insert Delete GetRandom O(1)
 */
public class InsertDeleteGetRandomO1_L380_004 {

    public static class RandomizedSet {
        ArrayList<Integer> nums;
        HashMap<Integer, Integer> locs;
        java.util.Random rand = new java.util.Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new ArrayList<Integer>();
            locs = new HashMap<Integer, Integer>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contain = locs.containsKey(val);
            if (contain) { return false; }
            locs.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) { return false; }
            int loc = locs.get(val);
            if (loc < nums.size() - 1) { // not the last one than swap the last one with this val
                int lastone = nums.get(nums.size() - 1);
                nums.set(loc, lastone);
                locs.put(lastone, loc);
            }
            locs.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

//    The follow-up: allowing duplications.
//    For example, after insert(1), insert(1), insert(2), getRandom() should have 2/3 chance return 1 and 1/3 chance return 2.
//    Then, remove(1), 1 and 2 should have an equal chance of being selected by getRandom().
//
//    The idea is to add a set to the hashMap to remember all the locations of a duplicated number.

    public static class RandomizedSetWithDuplicate {
        ArrayList<Integer> nums;
        HashMap<Integer, Set<Integer>> locs;
        java.util.Random rand = new java.util.Random();

        /** Initialize your data structure here. */
        public RandomizedSetWithDuplicate() {
            nums = new ArrayList<Integer>();
            locs = new HashMap<Integer, Set<Integer>>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) { locs.put(val, new HashSet<Integer>()); }
            locs.get(val).add(nums.size());
            nums.add(val);
            return !contain;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) { return false;}
            int loc = locs.get(val).iterator().next();
            locs.get(val).remove(loc);
            if (loc < nums.size() - 1) {
                int lastone = nums.get(nums.size() - 1);
                nums.set(loc, lastone);
                locs.get(lastone).remove(nums.size() - 1);
                locs.get(lastone).add(loc);
            }
            nums.remove(nums.size() - 1);
            if (locs.get(val).isEmpty()) { locs.remove(val); }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

}
