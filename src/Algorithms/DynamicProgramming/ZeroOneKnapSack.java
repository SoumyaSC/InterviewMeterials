package Algorithms.DynamicProgramming;

/* Zero One KnapSack with Top Down approach
1. Initialize array of arr[no of elements+1][knapsack weight+1]
2. Fill arr[i][j] where i==j==0;
3. if(weightOfItem[n-1]<knapSackWeight)
        3.1 Either add or not addthat item and finish operation for that item
            //In Recurssion
            Max of (value[n-1] + knapsackRecurssion(weightArr, valueArr, knapSackWeight-weight[n-1], itemNumbers-1),
            knapsackRecurssion(weightArr, valueArr, knapSackWeight, itemNumbers-1))
            //In TopDown
            dp[j][j] = Max of (value[n-1] + arr[no of elements-1][knapsack weight-(weight[n-1])],
            arr[no of elements-1][knapsack weight]
        3.2 Do not add that item and finish operation for that item
            arr[no of elements-1][knapsack weight]
*/


public class ZeroOneKnapSack {

    public int knapsack(int[] weight, int[] value, int knapSackWeight, int itemNumbers) {

        int[][] dp = new int[itemNumbers + 1][knapSackWeight + 1];

        //fill i=0 and j=0 with 0s
        for (int i = 0; i < knapSackWeight + 1; i++) {
            for (int j = 0; j < itemNumbers + 1; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                }
            }
        }

        //actual solution after initialization in upper section
        for (int i = 1; i < itemNumbers + 1; i++) {
            for (int j = 1; j < knapSackWeight + 1; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - (weight[i - 1])],
                            dp[i - 1][j]);
                }
                //weight of item[i] > W; so discurd weight i
                else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[itemNumbers][knapSackWeight];
    }
}

class ZeroOneKnapSackDriver{
    public static void main(String []args){
        ZeroOneKnapSack zeroOneKnapSack = new ZeroOneKnapSack();
        int[] weight = new int[]{1, 2, 4, 7};
        int[] value = new int[]{3, 2, 1, 7};
        int knapSackWeight = 7;
        int itemNumbers = 4;

        int maxValue = zeroOneKnapSack.knapsack(weight, value, knapSackWeight, itemNumbers);
        System.out.println("Max value is: " + maxValue);
    }
}


