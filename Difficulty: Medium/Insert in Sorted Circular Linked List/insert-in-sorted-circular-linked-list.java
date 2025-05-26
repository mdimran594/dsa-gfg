/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
         Node temp=new Node(data);
        int min=head.data;
        Node node=head;
        Node tail=head;
        
        while(node.next!=head)node=node.next;
        
        int max=node.data;
        if(data>=max ){
            node.next=temp;
            temp.next=head;
            return head;
            
        }else if(data<=min){
            node.next=temp;
            temp.next=head;
            return temp;
        }else {
            while(tail.next!=head && tail.next.data<=data)
                tail=tail.next;
            
            Node t2=tail.next;
            tail.next=temp;
            temp.next=t2;
            return head;
        }
    }
}