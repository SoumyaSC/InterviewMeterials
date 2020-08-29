package Algorithms.LinkedList;

public class SingleLinkedListUtil {
    Node head = null;

    public Node insertAtEnd(int data){
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

}
