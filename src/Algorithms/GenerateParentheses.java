package Algorithms;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/generate-parentheses/
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParentheses {
    public List<String> generate (int num){
        List<String> arrList = new ArrayList<>();
        backtrack(num, "", 0, 0, arrList);
        return arrList;
    }

    private void backtrack(int num, String curent, int open, int close, List<String> list ){
        if(curent.length() == num*2){
            list.add(curent);
            return;
        }
        if(open<num){
            backtrack(num, curent+"(", open+1, close, list);
        }
        if(close<open){
            backtrack(num, curent+")", open, close+1, list);
        }
    }
}

class GenerateParDriver{
    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        List<String> arr = g.generate(3);

        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }
}