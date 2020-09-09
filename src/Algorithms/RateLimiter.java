package Algorithms;

/*
A rate limiter:
1. consists of only one server
2. multiple clients can request server
3. maintains threshold of request for every customers
4. if threshold exceeds for one customer it neglects or drops that request
 */

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    int capacity;
    int timeThreshold;
    Map<Integer, Integer> hashMap;

    public RateLimiter(int capacity, int timeThreshold){
        this.capacity = capacity;
        this.timeThreshold = timeThreshold;
        hashMap = new HashMap<>();
    }

    public Boolean useServer(int customerID){
        //seen customer before
        if (hashMap.containsKey(customerID)) {
            //capacity > threshold
            if (hashMap.get(customerID) >= capacity) {
                return false;
            }
            //seen cust before, seeing him/her again within threshold
            else {
                int value = hashMap.get(customerID);
                hashMap.put(customerID, value + 1);
                return true;
            }
        }
        //seeing customer for first time
        else {
            hashMap.put(customerID, 1);
            return true;
        }
    }
}

class RateLimiterDriver{
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(2, 1);

        Boolean res = rateLimiter.useServer(1);
        System.out.println(res);

        res = rateLimiter.useServer(1);
        System.out.println(res);


        res =rateLimiter.useServer(1);
        System.out.println(res);

        res = rateLimiter.useServer(2);
        System.out.println(res);

        res = rateLimiter.useServer(2);
        System.out.println(res);

        res =rateLimiter.useServer(2);
        System.out.println(res);
    }
}
