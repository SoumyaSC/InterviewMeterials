package Algorithms.Trees;

//Binary Tree to Binary Search Tree Conversion
//https://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/

import java.util.ArrayList;
import java.util.List;

public class BTtoBST extends BSTHelper{
    int count = 0;
    List<Integer> treeArr = new ArrayList<>();
    Node root = null;

/*    public int countNodes(Node root){
        if(root== null){
            return 0;
        }else{
            countNodes(root.left);
            count++;
            countNodes(root.right);
        }
        return count;
    }*/

    public List<Integer> transformTreeToArray(Node root){
        if(root == null){
            return null;
        }
        else{
            transformTreeToArray(root.left);
            treeArr.add(root.data);
            transformTreeToArray(root.right);
        }
        return treeArr;

    }

    //Shows elements of the BT that are stored into the array
    //Prints the array
    public void showTreeArr(){
        for(int i=0; i<treeArr.size(); i++)
            System.out.println(treeArr.get(i));
    }

    public Node actualInsert(Node root, int data){
        if(root == null){
            Node node = new Node(data);
            root = node;
        }else{
            if(data>root.data){
                root.right = actualInsert(root.right, data);
            }
            else{
                root.left = actualInsert(root.left, data);
            }
        }
        return root;
    }
}

class BTtoBSTHelper{
    public static void main(String[] args) {
        //1. Construct the BT manually, dont want to waste time much
        Node root = new Node(10);
        root.left = new Node(50);
        root.right = new Node(20);
        root.left.left = new Node(5);
        root.right.right = new Node(100);

        BTtoBST bTtoBST = new BTtoBST();

        //Helper function to show constructed tree
        System.out.println("Showing Binary tree");
        bTtoBST.show(root);

        //2. Store elements of BT into array
        List<Integer> treeArr = bTtoBST.transformTreeToArray(root);

        //Helper function to show the array
        System.out.println("Elements of the tree that are stored into the array");
        bTtoBST.showTreeArr();

        //3. Node define root as null
        // We want to construct a new BST from elements from the array, thats why root = null
        root = null;

        //4. Insert into BST from array
        for(int i=0; i<treeArr.size(); i++){
            root = bTtoBST.actualInsert(root, treeArr.get(i));
        }

        System.out.println("Printing BST");
        bTtoBST.show(root);
    }
}