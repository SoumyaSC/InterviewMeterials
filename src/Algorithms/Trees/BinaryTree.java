package Algorithms.Trees;

public class BinaryTree {
    public Node insert(Node root, int data, int level){
        if(root == null){
            Node node = new Node(data);
            root = node;
        }else{
            if(root.left == null && root.right == null){
                root.left = insert(root.left, data, level+1);
            }else if (root.left != null && root.right == null){
                root.right = insert(root.right, data, level+1);
            }else if(root.left == null && root.right != null){
                root.left = insert(root.left, data, level+1);
            }else{
                root.left.left = insert(root.left.left, data, level+1);
            }

        }
        return root;
    }

    public int findHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftH = 0;
        int rightH = 0;

        leftH = findHeight(root.left);
        rightH = findHeight(root.right);

        if(leftH > rightH){
            return  leftH + 1;
        }else{
            return rightH+1;
        }
    }

    public void showBFS(Node root, int level){
        if(root == null){
            return;
        }else{
            if(level == 1){
                System.out.println(root.data);
            }
            showBFS(root.left, level - 1);
            showBFS(root.right, level - 1);
        }
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
}

class BinaryTreeDriver{
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        Node root = null;

        root = b.insert(root, 10, 0);
        root = b.insert(root, 20, 0);
        root = b.insert(root, 30, 0);
        root = b.insert(root, 40, 0);
        root = b.insert(root, 50, 0);
        root = b.insert(root, 60, 0);
        root = b.insert(root, 70, 0);

        //DFS
        //b.show(root);

        int height = b.findHeight(root);
        System.out.println("height is " + height);

        for(int i=1; i<=height; i++){
            b.showBFS(root, i);
        }
    }
}
