package Algorithms;

/*
https://leetcode.com/problems/minimum-time-difference/
Given a list of 24-hour clock time points in "Hour:Minutes" format,
find the minimum minutes difference between any two time points in the list.
Example 1:
Input: ["23:59","00:00"]
Output: 1
 */

import java.util.ArrayList;
import java.util.List;

/*
1. Convert into minutes
2. result = Math.abs(min1 - 24*60 -min2)
 */

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timeStr){
        String time1 = timeStr.get(0);
        String time2 = timeStr.get(1);

        int time1InMinutes = Integer.parseInt(time1.substring(0,2))*60 + Integer.parseInt(time1.substring(3,5));
        int time2InMinutes = Integer.parseInt(time2.substring(0,2))*60 + Integer.parseInt(time2.substring(3,5));

        int res = Math.abs(time1InMinutes - 24*60 - time2InMinutes);
        return res;
    }
}

class MinTimeDiffDriver{
    public static void main(String[] args) {
        MinimumTimeDifference m = new MinimumTimeDifference();
        List<String> timeArr = new ArrayList<>();
        timeArr.add("23:59");
        timeArr.add("00:10");
        int res = m.findMinDifference(timeArr);
        System.out.println(res);
    }
}