package Algorithms;

class NodeBB{
    char data;
    NodeBB next;

    public NodeBB(char data){
        this.data = data;
        next = null;
    }
}

class BalanceBracket {

    NodeBB head;

    public void insertAtBeg(char ch) {
        if (head == null) {
            //no node yet, insert at beg, make it head
            NodeBB node = new NodeBB(ch);
            node.next = null;
            head = node;
        } else {
            //10 ->    5
            NodeBB node = new NodeBB(ch);
            node.next = head;
            head = node;
        }
    }

    public void deleteFromBeg(){
        NodeBB node = head;
        node = node.next;
        head = node;
    }


    ////print a node
    public void show(){
        NodeBB node = head;
        while (node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public Boolean balanceBracket(char []brackets){
        for(int i=0; i<brackets.length; i++){
            if(brackets[i] == '[' || brackets[i] == '{' || brackets[i] == '(') {
                insertAtBeg(brackets[i]);
            }


            else if(head != null && brackets[i] == ']'){
                if(head.data == '['){
                    deleteFromBeg();
                }
                else{
                    System.out.println("SC1");
                    return false;
                }
            }
            else if(head != null && brackets[i] == '}'){
                if(head.data == '{'){
                    deleteFromBeg();
                }
                else{
                    return false;
                }
            }
            else if(head != null && brackets[i] == ')'){
                if(head.data == '('){
                    deleteFromBeg();
                }
                else{
                    System.out.println("SC3");
                    return false;
                }
            }
        }



        if(head == null){
            return true;
        }
        else
            return false;
    }
}


class Driver5{
    public static void main(String []args){

        BalanceBracket bb = new BalanceBracket();
        char []arr = new char[]{'[', '[','{', '}', ']', '(', ')', ']'};
        Boolean result = bb.balanceBracket(arr);
        System.out.println(result);

    }
}


