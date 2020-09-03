package Algorithms;

class QueueNode{
    int data;
    QueueNode next;

    public QueueNode(int data){
        this.data = data;
        next = null;
    }
}
public class BlockingQueue {
    QueueNode head = null;
    int size = 0;
    Boolean isSetDone = false;

    public synchronized QueueNode enqueue(int data) throws InterruptedException{
        QueueNode node = head;
        while (isSetDone == true || size > 5) {
            try {
                System.out.println("In enqueue wait...");
                wait();
            } catch (Exception e) {
            }
        }

        if (node == null) {
            node = new QueueNode(data);
            System.out.println("Inserted into queue: " + node.data);
            head = node;
            size++;
            isSetDone = true;
            notifyAll();
        } else {
            if (size <= 5) {
                while (node.next != null) {
                    node = node.next;
                }
                QueueNode newNode = new QueueNode(data);
                System.out.println("Inserted into queue: " + newNode.data);
                newNode.next = null;
                node.next = newNode;
                size++;
                isSetDone = true;
                notifyAll();
            }
        }
        return head;
    }

    public synchronized QueueNode dequeue() throws InterruptedException{
        while (isSetDone == false || size == 0){
            try {
                System.out.println("In dequeue wait...");
                wait();
            }
            catch (Exception e){}
        }
        if(size!=0 && head!=null && head.next!=null) {
            size--;
            QueueNode node = head;
            System.out.println("Data deleted " + node.data);
            node = node.next;
            head = node;
            isSetDone = false;
            notifyAll();
        }
        else{
            if(size!=0 && head!=null && head.next == null){
                size--;
                head = null;
            }
        }
        return head;
    }

    public void showQueue(){
        QueueNode node = head;

        while (node.next!=null && node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}


class BlockingQueueDriver{
    public static void main(String[] args) {
        QueueNode head;
        BlockingQueue blockingQueue = new BlockingQueue();


        new Thread(() -> {
            try {
                blockingQueue.dequeue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                blockingQueue.enqueue(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();






    }
}