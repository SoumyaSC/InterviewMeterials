package Algorithms;

/*
https://leetcode.com/problems/lru-cache/
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  capacity) ;

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

 */
import java.util.HashMap;
import java.util.Map;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next = null;
    }
}

public class LRUCache {
    Map<Integer, Node> nodeMap;
    int capacity;
    int currentCapacity = 0;
    Node head = null;

    public LRUCache(int capacity){
        nodeMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int getKey(Map<Integer, Node> map, int value) {
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            if (entry.getValue().data == value) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // capacity : 3
    // 1:1
    // 2:2
    // 3:3
    // 4:4 del 1:1 (2:2 3:3 4:4)
    // get(2)
    // 3:3 4:4 2:2
    public void put(int key, int value){
        //put new values, before that check if capacity is full
        if(currentCapacity < capacity ){
            currentCapacity++;
            head = addNodeToHead(head, value);
            nodeMap.put(key, addNodeToHead(head, value));
        }else{
            int dataDeleted = deleteFromEnd(head);
            int toBeDeletedKeyFromMap = getKey(nodeMap, dataDeleted);
            nodeMap.remove(toBeDeletedKeyFromMap);
            nodeMap.put(key, addNodeToHead(head, value));
        }
    }

    public int get(int key){
        if(nodeMap.get(key) == null){
            return -1;
        }else{
            Node node = nodeMap.get(key);
            head = node;
            return node.data;
        }
    }

    private Node addNodeToHead(Node head, int data){
        Node node = head;
        if(node == null){
            node = new Node(data);
            head = node;
        }else{
            node = new Node(data);
            node.next = head;
            head = node;
        }
        return head;
    }

    private int deleteFromEnd(Node head){
        Node node = head;
        while (node.next.next!=null){
            node = node.next;
        }
        int dataDeleted = node.next.data;
        node.next = null;
        return dataDeleted;
    }

    //debug
    public void show(Node head){
        Node node = head;
        while(node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}

class LRUCacheDriver{
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        /*Node head = null;
        head = lruCache.addNodeToHead(head,1);
        head = lruCache.addNodeToHead(head,2);
        head = lruCache.addNodeToHead(head,3);*/

        lruCache.put(1, 1);
        lruCache.put(2, 2);

        int value = lruCache.get(1);
        System.out.println(value);

        lruCache.put(3, 3);

        value = lruCache.get(2);
        System.out.println(value);

        lruCache.put(4, 4);

        value = lruCache.get(1);
        System.out.println(value);

        value = lruCache.get(3);
        System.out.println(value);

        value = lruCache.get(4);
        System.out.println(value);

    }
}