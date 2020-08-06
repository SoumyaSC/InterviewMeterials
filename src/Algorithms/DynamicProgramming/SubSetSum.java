package Algorithms.DynamicProgramming;

//using Recurssion, not DP
//Can be memoized very simply
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