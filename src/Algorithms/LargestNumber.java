package Algorithms;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/problems/largest-number/
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"

 */
public class LargestNumber {
    private class CompareStrings implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order1.compareTo(order2);
        }
    }
    public String largestNumber(int[] arr){
        String[] strArr = new String[arr.length];

        for(int i=0; i<strArr.length; i++){
            strArr[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(strArr, new CompareStrings());

        String largestNo = new String();
        for(int i=strArr.length-1; i>=0; i--){
            largestNo = largestNo +  strArr[i];
        }

        return largestNo;
    }
}

class LargestNumberDriver{
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] arr = new int[]{5, 10, 4, 2, 6, 7};

        String largeNumber = largestNumber.largestNumber(arr);
        System.out.println(largeNumber);
    }
}