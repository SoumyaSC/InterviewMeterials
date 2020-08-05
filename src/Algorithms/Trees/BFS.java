package Algorithms.Trees;

public class BFS {
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

    public void DFS(Node root){
        if(root == null){
            return;
        }else{
            DFS(root.left);
            System.out.println(root.data);
            DFS(root.right);
        }
    }

    public int findHeight(Node root){
        int leftHeight = 0;
        int rightHeight = 0;
        if(root == null){
            return 0;
        }else{
            leftHeight = findHeight(root.left);
            rightHeight = findHeight(root.right);

            if(leftHeight > rightHeight){
                return leftHeight+1;
            }
            else{
                return  rightHeight+1;
            }

        }
    }


    //Actual BFS code
    public void BFSTreeShow(Node root, int level){
        if(root == null){
            return;
        }else{
            if(level == 1) {
                System.out.println(root.data);
            }
            BFSTreeShow(root.left, level-1);
            BFSTreeShow(root.right, level-1);
        }
    }
}

class DriverBFS{
    public static void main(String []args){
        BFS bfs = new BFS();
        Node root = null;

        root = bfs.insert(root, 20);
        root = bfs.insert(root, 10);
        root = bfs.insert(root, 30);
        root = bfs.insert(root, 50);
        root = bfs.insert(root, 40);

        //debug
        //System.out.println(root.data);

        int height =  bfs.findHeight(root);
        System.out.println("Height of tree is: " + height);

        System.out.println("DFS show");
        bfs.DFS(root);

        System.out.println("BFS show");
        for(int i=0; i<=height; i++)
            bfs.BFSTreeShow(root, i);

    }
}
