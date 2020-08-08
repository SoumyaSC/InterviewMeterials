package Algorithms;

/*
A. Petya and Strings
        time limit per test2 seconds
        memory limit per test256 megabytes
        inputstandard input
        outputstandard output
        Little Petya loves presents. His mum bought him two strings of the same size for his birthday. The strings consist of uppercase and lowercase Latin letters. Now Petya wants to compare those two strings lexicographically. The letters' case does not matter, that is an uppercase letter is considered equivalent to the corresponding lowercase letter. Help Petya perform the comparison.

        Input
        Each of the first two lines contains a bought string. The strings' lengths range from 1 to 100 inclusive. It is guaranteed that the strings are of the same length and also consist of uppercase and lowercase Latin letters.

        Output
        If the first string is less than the second one, print "-1". If the second string is less than the first one, print "1". If the strings are equal, print "0". Note that the letters' case is not taken into consideration when the strings are compared.

        Examples
        inputCopy
        aaaa
        aaaA
        outputCopy
        0
*/

public class PetyaAndStrings {

    int result;
    public int compareStrings(String a, String b){
         a = a.toUpperCase();
         b = b.toUpperCase();

        System.out.println(a + " " + b);

        char[] aStr = a.toCharArray();
        char[] bStr = b.toCharArray();

        for(int i=0; i<a.length(); i++){
            if(a.equalsIgnoreCase(b)){
                return 0;
            }
            if(aStr[i] > bStr[i]){
                return 1;
            }
            if(aStr[i] < bStr[i]){
                return -1;
            }
        }
        return result;
    }
}

class PetyaAndStringsDriver{
    public static void main(String[] args) {
        PetyaAndStrings p = new PetyaAndStrings();
        int result = p.compareStrings("abcdefg", "AbCdEfF");
        System.out.println(result);

    }
}


















