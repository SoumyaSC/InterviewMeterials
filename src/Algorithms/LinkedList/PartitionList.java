package Algorithms.LinkedList;

/*
https://leetcode.com/problems/partition-list/
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 */
public class PartitionList extends SingleLinkedListUtil{
    public Node partition(Node head, int number, SingleLinkedListUtil s1, SingleLinkedListUtil s2){
        Node node = head;
        Node head1 = null;
        Node head2 = null;

        while (node != null) {
            if(node.data < number){
                head1 = s1.insertAtEnd(node.data);
            }else{
                head2 = s2.insertAtEnd(node.data);
            }
            node = node.next;
        }

        s1.show(head1);
        s1.show(head2);
        return null;
    }
}

class PartitionListDriver{
    public static void main(String[] args) {
        PartitionList p = new PartitionList();
        Node head = p.insertAtEnd(1);
        p.insertAtEnd(4);
        p.insertAtEnd(3);
        p.insertAtEnd(2);
        p.insertAtEnd(5);
        p.insertAtEnd(2);

        SingleLinkedListUtil s1 = new SingleLinkedListUtil();
        SingleLinkedListUtil s2 = new SingleLinkedListUtil();

        p.partition(head, 3, s1, s2);
    }
}