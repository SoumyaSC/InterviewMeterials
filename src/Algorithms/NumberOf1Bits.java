package Algorithms;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        String str = String.valueOf(n);
        char [] ch = str.toCharArray();
        System.out.println(ch);
        int count = 0;

        for(int i=0; i<ch.length; i++){
            if(ch[i] == '1'){
                count ++;
            }
        }
        System.out.println(count);
        return count;
    }
}

class Driver2 {
    public static void main(String[] args) {
        NumberOf1Bits rb = new NumberOf1Bits();
        rb.hammingWeight(00000011111);
    }
}

