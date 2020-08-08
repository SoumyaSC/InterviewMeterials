package Algorithms.Trees;

//BST to a Tree with sum of all smaller keys
//https://www.geeksforgeeks.org/bst-tree-sum-smaller-keys/

public class BSTToTreeWithSumOfSmallerKeys extends BSTHelper{

    //this function has defect
    public void convertTree(Node root, int sum){
        if(root == null){
            return;
        }
        else{
            convertTree(root.left, sum);
            sum = sum+root.data;
            root.data = sum;
            convertTree(root.right, sum);
        }
    }
}

class ConvertTreeToSumSmallerKeys{
    public static void main(String[] args) {
        BSTToTreeWithSumOfSmallerKeys b = new BSTToTreeWithSumOfSmallerKeys();
        Node root = null;

        root = b.insert(20, root);
        root = b.insert(10, root);
        root = b.insert(30, root);

        System.out.println("Printing tree before conversion");
        b.show(root);
        System.out.println("Printing trees after conversion");
        b.convertTree(root, 0);
        b.show(root);
    }


}