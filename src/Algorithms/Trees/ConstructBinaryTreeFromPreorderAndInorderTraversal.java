package Algorithms.Trees;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

//constructed by only preorder array
public class ConstructBinaryTreeFromPreorderAndInorderTraversal extends BSTUtil{
    public Node constructTree(Node root, int data){

        if(root == null) {
            root = new Node(data);
            System.out.println(root.data);
        }else {

            if (data < root.data) {
                root.left = constructTree(root.left, data);
            } else {
                root.right = constructTree(root.right, data);
            }
        }

        return root;
    }

    public Node constructTreeDriver(Node root, int[] preOrder, int[] inOrder){
        for(int i=0; i<preOrder.length; i++){
            constructTree(root, preOrder[i]);
        }
        return root;
    }
}

class ConstructTreeDriver{
    public static void main(String[] args) {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        Node root = null;

        ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        root = c.constructTreeDriver(root, preOrder, inOrder);
        c.show(root);

    }
}