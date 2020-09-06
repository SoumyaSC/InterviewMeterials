package Algorithms;

/*
https://leetcode.com/problems/keys-and-rooms/
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may
have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where
N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
 */

import java.util.*;

public class KeysAndRooms {
    public Boolean canVisitAllRooms(List<List<Integer>> rooms){
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(0);

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        while (!stack.isEmpty()){
            List<Integer> keys = rooms.get(stack.pop());

            for(int key : keys){
                if(!hashSet.contains(key)){
                    hashSet.add(key);
                    stack.add(key);
                }
            }
        }
        if(hashSet.size() == rooms.size()){
            return true;
        }
        else{
            return false;
        }
    }
}

class KeysAndRoomsDriver{
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> keys1 = new ArrayList<>();
        keys1.add(1);

        List<Integer> keys2 = new ArrayList<>();
        keys2.add(2);

        List<Integer> keys3 = new ArrayList<>();
        keys3.add(3);

        List<Integer> keys4 = new ArrayList<>();
        keys1.add(4);


        rooms.add(keys1);
        rooms.add(keys2);
        rooms.add(keys3);
        rooms.add(keys4);

        KeysAndRooms k = new KeysAndRooms();
        Boolean res = k.canVisitAllRooms(rooms);
        System.out.println(res);

    }
}