package Algorithms;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/single-element-in-a-sorted-array/
You are given a sorted array consisting of only integers where every element appears exactly twice,
except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.



Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 */
public class SingleElementInSortedArray {
    public int findSingleElement(int[] arr){
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i], hashMap.get(arr[i])+1);
            }else{
                hashMap.put(arr[i], 1);
            }
        }

        for(Map.Entry mapEntry : hashMap.entrySet()){
            if(mapEntry.getValue().equals(1)){
                System.out.println(mapEntry.getKey());

            }

        }
        return 0;
    }
}

class SESADriver{
    public static void main(String[] args) {
        SingleElementInSortedArray s = new SingleElementInSortedArray();
        int[] arr = new int[]{1,1,2,3,3,4,4,8,8};
        s.findSingleElement(arr);
    }
}