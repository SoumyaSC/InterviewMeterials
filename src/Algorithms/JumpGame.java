package Algorithms;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGame {
    public Boolean ableToReachLastIndex(int[] arr, int position){
        if(arr.length==0){
            return false;
        }
        if(position == arr.length-1) {
            return true;
        }
        int farthestJump = Math.min(position + arr[position], arr.length - 1);
        for (int i = position + 1; i <= farthestJump; i++) {
            if (ableToReachLastIndex(arr, i)) {
                return true;
            }
        }
        return false;
    }
}

class JumpGameDriver{
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] arr = new int[]{2,3,1,1,4};
        Boolean res = jumpGame.ableToReachLastIndex(arr, 0);
        System.out.println(res);
    }


}