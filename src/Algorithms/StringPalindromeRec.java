package Algorithms;

//using recursssion
public class StringPalindromeRec {
    public Boolean findPalindrome(String str){
        if(str.length() == 0 || str.length() == 1) {
            return true;
        }
        else{
            if(str.charAt(0) == str.charAt(str.length()-1)){
                return findPalindrome(str.substring(1, str.length()-1));
            }
        }
        return false;
    }
}

class DriverSP{
    public static void main(String[] args) {
        StringPalindromeRec stringPalindrome = new StringPalindromeRec();
        Boolean res = stringPalindrome.findPalindrome("malyalam");
        System.out.println(res);
    }

}
