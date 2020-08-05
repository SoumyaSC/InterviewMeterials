package Algorithms.DynamicProgramming;

public class ZeroOneKnapSackWithMemoization {

    int max = 0;

    int[][] dp = new int[5][8];

    public void fillMatrix(){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
    }


    public int knapSackZeroOne(int[] weight, int[] value, int knapSackWeight, int noOfElements){
        if(noOfElements == 0 | knapSackWeight == 0){
            return 0;
        }
        if(dp[noOfElements][knapSackWeight] != -1){
                return dp[noOfElements][knapSackWeight];
        }
        else {
            if (weight[noOfElements - 1] <= knapSackWeight) {
                dp[noOfElements][knapSackWeight] = Math.max(value[noOfElements - 1] + knapSackZeroOne(weight, value, (knapSackWeight - weight[noOfElements - 1]), (noOfElements - 1)),
                        knapSackZeroOne(weight, value, knapSackWeight, (noOfElements - 1)));
            } else {
                dp[noOfElements][knapSackWeight] = knapSackZeroOne(weight, value, knapSackWeight, (noOfElements - 1));
            }
        }
        return dp[noOfElements][knapSackWeight];
    }
}

class ZeroOneKnapSackRecurssionDriver{
    public static void main(String []args){
        ZeroOneKnapSackWithMemoization zeroOneKnapSackWithMemoization = new ZeroOneKnapSackWithMemoization();
        int[] weight = new int[]{1, 2, 4, 7};
        int[] value = new int[]{3, 2, 1, 7};
        int knapSackWeight = 7;
        int itemNumbers = 4;

        zeroOneKnapSackWithMemoization.fillMatrix();
        int maxValue = zeroOneKnapSackWithMemoization.knapSackZeroOne(weight, value, knapSackWeight, itemNumbers);
        System.out.println("Max value is: " + maxValue);
    }
}