package Algorithms.Trees;

/*Given two non-empty binary trees s and t, check whether tree t has exactly
the same structure and node values with a subtree of s.
A subtree of s is a tree consists of a node in s and all of this node's descendants.
The tree s could also be considered as a subtree of itself.

        Example 1:
        Given tree s:

         3
        / \
       4   5
      / \
     1   2

        Given tree t:
         4
        / \
        1   2
        Return true, because t has the same structure and node values with a subtree of s.*/

public class SubtreeOfAnotherTree {
    public Boolean isSubtree(Node root1, Node root2) {
        if(root1 != null && root2 == null){
            return true;
        }
        else if(root1 == null && root2 == null){
            return true;
        }
        else{
            //if there is a match wrt root's data, check if left and right data is a match
             if(root1.data == root2.data){
                 isSubtree(root1.left, root2.left);
                 isSubtree(root1.right, root2.right);
                 return true;
             }
             else{
                 //if not, recur down the tree and see for match
                 isSubtree(root1.left, root2.left);
                 isSubtree(root1.right, root2.right);
                 return true;
             }
        }

    }
}
