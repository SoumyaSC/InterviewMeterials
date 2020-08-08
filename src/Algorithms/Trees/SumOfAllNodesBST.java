package Algorithms.Trees;

//Sum of all nodes in a binary tree
//https://www.geeksforgeeks.org/sum-nodes-binary-tree/

public class SumOfAllNodesBST {
    Node root = null;
    int sum = 0;

    public Node insert(int data, Node root){
        if(root == null){
            Node node = new Node(data);
            root = node;
        }
        else{
            if(data>root.data){
                root.right = insert(data, root.right);
            }
            else{
                root.left = insert(data, root.left);
            }
        }
        return root;
    }

    public void show(Node root){
        if(root == null){
            return;
        }else{
            show(root.left);
            System.out.println(root.data);
            show(root.right);
        }
    }

    public int sum(Node root){
        if (root == null){
            return 0;
        }else{
            sum(root.left);
            sum = sum+root.data;
            sum(root.right);
        }
        return sum;
    }
}

class SumBSTDriver{
    public static void main(String[] args) {
        Node root = null;

        SumOfAllNodesBST s = new SumOfAllNodesBST();
        root = s.insert(20, root);
        root = s.insert(10, root);
        root = s.insert(30, root);
        root = s.insert(40, root);
        root = s.insert(50, root);

        //s.show(root);
        int sum = s.sum(root);
        System.out.println(sum);
    }
}