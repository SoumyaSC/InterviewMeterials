package Algorithms;

public class BitPlusPlus {

    public int findBitPlusPlusValue(int currentBitValue, String str){
        int bitResult = 0;
        bitResult = findValue(currentBitValue, str);

        return bitResult;
    }

    private int findValue(int currentBitVal, String str){
        int res = 0;
        char[] ch = str.toCharArray();

        if(str.equals("X++")){
            res = res + currentBitVal + 1;
        }
        if(str.equals("--X")){
            res = res + currentBitVal-1;
        }
        return res;
    }
}

class BitPlusPlusDriver{
    public static void main(String[] args) {
        BitPlusPlus b = new BitPlusPlus();

        int result = 0;
        result = b.findBitPlusPlusValue(result, "X++");

        result = b.findBitPlusPlusValue(result, "--X");

        result = b.findBitPlusPlusValue(result, "X++");
        System.out.println(result);
    }
}