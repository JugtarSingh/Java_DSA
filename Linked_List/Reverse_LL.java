package Linked_List;
public class Reverse_LL {
    class Node{
       int data;
       Node link; 
       Node(){
        data=0;
        link=null;
       }
       Node(int data){
        this.data=data;
        link=null;
       }
    }

    Node head;
    void insert(int val){
        Node n = new Node(val);
        if(head==null){
            head=n;
        }
        else
        {
            Node temp=head;
            while(temp.link!=null){
                temp=temp.link;
            }
            temp.link=n;
        }
    }
    void print(){
        Node temp =head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.link;
        }
    }
    void reverse(){
        Node prev=null,next,currNode=head;
        while(currNode!=null){
            next=currNode.link;
            currNode.link = prev;
            prev = currNode;
            currNode=next;
        }
        head=prev;
    }
    public static void main(String agrs[]){
        Reverse_LL obj = new Reverse_LL();
        obj.insert(10);
        obj.insert(20);
        obj.insert(30);
        obj.insert(40);
        obj.reverse();
        obj.print();
    }
}
