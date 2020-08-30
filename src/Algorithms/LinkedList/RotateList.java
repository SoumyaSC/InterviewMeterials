package Algorithms.LinkedList;

/*
https://leetcode.com/problems/rotate-list/
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList extends SingleLinkedListUtil{
    public Node rotate(Node head){
        Node node = head;
        Node tmp = null;

        while(node.next.next != null){
            // 1 2 3 4
            node = node.next;
        }
        tmp = node.next;
        node.next =  null;

        tmp.next = head;
        head = tmp;
        return head;
    }
}

class RotateListDriver{
    public static void main(String[] args) {
        RotateList r = new RotateList();
        Node head = r.insertAtEnd(1);
        r.insertAtEnd(2);
        r.insertAtEnd(3);
        r.insertAtEnd(4);
        r.insertAtEnd(5);

        int rotate = 2;
        for(int i=0; i<rotate; i++)
        head = r.rotate(head);

        r.show(head);
    }
}