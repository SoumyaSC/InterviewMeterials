public class HappyNumber {
    public boolean isHappy(int n) {
        int returnRes = n;
        int count = 0;

        if (returnRes == 1)
            return true;
        else {

            System.out.println(returnRes);
            while (returnRes != 1 && count<1000) {
                returnRes = helper(returnRes);
                count++;
            }
        }
        if(returnRes == 1) return true;
        else return false;




    }

    public int helper(int n) {

        String str = String.valueOf(n);
        char[] ch = str.toCharArray();

        int sum = 0;


        //while(sum!=1 && ch.length>1){

        for (int i = 0; i < ch.length; i++) {
            String s = String.valueOf(ch[i]);
            int newNum = Integer.parseInt(s);
            //System.out.println(newNum);

            sum = sum + newNum * newNum;
            //System.out.println(sum + "  Sum");
        }
        return sum;
    }
}

class Driver7{
    public static void main(String []args){
        HappyNumber hr = new HappyNumber();

        Boolean bool = hr.isHappy(123);
        System.out.println(bool);
    }
}