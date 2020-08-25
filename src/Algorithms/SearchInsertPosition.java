package Algorithms;

/*
https://leetcode.com/problems/search-insert-position/
Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

        You may assume no duplicates in the array.

        Input: [1,3,5,6], 5
        Output: 2


        Input: [1,3,5,6], 2
        Output: 1

        Input: [1,3,5,6], 7
        Output: 4

 */
public class SearchInsertPosition {
    public int findPosition(int []arr, int target){
        int pos = 0;

        for(int i=0; i<arr.length; i++) {
            if (target == arr[i]) {
                //System.out.println(target + " " + arr[i]);
                return i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (target < arr[i]) {
                return i;
            }
        }
        return arr.length;
    }
}

class SIPDriver{
    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        int[] arr = new int[]{1, 3, 5, 6};
        int pos = s.findPosition(arr, 6);
        System.out.println(pos);
    }
}