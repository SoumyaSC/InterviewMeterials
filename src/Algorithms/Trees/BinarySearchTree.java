package Algorithms.Trees;

//https://www.youtube.com/watch?v=RBSGKlAvoiM&t=14127s

class BinaryNode{
    int data;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}



public class BinarySearchTree {
    BinaryNode root = null;

    public BinaryNode insert(int data, BinaryNode root){
        BinaryNode tmp = root;

        if(tmp==null){
            tmp = new BinaryNode(data);
            root = tmp;
        }

        else if(data > root.data){
            //we need to right root.right and root.left while inserting because we need to preserve and
            //keep track of the root.
            root.right = insert(data, root.right);
        }
        else{
            //we need to right root.right and root.left while inserting because we need to preserve and
            //keep track of the root.
            root.left = insert(data, root.left);
        }

        //showTree(root);
        //return root for tracking, this is the KEY
        return root;

    }

    //Actually an inorder traversal
    public void showTree(BinaryNode root){
        if(root == null){
            //this return statement is crucial.
            //it must be given to avoid NPE
            return;
        }
        showTree(root.left);
        System.out.println(root.data);
        showTree(root.right);
    }

    public void contains(int data, BinaryNode root){

        if(root == null){
            System.out.println("Tree is empty");
        }
        else if(data == root.data){
            System.out.println("Element is there " + data);
            //return true;
        }
        else{
            if(data > root.data){
                contains(data, root.right);
            }
            else{
                contains(data, root.left);
            }
            //can be added one more condition as element is not there, skipping it for now
        }

    }

    public BinaryNode remove(int data, BinaryNode root){
        if(root == null){
            System.out.println("Nothing to remove");
        }
        else{
            //find the node
            if(data > root.data){
                remove(data, root.right);
            }
            else if(data < root.data){
                remove(data, root.left);
            }
            else{
                //we found the node
                //is right subtree null?
                if(root.right==null){
                    BinaryNode leftNode = root.left;
                    root.data = 0;
                    root = null;
                    return leftNode;

                }
                else if(root.left == null){
                    BinaryNode rightnode = root.right;
                    root.data = 0;
                    root = null;
                    return rightnode;
                }
                //we have both left subtree and right subtree
                //we have two options:
                //1. Find the min value of the right subtree
                //2. Find the max value of the left subtree
                //Here I am going to find the min value of the right subtree, replace that with root, and delete the
                //left node. So it essentially be one of the upper two cases.
                //If I go with option 1, I will have a case where I will have right subtree left. So i will call
                //remove(tmp.data, tmp.right)
                else{
                    BinaryNode tmp = findMin(root.right);
                    root.data = tmp.data;

                    root.right = remove(tmp.data, tmp.right);
                }
            }
        }
        return root;
    }

    public BinaryNode findMin(BinaryNode root){
        if(root == null) return null;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}

class Driver8{
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        BinaryNode root = null;

        //You can insert an array to a BST, bravo.
        for(int i=0; i<5; i++){
            root = bst.insert(i, root);
        }

        bst.contains(1, root);
        bst.showTree(root);

        System.out.println("Removing element");
        bst.remove(1, root);

        bst.showTree(root);
    }
}