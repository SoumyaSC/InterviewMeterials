package Algorithms.Trees;
/*https://www.geeksforgeeks.org/tilt-binary-tree/
        Given a binary tree, return the tilt of the whole tree.
        The tilt of a tree node is defined as the absolute difference between
        the sum of all left subtree node values and the sum of all right subtree node values.
        Null nodes are assigned tilt to be zero.
        Therefore, tilt of the whole tree is defined as the sum of all nodes’ tilt.*/

public class BinaryTreeTilt {

    public int findTilt(Node root){
        int leftSum = 0;
        int rightSum = 0;
        if(root == null){
            return 0;
        }
        else{
            leftSum = findTilt(root.left);
            rightSum = findTilt(root.right);
        }
        int result = Math.abs(leftSum-rightSum) + root.data;
        return result;
    }
}
