package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/repeated-dna-sequences/
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class RepeatedDNASubsequence {
    public int findCount(String dNA){

        List<String> seen = new ArrayList<>();
        List<String> sequence = new ArrayList<>();

        for(int i=0; i<dNA.length()-10; i++){
            String sub = dNA.substring(i, i+10);
            sequence.add(sub);
        }

        for(int i=0; i<sequence.size(); i++){
            for(int j=i+1; j<sequence.size(); j++){
                if(sequence.get(i).equals(sequence.get(j))){
                    seen.add(sequence.get(i));
                }
            }
        }
        return seen.size();
    }
}

class DNADriver{
    public static void main(String[] args) {
        RepeatedDNASubsequence r = new RepeatedDNASubsequence();
        int countSeenSubstring = r.findCount("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(countSeenSubstring);
    }
}