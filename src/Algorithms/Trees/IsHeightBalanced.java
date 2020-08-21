package Algorithms.Trees;

public class IsHeightBalanced {
    Node root = null;

    //helper method to insert values into the tree
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


    public int isHeightBalanced(Node root){
        int rightHeight = 0;
        int leftHeight = 0;
        if(root == null){
            return 0;
        }
        else{

            //idea is to recur down the tree and put height of right and left node
            //into seperate variables
            //later compare and return the biggest height
            rightHeight = isHeightBalanced(root.right);
            leftHeight = isHeightBalanced(root.left);

            if(rightHeight > leftHeight){
                rightHeight = rightHeight + 1;
            }
            else{
                leftHeight = leftHeight +1;
            }
        }

        int isHeightBalanced = 0;
        //A tree is called height balanced if height abs. is less that 1
        if(Math.abs(leftHeight - rightHeight)<= 1){
             isHeightBalanced = 1;
        }
        else{
            isHeightBalanced = 0;
        }
        return isHeightBalanced;
    }
}

class DriverIsHeightBalanced{
    public static void main(String []args){
        Node root = null;
        IsHeightBalanced isHeightBalanced = new IsHeightBalanced();

        //create a bunch of manual nodes, each return of root, returns
        //updated root
        root = isHeightBalanced.insert(root, 20);
        root = isHeightBalanced.insert(root, 10);
        root = isHeightBalanced.insert(root, 30);
        root = isHeightBalanced.insert(root, 40);
        root = isHeightBalanced.insert(root, 50);
        root = isHeightBalanced.insert(root, 60);



        System.out.println("Root of the tree is: " + root.data);
        isHeightBalanced.show(root);

        int isBalanced = isHeightBalanced.isHeightBalanced(root);
        //1 - height balanced
        //2 - not balanced
        System.out.print("Is height balanced is: " + isBalanced);
    }
}