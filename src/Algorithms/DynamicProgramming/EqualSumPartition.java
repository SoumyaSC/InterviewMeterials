package Algorithms.DynamicProgramming;

public class EqualSumPartition {

    public int findSumOfArr(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum+arr[i];
        }
        return sum;
    }

    public Boolean canBeDivided(int[]arr, int sum, int n){
        Boolean res = false;

        if(sum%2 != 0){
            return false;
        }else{
            //sum is positive
            //lets try to find half of sum in the array
            //if subset of array has half of the sum, the other sub set will also contain the
            //other half of the sum
            //so this problem reduces to SubSetSum problem with sum = sum/2
            int halfSum =  sum/2;
            if(n==0 && halfSum == 0){
                return true;
            }
            if(n == 0 && halfSum!=0){
                return false;
            }
            else{
                if(arr[n-1]<=halfSum){
                    res = canBeDivided(arr, halfSum-arr[n-1], n-1) ||
                            canBeDivided(arr, halfSum, n-1);
                }
                else{
                    res = canBeDivided(arr, halfSum, n-1);
                }
            }
            return res;
        }
    }
}

class EqualPartitionDriver{
    public static void main(String[] args) {
        EqualSumPartition d = new EqualSumPartition();
        int[] arr = {1, 10, 5, 4};
        int sum = d.findSumOfArr(arr);
        System.out.println(sum + "sum");
        Boolean res = d.canBeDivided(arr, sum, 4);
        System.out.println(res);
    }
}