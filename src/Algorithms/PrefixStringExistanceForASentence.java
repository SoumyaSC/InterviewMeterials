package Algorithms;/*Given a sentence that consists of some words separated by a single space, and a searchWord.
        You have to check if searchWord is a prefix of any word in sentence.
        Return the index of the word in sentence where searchWord is a prefix of this word (1-indexed).
        If searchWord is a prefix of more than one word, return the index of the first word (minimum index).
        If there is no such word return -1.
        Threads.A prefix of a string S is any leading contiguous substring of S.*/

public class PrefixStringExistanceForASentence {
    public int checkExistance(String str, String searchWord){

        String []str1 = str.split(" ");

        int searchWordLen = searchWord.length();
        int result = 0;

        for(int i=0; i<str1.length; i++){
            //PLEASE notice the equals method for String comparison. Its NOT  ==
            if(str1[i].length()>=searchWordLen && str1[i].substring(0, searchWordLen).equals(searchWord)) {
                result = i+1;
                return result;
            }
            else {
                result = -1;
            }
        }
        return result;
    }
}

class Driver10{
    public static void main(String []args){
        PrefixStringExistanceForASentence prefixStringExistanceForASentence =
                new PrefixStringExistanceForASentence();
        int i = prefixStringExistanceForASentence.checkExistance("i love eating burger", "burg");
        System.out.println(i);
    }
}