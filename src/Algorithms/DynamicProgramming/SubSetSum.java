package Algorithms.DynamicProgramming;

//using Recurssion, not DP
//Can be memoized very simply

/*Given a set of non-negative integers, and a value sum, determine if
        there is a subset of the given set with sum equal to given sum.
        Example:

        Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
        Output: True
        There is a subset (4, 5) with sum 9.*/

public class SubSetSum {
    Boolean result = false;

    public Boolean subsetSum(int[] arr, int target, int n){
        if(n==0 && target==0){
            return true;
        }
        if(n==0 && target!=0){
            return false;
        }
        else{
            if(arr[n-1]<=target){
                result = subsetSum(arr, target-arr[n-1], n-1) ||
                        subsetSum(arr, target, n-1);
            }
            else{
                result = subsetSum(arr, target, n-1);
            }
        }
        return result;
    }
}

class SubSetSumDriver{
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 34, 4, 12, 5, 2 };
        SubSetSum s = new SubSetSum();
        Boolean res = s.subsetSum(arr, 15, 6);
        System.out.println(res);
    }
}