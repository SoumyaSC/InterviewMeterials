package Algorithms;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        //form a new array
        int []arr = new int[nums.length];

        //1, 2, 3, 4; k=3
        for(int i=0; i<nums.length; i++){
            arr[(i+k)%nums.length] = nums[i];
        }
    }
}

