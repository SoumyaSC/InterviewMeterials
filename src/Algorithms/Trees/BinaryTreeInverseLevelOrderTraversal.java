package Algorithms.Trees;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

 */
public class BinaryTreeInverseLevelOrderTraversal extends BSTUtil{
    static int maxLevel = 0;

    public int heightBST(Node root){
        int rightHeight = 0;
        int leftHeight = 0;
        if(root == null){
            return 0;
        }else{
            rightHeight = heightBST(root.right);
            leftHeight = heightBST(root.left);

            if(rightHeight>=leftHeight){
                rightHeight = rightHeight+1;
                return rightHeight;
            }else{
                leftHeight = leftHeight+1;
                return leftHeight;
            }
        }
    }

    public void inverseLevelOrderTrav(Node root, int level){
        if(root == null){
            return;
        }
        if(level==1){
            System.out.println(root.data);
        }
        else {
            inverseLevelOrderTrav(root.right, level - 1);
            inverseLevelOrderTrav(root.left, level - 1);
        }
    }
}

class BinaryTreeLevelOrderInverseTravDriver{
    public static void main(String[] args) {
        BinaryTreeInverseLevelOrderTraversal b = new BinaryTreeInverseLevelOrderTraversal();
        Node root = null;

        root = b.insert(5, root);
        root = b.insert(1, root);
        root = b.insert(10, root);

        //b.show(root);

        int height = b.heightBST(root);

        for(int i=height; i>=1; i--)
            b.inverseLevelOrderTrav(root, i);

    }
}