package Algorithms.Trees;

public class LeftViewOfTree {
    Node root = null;
    static int max_level = 0;

    //helper method to insert values into the tree
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

    public void leftView(Node root, int level){
        if(root == null){
            return;
        }
        else{
            if(max_level < level){
                System.out.println(root.data);
                max_level = level;
            }
        }
        leftView(root.left, level+1);
        leftView(root.right, level+1);
    }
}

class DriverLeftView{
    public static void main(String []args){
        Node root = null;
        LeftViewOfTree leftViewOfTree = new LeftViewOfTree();

        //create a bunch of manual nodes, each return of root, returns
        //updated root
        root = leftViewOfTree.insert(root, 20);
        root = leftViewOfTree.insert(root, 10);
        root = leftViewOfTree.insert(root, 30);
        root = leftViewOfTree.insert(root, 40);
        root = leftViewOfTree.insert(root, 50);
        root = leftViewOfTree.insert(root, 60);

        leftViewOfTree.leftView(root, 1);



    }
}

