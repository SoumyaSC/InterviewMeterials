package Algorithms;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/3sum/
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {

    public List<Integer> findThreeSumZero(int[] arr){
        List<Integer> triadArr = new ArrayList<>();

        //with 3 loops
        //not good
        //O(n3) complexity
        /*for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int z=j+1; z<arr.length; z++){
                    if(arr[i] + arr[j] + arr[z] == 0){
                        triadArr.add(arr[i]);
                        triadArr.add(arr[j]);
                        triadArr.add(arr[z]);
                    }
                }
            }
        }*/

        //O(n2) complexity
        for(int i=0; i<arr.length; i++){
            int j = i+1;

            for(int z = j+1; z<arr.length; z++){
                //Debug
                //System.out.println(i + " " + j + " " + z);
                if(arr[i] + arr[j] + arr[z] == 0){
                    triadArr.add(arr[i]);
                    triadArr.add(arr[j]);
                    triadArr.add(arr[z]);
                    j++;
                }

            }
        }



        return triadArr;
    }
}

class ThreeSumDriver{
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};

        List<Integer> triadList = threeSum.findThreeSumZero(arr);

        for(int i=0; i<triadList.size(); i++){
            System.out.println(triadList.get(i));
        }
    }
}
