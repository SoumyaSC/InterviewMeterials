package Algorithms;

/*Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

        Find all the elements of [1, n] inclusive that do not appear in this array.

        Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

        Example:

        Input:
        [4,3,2,7,8,2,3,1]

        Output:
        [5,6]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> arrayList = new ArrayList<>();

        for(int i=0; i<nums.length-1; i++){
                if((nums[i+1]-nums[i]) != 1){
                    System.out.println(nums[i+1] + " " + nums[i]);
                    int diff = nums[i+1] - nums[i];

                    while (diff>1){
                        arrayList.add(nums[i]+1);
                        nums[i] = nums[i] + 1;
                        diff--;
                    }
                }

        }

        return arrayList;
    }
}

class DriverMissingElements{
    public static void main(String []args) {
        int[] arr = new int[]{1, 2, 4, 7, 9};
        FindAllNumbersDisappeared findAllNumbersDisappeared =
                new FindAllNumbersDisappeared();
        List<Integer> arrList = findAllNumbersDisappeared.findDisappearedNumbers(arr);
        System.out.println(arrList);
    }
}