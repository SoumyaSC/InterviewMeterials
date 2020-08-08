package Algorithms;

/*
A. Helpful Maths
        time limit per test2 seconds
        memory limit per test256 megabytes
        inputstandard input
        outputstandard output
        Xenia the beginner mathematician is a third year student at elementary school. She is now learning the addition operation.

        The teacher has written down the sum of multiple numbers. Pupils should calculate the sum. To make the calculation easier, the sum only contains numbers 1, 2 and 3. Still, that isn't enough for Xenia. She is only beginning to count, so she can calculate a sum only if the summands follow in non-decreasing order. For example, she can't calculate sum 1+3+2+1 but she can calculate sums 1+1+2 and 3+3.

        You've got the sum that was written on the board. Rearrange the summans and print the sum in such a way that Xenia can calculate the sum.

        Input
        The first line contains a non-empty string s — the sum Xenia needs to count. String s contains no spaces. It only contains digits and characters "+". Besides, string s is a correct sum of numbers 1, 2 and 3. String s is at most 100 characters long.

        Output
        Print the new sum that Xenia can count.

        Examples
        inputCopy
        3+2+1
        outputCopy
        1+2+3
*/

public class HelpfulMaths {

    public String helpfulMaths(String str){
        char[] strChar = str.toCharArray();

        for(int j=0; j<strChar.length; j++){
            for (int i = 0; i < strChar.length - 1; i = i + 2) {
                if (strChar[i] > strChar[i + 2]) {
                    char tmp = strChar[i];
                    strChar[i] = strChar[i + 2];
                    strChar[i + 2] = tmp;
                }
            }
        }
        str = String.valueOf(strChar);
        return str;
    }
}

class HelpfulMathsDriver{
    public static void main(String[] args) {
        HelpfulMaths h = new HelpfulMaths();
        String a = h.helpfulMaths("1+1+3+1+3");
        System.out.println(a);
    }
}