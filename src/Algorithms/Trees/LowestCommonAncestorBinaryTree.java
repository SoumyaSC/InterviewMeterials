package Algorithms.Trees;

import java.util.ArrayList;
import java.util.List;


public class LowestCommonAncestorBinaryTree extends BSTUtil{
    List<Integer> pathA = new ArrayList<>();
    List<Integer> pathB = new ArrayList<>();

    public List<Integer> recordAPath(Node root, int a){
        if(root == null){
            return null;
        }else {
            if (a > root.data) {
                recordAPath(root.right, a);
                pathA.add(root.data);
            } else {
                recordAPath(root.left, a);
                pathA.add(root.data);
            }
        }
        return pathA;
    }

    public List<Integer> recordBPath(Node root, int b){
        if(root == null){
            return null;
        }else {
            if (b > root.data) {
                recordBPath(root.right, b);
                pathB.add(root.data);
            } else {
                recordBPath(root.left, b);
                pathB.add(root.data);
            }
        }
        return pathB;
    }

    public int findCommonAncestor(Node root, int a, int b){
        int result = -1;
        if(root == null){
            return -1;
        }else{
            List<Integer> aRecord = recordAPath(root, a);
            List<Integer> bRecord = recordBPath(root, b);

            for(int i=aRecord.size()-1; i>=0; i--){
                for(int j=bRecord.size()-1; j>=0; j--){
                    if(aRecord.get(i) == bRecord.get(j)){
                        //System.out.println(aRecord.get(i) + " :a debug b: " + bRecord.get(j) + " i: " + i + " j: " + j);
                        i--;
                        continue;
                    }else{
                        return bRecord.get(j+1);
                    }
                }
            }
        }
        return result;
    }

    //Debug
    /*public void printPath(){
        for(int i=0; i<pathA.size(); i++){
            System.out.println(pathA.get(i));
        }

        System.out.println("path");
        for(int i=0; i<pathB.size(); i++){
            System.out.println(pathB.get(i));
        }
    }*/
}

class LCADriver{
    public static void main(String[] args) {
        LowestCommonAncestorBinaryTree l = new LowestCommonAncestorBinaryTree();
        Node root = null;
        root = l.insert(5, root);
        root = l.insert(4, root);
        root = l.insert(10, root);
        root = l.insert(15, root);
        root = l.insert(9, root);

        int a = 4;
        int b = 10;
        int res = l.findCommonAncestor(root, a, b);
        System.out.println("Common ancestor : " + res);
        //l.printPath();
    }
}