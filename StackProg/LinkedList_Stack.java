
public class LinkedList_Stack {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    
    static class Stack{
        static Node head=null;

        public static boolean isEmpty(){
            return head==null;
        }

        //push function
        public static void push(int data){
            Node newNode =new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }

        // pop function
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }

        // peek function
        public static int peek(){
            return head.data;
        }
    }
    public static void main(String args[]){
        Stack ob=new Stack();
        ob.push(1);
        ob.push(2);
        ob.push(3);

        while(!ob.isEmpty()){
            System.out.println(ob.peek());
            ob.pop();
        }
    }
}
