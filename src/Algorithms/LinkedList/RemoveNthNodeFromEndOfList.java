package Algorithms.LinkedList;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndOfList extends SingleLinkedListUtil {
    public Node removeFromEnd(Node head, int positionFromEnd) {
        Node node = head;
        int count = 0;
        int posFromBeg = 0;

        //get no of total nodes
        while (node != null) {
            count++;
            node = node.next;
        }

        //System.out.println(count);

        //get delete to be del position from beginning
        posFromBeg = count - positionFromEnd;
        node = head;
        count = 0;

        //traverse to a node which is just before the node to be deleted
        while (count != (posFromBeg-1)) {
            //System.out.println(count + " " + posFromBeg);
            count++;
            node = node.next;
        }

        //delete the next node
        node.next = node.next.next;
        return head;
    }
}

class RemoveNthNodeDriver {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        Node head = r.insertAtEnd(1);
        r.insertAtEnd(2);
        r.insertAtEnd(3);
        r.insertAtEnd(4);

        head = r.removeFromEnd(head, 2);
        r.show(head);
    }
}