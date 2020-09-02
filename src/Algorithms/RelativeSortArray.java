package Algorithms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
https://leetcode.com/problems/relative-sort-array/
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.



Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
 */

//very complicated logic
//output is not correct
//very close though, will correct if i get time
public class RelativeSortArray {
    public int[] sort(int[] arr1, int[] arr2){
        int[] arrFinal = new int[arr1.length];
        Map<Integer, Integer> hashMap1 = new LinkedHashMap<>();
        Map<Integer, Integer> hashMap2 = new LinkedHashMap<>();

        for(int i=0; i<arr2.length; i++){
            hashMap1.put(i+1, arr2[i]);
        }

        //Debug
        /*for(Map.Entry mapEntry : hashMap1.entrySet()){
            System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
        }*/

        for(int i=0; i<arr1.length; i++){
            if(hashMap2.containsKey(arr1[i])){
                hashMap2.put(arr1[i], hashMap2.get(arr1[i]) + 1);
            }else{
                hashMap2.put(arr1[i], 1);
            }
        }

        //Debug
        /*for(Map.Entry mapEntry : hashMap2.entrySet()){
            System.out.println(mapEntry.getKey() + " sc " + mapEntry.getValue());
        }*/

        int i = 0, count = 0, k=1;


        for (Map.Entry mapEntry : hashMap2.entrySet()) {
            //int timesToFill = (int) mapEntry.getValue();
            int timesToFill = 0;
            //System.out.println(timesToFill);
            int toBeFilled = 0;
            if (hashMap1.get(k) != null) {
                toBeFilled = hashMap1.get(k);
                k++;
            } else {
                toBeFilled = (int) mapEntry.getKey();
            }
            if (mapEntry.getKey().equals(toBeFilled)) {
                timesToFill = (int) mapEntry.getValue();
                System.out.println(toBeFilled + " " + timesToFill);
            } else {
                timesToFill = (int) mapEntry.getValue();
            }
            //System.out.println("tofill " + toBeFilled + " " + timesToFill + " time");
            for (int j = 0; j < timesToFill; j++) {
                arr1[j + i] = toBeFilled;
                count++;
            }
            i = count;
        }


        return arr1;
    }
}

class RelativeSortArrayDriver{
    public static void main(String[] args) {
        RelativeSortArray r = new RelativeSortArray();
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};

        arr1 = r.sort(arr1, arr2);

        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
    }
}