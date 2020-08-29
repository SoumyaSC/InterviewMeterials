package Algorithms;

/*
https://leetcode.com/problems/divide-two-integers/
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part.
For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
 */
public class DivideTwoIntegers {
    public int division(int a, int b){
        int count = 0;

        //Logic: Keep on subtracting b from a and keep a count of no of subtractions
        //until a>=b. When a is not >= b, then return the count.
        while(a>=b){
            a = Math.abs(a);
            b = Math.abs(b);

            a = Math.abs(a-b);
            count++;
        }
        return count;
    }
}
class DTIDriver{
    public static void main(String[] args) {
        DivideTwoIntegers d = new DivideTwoIntegers();
        int res = d.division(48,-8);
        System.out.println(res);
    }
}
