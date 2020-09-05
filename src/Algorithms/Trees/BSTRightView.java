package Algorithms.Trees;

/*
https://leetcode.com/problems/binary-tree-right-side-view/
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class BSTRightView extends BSTUtil{

    static int max_level = 0;
    public int findHeight(Node root){
        if(root == null){
            return 0;
        }else{
            int leftHeight = 0;
            int rightHeight = 0;

            leftHeight = findHeight(root.left);
            rightHeight = findHeight(root.right);

            if(leftHeight > rightHeight){
                return leftHeight + 1;
            }else{
                return rightHeight + 1;
            }
        }
    }

    public void showRightView(Node root, int level){
        if(root == null){
            return;
        }else{
            if(max_level < level){
                System.out.println(root.data);
                max_level = level;
            }
        }
        showRightView(root.right, level+1);
        showRightView(root.left, level+1);
    }
}

class BSTRVDriver{
    public static void main(String[] args) {
        BSTRightView b = new BSTRightView();
        Node root = null;

        root = b.insert(10, root);
        root = b.insert(7, root);
        root = b.insert(20, root);
        root = b.insert(35, root);
        root = b.insert(30, root);


        //b.show(root);

        int height = b.findHeight(root);
        System.out.println("height of the tree is " + height);

        System.out.println("right view of tree is");
        b.showRightView(root, 1);

    }
}