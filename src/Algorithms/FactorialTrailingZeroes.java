package Algorithms;

import java.nio.charset.CharsetEncoder;

/*
https://leetcode.com/problems/factorial-trailing-zeroes/
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
 */
public class FactorialTrailingZeroes {
    private int calculateFactorial(int num){
        int fact = 0;
        if(num == 1){
            fact = 1;
        }else{
            fact = num * calculateFactorial(num-1);
        }
        return fact;
    }

    public int getTrailingZeros(int num){
        int fact = calculateFactorial(num);
        int countZero = 0;

        String charNumString = Integer.toString(fact);
        char[] charNum = charNumString.toCharArray();

        for(int i=0; i< charNum.length; i++){
            if(charNum[i] == '0'){
                countZero++;
            }
        }
        return countZero;
    }
}

class FTZDriver{
    public static void main(String[] args) {
        FactorialTrailingZeroes f = new FactorialTrailingZeroes();
        int fact = f.getTrailingZeros(5);
        System.out.println(fact);
    }
}
