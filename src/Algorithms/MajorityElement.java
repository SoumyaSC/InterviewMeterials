package Algorithms;

/*
https://leetcode.com/problems/majority-element/
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

        You may assume that the array is non-empty and the majority element always exist in the array.

        Example 1:

        Input: [3,2,3]
        Output: 3
        Example 2:

        Input: [2,2,1,1,1,2,2]
        Output: 2
*/

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public void findMajorityElement(int[] arr){
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            //containsKey(Object key) is used to see if a particular key is mapped to a hashmap or not
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            }
            else{
                hashMap.put(arr[i], 1);
            }
        }

        //Debug, print the map
        /*for(Map.Entry entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/

        //Logic to find the maximum value wrt to a key in a hashmap
        Map.Entry<Integer, Integer> maxEntry = null;
        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
                maxEntry = entry;
            }
        }
        if(maxEntry.getValue() > arr.length/2) {
            System.out.println(maxEntry.getKey());
        }
    }
}

class MEDriver{
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] arr = new int[]{2,2,1,1,1,2,2};
        majorityElement.findMajorityElement(arr);
    }
}