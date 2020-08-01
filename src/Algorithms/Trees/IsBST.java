package Algorithms.Trees;

public class IsBST {
    Node root = null;

    public Node insert(Node root, int data){
        if(root == null){
            Node node = new Node(data);
            root = node;
        }
        else{
            if(data > root.data){
                root.right = insert(root.right, data);
            }
            else{
                root.left = insert(root.left, data);
            }
        }
        return root;
    }

    //helper method show
    public void show(Node root){
        if(root == null){
            return;
        }
        else{
            show(root.left);
            System.out.println(root.data);
            show(root.right);
        }
    }

    public Boolean isBST(Node root){
        if(root == null){
            return false;
        }
        else{
            if(root.left!=null && root.left.data < root.data){
                return true;
            }

            if(root.right!=null && root.data < root.right.data){
                    return true;
            }
            isBST(root.left);
            isBST(root.right);
        }
        return false;
    }
}

class DriverIsBST{
    public static void main(String []args){
        Node root = null;
        IsBST isBST = new IsBST();
        for(int i=0; i<5; i++) {
            root = isBST.insert(root, i);
        }

        //Helper show command
        //isBST.show(root);

        Boolean result = isBST.isBST(root);
        System.out.print("Result is: " + result);
    }
}