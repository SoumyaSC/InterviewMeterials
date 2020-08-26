package Algorithms.Trees;
/*
https://leetcode.com/problems/symmetric-tree/
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 */
public class SymmetricTree extends BSTUtil{
    public Boolean isSymmetric(Node root1, Node root2){
        if(root1 == null && root2==null){
            return true;
        }else{
            if(root1!=null && root2!=null && root1.data == root2.data){
                return (isSymmetric(root1.left, root2.right) &&
                isSymmetric(root1.right, root2.left));
            }else{
                return false;
            }
        }
    }
}

class STreeDriver{
    public static void main(String[] args) {
        SymmetricTree s = new SymmetricTree();
        Node root = null;
        root = s.insert(5, root);

        //s.show(root);

        Boolean result = s.isSymmetric(root, root);
        System.out.println(result);
    }
}