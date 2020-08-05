package Algorithms;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //convert int to string
        String str = String.valueOf(n);
        System.out.println(str);

        //convert string to char
        char []ch = str.toCharArray();
        System.out.println(ch);

        //take a temp char
        char []ch2 = new char[str.length()];

        for(int i=ch.length-1; i>=0; i--){
            ch2[ch.length-i-1] = ch[i];
            System.out.println(ch2[ch.length-i-1]);
        }

        //convert char array to string
        str = String.valueOf(ch2);
        System.out.println(str);
        //convert string to integer
        n = Integer.parseInt(str);
        return n;


    }
}
class Driver {
    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        rb.reverseBits(1100);
    }
}

