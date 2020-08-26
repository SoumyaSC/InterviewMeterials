package Algorithms.Trees;
/*
https://leetcode.com/problems/same-tree/
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false

 */
public class SameTree {
    Node root = null;

    public Node insert(Node root, int data){

        if (root == null) {
            Node node = new Node(data);
            root = node;
        }
        else{
            if(data> root.data){
                root.right = insert(root.right, data);
            }
            else{
                root.left = insert(root.left, data);
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

    public Boolean sameTree(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 == null){
            return false;
        }
        if(root1 == null && root2 != null){
            return false;
        }
        else{
            if(root1.data == root2.data){
                return (sameTree(root1.left, root2.left)&&
                sameTree(root1.right, root2.right));
            }else{
                return false;
            }
        }
    }
}

class STDriver{
    public static void main(String[] args) {
        //Create object of two trees
        SameTree s1 = new SameTree();
        SameTree s2 = new SameTree();

        //Initialize the trees, I am taking a BST here
        Node root1 = null;
        root1 = s1.insert(root1, 1);
        root1 = s1.insert(root1, 0);
        root1 = s1.insert(root1, 2);

        Node root2 = null;
        root2 = s2.insert(root2, 1);
        root2 = s2.insert(root2, 0);
        root2 = s2.insert(root2, 2);

        //Debug print the BST
        //s1.show(root1);
        //s2.show(root2);

        //Check if both are equal
        Boolean result = s1.sameTree(root1, root2);
        System.out.println(result);
    }
}