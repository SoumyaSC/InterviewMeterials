package Algorithms;

/*
https://leetcode.com/problems/container-with-most-water/
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height, int n){
        int max = 0;
        int newMax = 0;
        if(n==0){
            return 0;
        }else {
            for (int i = 0; i < height.length; i++) {
                for(int j=height.length; j>0; j--){
                    if(height[j-1] >= height[i]){
                        max = Math.abs(height[i]*(j-1-i));
                        if(max>newMax){
                            newMax = max;
                        }
                    }
                }

            }

        }

        return newMax;
    }
}

class ContainerMaxDriver{
    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = c.maxArea(height, height.length);
        System.out.println(maxArea);
    }
}