package Algorithms;

/*
Given an integer array nums, find the maximum sum of the array

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 12

 */

public class MaximunSumOfAnArray {
    int sum = 0;
    int count = 0;

    public int maxSum(int[] arr, int n){
        if(arr.length == 0){
            System.out.println("SC");
            return 0;
        }
        else {
            if (n>0 && count<arr.length) {
                count++;
                sum = Math.max(arr[n-1] + maxSum(arr, n - 1),
                        maxSum(arr, n - 1));
            }
        }
        return sum;
    }
}

class MSADriver{
    public static void main(String[] args) {
        MaximunSumOfAnArray m = new MaximunSumOfAnArray();
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int max = m.maxSum(arr, arr.length);
        System.out.println(max);
    }
}
