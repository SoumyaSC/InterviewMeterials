package Algorithms;

public class HouseRobber {
    public int rob(int[] num) {
        if(num==null || num.length == 0)
            return 0;

        int even = 0;
        int odd = 0;

        //2 1 1 2
        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                even += num[i];
                even = even > odd ? even : odd;
                //System.out.println(even + "SC");
            } else {
                System.out.println(num[i] + " SC");

                odd += num[i];
                //odd = even > odd ? even : odd;

                if(even > odd){
                    odd = even;
                }



            }
        }

        return even > odd ? even : odd;
    }
}
class Driver6{
    public static void main(String []args){
        HouseRobber hr = new HouseRobber();
        int []arr = new int[]{2,1,1,2};
        int res = hr.rob(arr);
        System.out.println(res);
    }
}
