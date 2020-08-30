package Algorithms;

/*
https://leetcode.com/problems/merge-intervals/
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public List<Integer> mergeIntervals(int[] arr){
        List<Integer> mergedList = new ArrayList<>();

        //[[1,3],[2,6],[8,10],[15,18]]
        for(int i=0; i<arr.length; i=i+4){
            if(arr[i+2] < arr[i+1]){
                mergedList.add(arr[i]);
                mergedList.add(arr[i+3]);
            }
            else{
                mergedList.add(arr[i]);
                mergedList.add(arr[i+1]);
                mergedList.add(arr[i+2]);
                mergedList.add(arr[i+3]);

            }
        }
        return mergedList;
    }
}

class MergedIntervalsDriver{
    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[] arr = new int[]{1,3,2,6,8,10,15,18};
        List<Integer> list = m.mergeIntervals(arr);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}