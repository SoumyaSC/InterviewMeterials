package Algorithms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

//Note: This program is not 100% correct. But it gives the idea.
 */
public class LetterCombinationOfPhone {

    public List<String> findAllLetterCombinationWrtDigits(String digits){
        List<String> allComb = new ArrayList<>();

        Map<String, String> phoneMap = new HashMap<>();
        phoneMap.put("2", "abc");
        phoneMap.put("3", "def");
        phoneMap.put("4", "ghi");
        phoneMap.put("5", "jkl");
        phoneMap.put("6", "mno");
        phoneMap.put("7", "pqrs");
        phoneMap.put("8", "tuv");
        phoneMap.put("9", "wxyz");

        if(digits.length() == 0){
            allComb.add("");
        }else{
            String extractedDigits = digits.substring(0, 1);
            //if digits is 29, extractedDigitas will be 2 for the first Interation
            //System.out.println(extractedDigits);

            String letter = phoneMap.get(extractedDigits);
            //Prints value against key, which is nothing but extractedDigitas
            //System.out.println(letter);

            //iterate over one value of<K,V> and print all its substring of single length
            //then move to the next one
            for(int i=0; i<letter.length(); i++){
                String str = phoneMap.get(extractedDigits).substring(i, i+1);
                System.out.println(str);
                findAllLetterCombinationWrtDigits(digits.substring(1));
            }
        }
        return null;
    }
}

class LCPDriver{
    public static void main(String[] args) {
        LetterCombinationOfPhone l = new LetterCombinationOfPhone();
        l.findAllLetterCombinationWrtDigits("23");
    }
}