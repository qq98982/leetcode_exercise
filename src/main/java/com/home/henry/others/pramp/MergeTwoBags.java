package com.home.henry.others.pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MergeTwoBags {

  static int[] getIndicesOfItemWeights(int[] arr, int limit) {
    if (arr == null || arr.length < 2) {return new int[]{};}
    
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < arr.length; i++) {
      int num = arr[i];
      int to = limit - num;
      if (map.get(to) != null) {
        return new int[]{i,map.get(to)};
      }
      map.put(arr[i], i);
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    int[] arr = {4,4};
    System.out.println(Arrays.toString(getIndicesOfItemWeights(arr, 8)));
  }

}