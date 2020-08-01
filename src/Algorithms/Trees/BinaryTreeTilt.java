package Algorithms.Trees;

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
