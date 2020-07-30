class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        next = null;
    }
}

public class SingleLinkedList {

    Node head;

    public void insertAtBeg(int data) {
        if (head == null) {
            //no node yet, insert at beg, make it head
            Node node = new Node(data);
            node.next = null;
            head = node;
        } else {
            //10 ->    5
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    public void insertAfterHeadButNoTail(int data, int insertAfter){
        Node node = head;
        //10 -> 5 -> 11
        //10 -> 5 -> 7 -> 11

        while(node.next.data==insertAfter && node.next!=null){
                node = node.next;
        }
        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    public void insertAtTail(int data){
        Node node = head;
        while(node.next!=null){
            node = node.next;
        }
        Node newNode = new Node(data);
        newNode.next = null;
        node.next = newNode;
    }

    public void deleteFromBeg(){
        Node node = head;
        node = node.next;
        head = node;
    }

    public void deleteFromAnyPosition(int data){
        Node trav1 = head;
        Node trav2 = head.next;

        if(trav1.data == data){
            deleteFromBeg();
        }

        if(trav2.data == data) {
            trav2 = trav2.next;
            trav1.next = trav2;
        }
        else {

            while (trav2.next.data != data) {
                trav1 = trav1.next;
                trav2 = trav2.next;
            }

            //6 51 100
            trav2 = trav2.next;
            trav1.next = trav2;
        }
    }

    ////print a node
    public void show(){
        Node node = head;
        while (node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}

class Driver4{
    public static void main(String []args){
        SingleLinkedList sll = new SingleLinkedList();
        //51
        sll.insertAtBeg(51);
        //100 51
        sll.insertAtBeg(100);
        //1000 100 51
        sll.insertAtBeg(1000);

        //1000 100 6 51
        sll.insertAfterHeadButNoTail(6, 100);

        //1000 100 6 51 1
        sll.insertAtTail(1);

        //100 6 51 1
        sll.deleteFromBeg();

        //100 51 1
        sll.deleteFromAnyPosition(6);

        sll.show();
    }
}
