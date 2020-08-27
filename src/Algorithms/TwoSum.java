package Algorithms;

/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

 */

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    List<Integer> indexArr = new ArrayList<>();

    public List<Integer> findIndexSum(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; i++){
                if(i!=j){
                    if(arr[i] + arr[j] == target){
                        indexArr.add(i+1);
                        indexArr.add(j+1);
                        return indexArr;
                    }
                }
            }
        }
        return indexArr;
    }
}

class TwoSumDriver{
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = new int[]{2,7,11,15};
        List<Integer> indexList = twoSum.findIndexSum(arr, 13);

        for(int i=0; i<indexList.size(); i++){
            System.out.println(indexList.get(i));
        }
    }
}