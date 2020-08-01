package Algorithms.Trees;


class BTreeInsert{
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


    public int findHeight(Node root){
        int rightHeight = 0;
        int leftHeight = 0;
        if(root == null){
            return 0;
        }
        else{

            //idea is to recur down the tree and put height of right and left node
            //into seperate variables
            //later compare and return the biggest height
            rightHeight = findHeight(root.right);
            leftHeight = findHeight(root.left);

            if(rightHeight > leftHeight){
                rightHeight = rightHeight + 1;
                return rightHeight;
            }
            else{
                leftHeight = leftHeight +1;
                return leftHeight;
            }
        }
    }
}

class Driver{
    public static void main(String []args){
        Node root = null;
        BTreeInsert bTreeInsert = new BTreeInsert();
        for(int i=0; i<5; i++) {
            root = bTreeInsert.insert(root, i);
        }

        bTreeInsert.show(root);

        int height = bTreeInsert.findHeight(root);
        System.out.print("Height is: " + height);
    }
}