package Algorithms.Trees;

//Helper class for inserting and printing a BST

public abstract class   BSTHelper {
    Node root = null;

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

    public void show(Node root) {
        if (root == null) {
            return;
        } else {
            show(root.left);
            System.out.println(root.data);
            show(root.right);
        }
    }
}
