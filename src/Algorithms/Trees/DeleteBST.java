package Algorithms.Trees;

public class DeleteBST {

    Node root = null;
    int sum = 0;

    public Node insert(int data, Node root){
        if(root == null){
            Node node = new Node(data);
            root = node;
        }
        else{
            if(data>root.data){
                root.right = insert(data, root.right);
            }
            else{
                root.left = insert(data, root.left);
            }
        }
        return root;
    }

    public void show(Node root){
        if(root == null){
            return;
        }else{
            show(root.left);
            System.out.println(root.data);
            show(root.right);
        }
    }

    public Node deleteBST(){
        root = null;
        return root;
    }
}

class DeleteBSTDriver{
    public static void main(String[] args) {
        DeleteBST deleteBST = new DeleteBST();

        Node root = null;
        root = deleteBST.insert(20, root);
        root = deleteBST.insert(10, root);
        root = deleteBST.insert(30, root);
        root = deleteBST.insert(50, root);

        //bstHelper.show(root);
        root = deleteBST.deleteBST();

        deleteBST.show(root);
    }
}