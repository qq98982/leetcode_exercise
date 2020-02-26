package com.home.henry.others.pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {

  static int[] getIndicesOfItemWeights(int[] arr, int limit) {
    int[] res = new int[2];
    if (arr == null || arr.length < 2) {return res;}
    
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < arr.length; i++) {
      map.putIfAbsent(arr[i], i);
    }
    for (int i = arr.length - 1; i >= 0; i--) {
      int num = arr[i];
      int to = limit - num;
      if (map.get(to) != null) {
        return new int[]{i,map.get(to)};
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = {4,4,1};
    System.out.println(Arrays.toString(getIndicesOfItemWeights(arr, 5)));
  }

}