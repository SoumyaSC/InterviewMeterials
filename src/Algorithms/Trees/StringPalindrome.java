package Algorithms.Trees;

/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

        Note: For the purpose of this problem, we define empty string as valid palindrome.

        Example 1:

        Input: "A man, a plan, a canal: Panama"
        Output: true*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringPalindrome {
    public boolean isPalindrome(String s) {

        char[] sChar = s.toCharArray();

        List<Character> chArrayAlphabetic = new ArrayList<>();


        //we now have an array of chars without special chars; only alphabets
        for(int i=0; i<sChar.length; i++){
            if(Character.isAlphabetic(sChar[i])){
                //System.out.println("SC1");
                chArrayAlphabetic.add(sChar[i]);
            }
        }

        //System.out.println(chArrayAlphabetic);

        boolean result = false;
        for(int i=0; i<chArrayAlphabetic.size(); i++){
            if(chArrayAlphabetic.get(i).equals(chArrayAlphabetic.get(chArrayAlphabetic.size()-i -1))){
                //System.out.println("SC");
                result = true;
            }
            else{
                result = false;
            }
        }
        return result;
    }
}

class DriverStrPalindrome{
    public static void main(String []args){
        StringPalindrome s = new StringPalindrome();
        boolean res = s.isPalindrome("a man, a plan, a canal: Panama");
        System.out.println(res);
    }
}
