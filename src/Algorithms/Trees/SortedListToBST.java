package Algorithms.Trees;

/*
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
every node never differ by more than 1.
 */
import java.util.ArrayList;
import java.util.List;

public class SortedListToBST{
    public Node constructBSTFromSortedList(Node root, int data){
        if(root == null){
            Node node = new Node(data);
            root = node;
        }else{
            if(data > root.data){
                root.right = constructBSTFromSortedList(root.right, data);
            }else{
                root.left = constructBSTFromSortedList(root.left, data);
            }
        }
        return root;
    }

    public void show(Node root){
        if(root == null){
            return;
        }else{
            System.out.println(root.data);
            show(root.left);
            show(root.right);
        }
    }
}

class SLToBSTDriver{
    public static void main(String[] args) {
        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(-10);
        sortedList.add(-3);
        sortedList.add(-0);
        sortedList.add(5);
        sortedList.add(9);

        Node root = null;
        SortedListToBST s = new SortedListToBST();
        root = s.constructBSTFromSortedList(root,sortedList.get(sortedList.size()/2) );

        for(int i=0; i< sortedList.size(); i++) {
            if(sortedList.get(i) == root.data){
                continue;
            }else {
                root = s.constructBSTFromSortedList(root, sortedList.get(i));
            }
        }

        System.out.println("root of the tree is " + root.data);
        s.show(root);

    }
}