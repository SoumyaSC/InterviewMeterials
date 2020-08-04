package Algorithms;

/*Given an array of characters, compress it in-place.

        The length after compression must always be smaller than or equal to the original array.

        Every element of the array should be a character (not int) of length 1.

        After you are done modifying the input array in-place, return the new length of the array.


        Follow up:
        Could you solve it using only O(1) extra space?


        Example 1:

        Input:
        ["a","a","b","b","c","c","c"]

        Output:
        Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

        Explanation:
        "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".*/

import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;

public class StringCompression {
    public int compress(char[] chars) {

        Map<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (hashMap.containsKey(chars[i])) {
                hashMap.put(chars[i], hashMap.get(chars[i]) + 1);
            } else {
                hashMap.put(chars[i], 1);
            }
        }

        //Debug print the map
        /*for(Map.Entry entry : hashMap.entrySet()){
            System.out.print(entry.getKey() + " " + entry.getValue());
        }*/

        int result = hashMap.size();
        result = result*2;

        return result;
    }
}

class DriverStringCompression{
    public static void main(String []args){
        char[] charArray = new char[]{'a', 'a', 'b', 'c', 'c', 'c'};
        StringCompression stringCompression = new StringCompression();
        int result = stringCompression.compress(charArray);
        System.out.println(result);
    }
}