package Algorithms.LinkedList;

/*
https://leetcode.com/problems/swap-nodes-in-pairs/
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class SwapNodesInPairs extends SingleLinkedListUtil{
    public Node swapInPairs(Node head){
        Node node = head;
        Node tmp = null;

        while(node!=null){
            Node nodeNext1 = node;
            Node nodeNext2 = node.next;

            tmp = nodeNext1;
            nodeNext1 = nodeNext2;
            nodeNext2 = tmp;

            System.out.println(nodeNext1.data);
            System.out.println(nodeNext2.data);
            node = node.next.next;
        }
        return null;
    }
}

class SNIPDriver{
    public static void main(String[] args) {
        SwapNodesInPairs s = new SwapNodesInPairs();
        Node head = s.insertAtEnd(5);
        s.insertAtEnd(51);
        s.insertAtEnd(54);
        s.insertAtEnd(541);
        //s.show(head)
        s.swapInPairs(head);
    }
}