package Algorithms.DynamicProgramming;

public class ZeroOneKnapSackRecurssion {
    int max = 0;

    public int knapsack(int[] weight, int[] value, int W, int n){
        if(n==0 | W ==0){
            return 0;
        }else{
            if(value[n-1]<=W){
                max = Math.max(value[n-1] + (knapsack(weight, value, W - weight[n - 1], n - 1)),
                        knapsack(weight, value, W, n-1));
            }
            else{
                max = knapsack(weight, value, W, n-1);
            }
        }
        return max;
    }
}

class ZeroOneKnapSackRecDriver{
    public static void main(String []args){
        ZeroOneKnapSackRecurssion z = new ZeroOneKnapSackRecurssion();
        int[] weight = new int[]{1, 2, 4, 7};
        int[] value = new int[]{3, 2, 1, 7};
        int knapSackWeight = 7;
        int itemNumbers = 4;
        int max = z.knapsack(weight, value, knapSackWeight, itemNumbers);
        System.out.println(max);

    }
}
