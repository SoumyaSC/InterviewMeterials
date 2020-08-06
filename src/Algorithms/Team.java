package Algorithms;

/*A. Team
        time limit per test2 seconds
        memory limit per test256 megabytes
        inputstandard input
        outputstandard output
        One day three best friends Petya, Vasya and Tonya decided to form a team and take part in programming contests. Participants are usually offered several problems during programming contests. Long before the start the friends decided that they will implement a problem if at least two of them are sure about the solution. Otherwise, the friends won't write the problem's solution.

        This contest offers n problems to the participants. For each problem we know, which friend is sure about the solution. Help the friends find the number of problems for which they will write a solution.

        Input
        The first input line contains a single integer n (1 ≤ n ≤ 1000) — the number of problems in the contest. Then n lines contain three integers each, each integer is either 0 or 1. If the first number in the line equals 1, then Petya is sure about the problem's solution, otherwise he isn't sure. The second number shows Vasya's view on the solution, the third number shows Tonya's view. The numbers on the lines are separated by spaces.

        Output
        Print a single integer — the number of problems the friends will implement on the contest.

        Examples
        inputCopy
        3
        1 1 0
        1 1 1
        1 0 0
        outputCopy
        2
*/

public class Team {
    public int countSolvedProblems(int noOfProblems, int[] arr) {
        int solvedProblems = 0;
        int count = 0;

        for(int i=0; i<arr.length; i=i+3) {
            for (int j = i; j < i+3; j++) {
                if (arr[j] == 1) {
                    count++;
                }
            }
        }

        if(count>=2){
            solvedProblems = count/2;
        }
        return solvedProblems;
    }
}

class SolvedDriver{
    public static void main(String []args){
        Team team = new Team();
        int[] arr = new int[]{1, 0, 1, 0, 1, 1, 1, 1, 1};

        int solved = team.countSolvedProblems(3, arr);
        System.out.println(solved);
    }
}

















