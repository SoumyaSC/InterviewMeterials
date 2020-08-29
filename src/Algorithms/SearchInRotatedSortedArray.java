package Algorithms;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
Given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You should search for target in nums and if you found return its index, otherwise return -1.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 */
public class SearchInRotatedSortedArray {
    //Idea is to ind the pivot
    //Construct 2 arrays
    //Do Binary Search (O(nlog(n) complexity)


    public int findPivot(int[] arr){
        int pivotIndex = 0;

        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                pivotIndex = i+1;
            }
        }
        return pivotIndex;
    }

    //Do Binary Search
    public int findElementIndexIfPresent(int[] arr, int target, int begIndex, int endIndex){
        int index = -1;

        if(endIndex>=begIndex) {
            //Step 1: Find middle
            int mid = (begIndex + endIndex) / 2;

            //Step 2: return index if target is there in mid
            if (target == arr[mid]) {
                return mid;
            } else {
                //Step 3: if target>mid value, search right by recurssion
                if (target >= arr[mid]) {
                    index = findElementIndexIfPresent(arr, target, mid + 1, endIndex);
                }
                //Step 4: search left
                else {
                    index = findElementIndexIfPresent(arr, target, begIndex, mid - 1);
                }
            }
        }

        return index;
    }
}

class SIRSADriver{
    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] arr = new int[]{4,5,6,7,0,1,2};

        int pivotIndex = s.findPivot(arr);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int[] arr1;
        int[] arr2;

        for(int i=pivotIndex; i<arr.length; i++){
            list1.add(arr[i]);
        }

        for(int i=0; i<pivotIndex; i++){
            list2.add(arr[i]);
        }

        //Debug: display the lists
/*        for(int i=0; i<list1.size(); i++){
            System.out.println(list1.get(i));
        }

        for(int i=0; i<list2.size(); i++){
            System.out.println(list2.get(i));
        }*/

        //Reconstruct 2 arrays from the 2 lists
        arr1 = new int[list1.size()];
        arr2 = new int[list2.size()];

        for(int i=0; i<list1.size(); i++){
            arr1[i] = list1.get(i);
        }

        for(int i=0; i<list2.size(); i++){
            arr2[i] = list2.get(i);
        }

        int index = s.findElementIndexIfPresent(arr2, 0, 0, arr2.length-1);
        if(index == -1) {
            index = s.findElementIndexIfPresent(arr1, 0, 0, arr1.length - 1);
        }

        System.out.println(index+arr2.length);
    }
}