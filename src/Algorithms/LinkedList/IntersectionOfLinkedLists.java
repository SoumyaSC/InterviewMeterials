package Algorithms.LinkedList;

/*
https://leetcode.com/problems/intersection-of-two-linked-lists/
Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfLinkedLists {
    Node head = null;

    public Node insert(int data){
        Node node = head;

        if(node == null){
            node = new Node(data);
            head = node;
        }else{
            //insert at end
            while(node.next!=null){
                node = node.next;
            }
            Node newNode = new Node(data);
            newNode.next = null;
            node.next = newNode;
        }
        return head;
    }

    public void show(Node head){
        Node node = head;
        if(node == null){
            return;
        }else{
            while(node!=null){
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    public void findIntersection(Node head1, Node head2){
        Node node1 = head1;
        Node node2 = head2;
        Node interection = null;

        if(node1.data == node2.data){
            System.out.println(node1.data);
        }else{
            while(node1!=null && node2!=null){
                if(node1.data == node2.data){
                    System.out.println(node1.data);
                    return;
                }else{
                    node1 = node1.next;
                    node2 = node2.next;
                }
            }
        }
    }
}

class LinkedListIntersectionDriver{
    public static void main(String[] args) {
        IntersectionOfLinkedLists i1 = new IntersectionOfLinkedLists();
        Node head1 = i1.insert(5);
        head1 = i1.insert(6);
        head1 = i1.insert(8);
        head1 = i1.insert(11);

        //i.show(head1);

        IntersectionOfLinkedLists i2 = new IntersectionOfLinkedLists();
        Node head2 = i2.insert(10);
        head2 = i2.insert(61);
        head2 = i2.insert(7);
        head2 = i2.insert(11);

        i2.findIntersection(head1, head2);




    }
}