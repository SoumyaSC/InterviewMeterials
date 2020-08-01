package Algorithms.Trees;

public class BinaryTreeToMirrorTree {
    Node root = null;

    public Node insert(Node root, int data){
        if(root == null){
            Node node = new Node(data);
            root = node;
        }
        else{
            if(data > root.data){
                root.right = insert(root.right, data);
            }
            else{
                root.left = insert(root.left, data);
            }
        }
        return root;
    }

    //helper method show
    public void show(Node root){
        if(root == null){
            return;
        }
        else{
            show(root.left);
            System.out.println(root.data);
            show(root.right);
        }
    }

    public Node mirror(Node root){
        if(root == null){
            return null;
        }else{
            Node left = mirror(root.left);
            Node right = mirror(root.right);

            root.left = right;
            root.right = left;
        }
        return root;
    }
}

class Driver2{
    public static void main(String []args){
        Node root = null;
        BinaryTreeToMirrorTree binaryTreeToMirrorTree = new BinaryTreeToMirrorTree();
        for(int i=0; i<5; i++) {
            root = binaryTreeToMirrorTree.insert(root, i);
        }

        //Helper show command
        binaryTreeToMirrorTree.show(root);

        Node node2 = binaryTreeToMirrorTree.mirror(root);
        System.out.println("Showing results after mirror");
        binaryTreeToMirrorTree.show(node2);
    }
}