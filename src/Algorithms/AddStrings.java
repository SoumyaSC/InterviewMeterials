package Algorithms;

//Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = Integer.parseInt(num1);
        int j = Integer.parseInt(num2);

        int result = i + j;

        String changeToNum = String.valueOf(result);
        return changeToNum;
    }
}
