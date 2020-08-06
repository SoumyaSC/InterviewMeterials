package Algorithms;
/*
A. Next Round
        time limit per test3 seconds
        memory limit per test256 megabytes
        inputstandard input
        outputstandard output
        "Contestant who earns a score equal to or greater than the k-th place finisher's score will advance to the next round, as long as the contestant earns a positive score..." — an excerpt from contest rules.

        A total of n participants took part in the contest ( n ≥ k), and you already know their scores. Calculate how many participants will advance to the next round.

        Input
        The first line of the input contains two integers n and k (1 ≤ k ≤ n ≤ 50) separated by a single space.

        The second line contains n space-separated integers a 1, a 2, ..., a n (0 ≤ a i ≤ 100), where a i is the score earned by the participant who got the i-th place. The given sequence is non-increasing (that is, for all i from 1 to n - 1 the following condition is fulfilled: a i ≥ a i + 1).

        Output
        Output the number of participants who advance to the next round.

        Examples
        inputCopy
        8 5
        10 9 8 7 7 7 5 5
        outputCopy
        6
*/


public class NextRound {
    int result = 0;
    public int findCount(int totalCandidates, int passMarks, int[] marks){
        for(int i=0; i<marks.length; i++){
            if(marks[i] > passMarks){
                result++;
            }
        }
        return result;
    }
}

class NextRoundDriver{
    public static void main(String[] args) {
        int[] marks = new int[]{10, 9, 8, 7, 7, 7, 5, 5};

        NextRound nextRound = new NextRound();
        int result = nextRound.findCount(8, 5, marks);
        System.out.println(result);
    }
}