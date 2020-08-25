package Algorithms;

/*
https://leetcode.com/problems/maximum-subarray/
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

 */

public class MaximumSubarray {
    public int maxSubarraySum(int[] arr){
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for(int i=0; i<arr.length; i++){
            maxEndingHere = maxEndingHere + arr[i];
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }
            if(maxEndingHere<0){
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}

class MSDriver{
    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int max = m.maxSubarraySum(arr);
        System.out.println(max);
    }
}
