package Algorithms.Trees;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

//I took a BST here
public class BinaryTreeZigzagLevelOrderTraversal extends BSTUtil{
    public int findHeight(Node root){
        int leftHeight = 0;
        int rightHeight = 0;

        if(root == null){
            return 0;
        }else{
            leftHeight = findHeight(root.left);
            rightHeight = findHeight(root.right);

            if(leftHeight > rightHeight){
                return leftHeight+1;
            }else{
                return rightHeight+1;
            }
        }
    }

    public void printZigZag(Node root, int level){
        int count = 0;
        if(root == null){
            return;
        }else{
            if(level == 1){
                System.out.println(root.data);
            }else{
                if(count % 2 == 0) {
                    printZigZag(root.left, level - 1);
                    printZigZag(root.right, level - 1);
                    count++;
                }else{
                    printZigZag(root.right, level - 1);
                    printZigZag(root.left, level - 1);
                }
            }
        }
    }
}

class BTZigZagDriver{
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
        Node root = null;

        root = b.insert(5, root);
        root = b.insert(2, root);
        root = b.insert(10, root);
        root = b.insert(9, root);
        root = b.insert(15, root);

        //Debug
        //b.show(root);

        int height = b.findHeight(root);
        System.out.println("Height of the tree is: " + height);

        for(int i=1; i<=height; i++){
            b.printZigZag(root, i);
        }

    }
}