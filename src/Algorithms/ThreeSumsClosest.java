package Algorithms;


/*
https://leetcode.com/problems/3sum-closest/
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumsClosest {
    public int threeSumCLosest(int[] arr, int target){
        int sum = 0;
        int internalSum = 0;
        int toReturn = 0;
        int diff1 = 0;
        int diff2 = 0;

        for(int i=0; i<arr.length; i++){
            int j = i+1;
            for(int k=j+1; k<arr.length; k++){
                //Debug
                //System.out.println(i + " " + j + " " + k);
                internalSum = arr[i] + arr[j] + arr[k];

                if(internalSum == target){
                    return arr[i] + arr[j] + arr[k];
                }else{
                    diff1 = Math.abs(internalSum - target);
                    if(diff1 > diff2){
                        int d1 = Math.abs(diff1-target);
                        int d2 = Math.abs(diff2 - target);
                        if(d1<d2){
                            toReturn =  arr[i] + arr[j] + arr[k];
                        }

                    }
                }
                j++;
            }
        }
        return toReturn;
    }
}

class TSCDriver{
    public static void main(String[] args) {
        ThreeSumsClosest t = new ThreeSumsClosest();
        int[] arr = new int[]{-1,2,1,-4};
        int res = t.threeSumCLosest(arr, 1);
        System.out.println(res);
    }
}