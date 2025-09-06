package Linked_List;
public class LinkedList{
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data =data;
            this.next=null;
        }
    }
        public static Node head;
        public static Node tail;
        public static int size;

        // Methods
        public void addFist(int data){   // O(1)
            Node newNode =new Node(data);   // step 1  Create a new node 
            ++size;
            if(head == null){
                head = tail= newNode;
                return;
            }
            newNode.next= head;   // Linking  Step 2  
            head = newNode;    // Step 3 
        }

        public void addLast(int data){
           Node newNode =new Node(data);
           size++;
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public void print(){  //O(n)
            if(head ==null){
                System.out.println("LL is empty");
                return;
            }
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println("null");
        }
        public void add(int idx ,int data){
            if(idx==0){
                addFist(data);
                return;
            }
            Node newNode =new Node(data);
            size++;
            int i=0;
            Node temp=head;
            while(i<idx-1){
                temp=temp.next;
                ++i;
            }
            // Now i= idx -1   temp->prev
            newNode.next=temp.next;
            temp.next=newNode;
        }
        public int removeFirst(){
            if(size==0){
                System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            }
            else if (size==1){
                int val=head.data;
                head=head.next;
                size=0;
                return val;
            }
            int val=head.data;
            head=head.next;
            size--;
            return val;
        }
        public int removeLast(){
            if(size==0){
                System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            }
            else if(size==1){
                int val=head.data;
                head=tail=null;
                size=0;
                return val;
            }
            // prev : i=size-2;
            Node prev=head;
            for(int i=0;i<size-2;i++){  
                prev=prev.next;
            }
            int val = prev.next.data; // tail.data
            prev.next=null;
            tail=prev;
            size--;
            return val;
        }
        public int iterativeSearch(int key){
            Node temp=head;
            int idx=0;
            while(temp!=null){
                if(temp.data==key){
                    return idx;
                }else{
                temp=temp.next;
                idx++;
                }
            }
            return -1;
        }
        public int recursiveSearch(Node head,int key){  // O(n)
            if(head==null)
            return -1;
            if(head.data==key){
                return 0;
            }
            int idx=recursiveSearch(head.next, key);
            if(idx==-1){
                return -1;
            }
            return idx+1;
        }
        public void reverse(){
            Node prev=null;
            Node curr=tail=head;
            Node next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            head=prev;
        }

        public void deleteNthfromEnd(int  n){
            // calculate size
            int sz=0;
            Node temp=head;
            while(temp!=null){
                ++sz;
                temp=temp.next;
            }
            if(n==sz){
            head=head.next;
            return;
            }
            int i=1;
            Node prev=head;
            int iToFind=size-n;
            while(i<iToFind){
                prev=prev.next;
                ++i;
            }
            prev.next=prev.next.next;
        }

        public Node findMid(Node head){   // Slow-fast approach
            Node slow=head;
            Node fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;   // slow is my middle node 
        }

        public boolean checkPalindrome(){
            if(head==null || head.next==null){
                return true;
            }
            // Step1 - to find mid 
            Node midNode=findMid(head);
            // Step2 - reverse the 2nd half 
            Node prev=null;
            Node curr=midNode;
            Node next ;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            Node right=prev;
            Node left =head;
            // step3 - check if left half && right half 
            while(right!=null){
                if(left.data!=right.data){
                    return false;
                }
                left=left.next;
                right=right.next;
            }
            return true;

        }
        public static void main(String[] args) {
            LinkedList ll= new LinkedList();
            ll.addFist(1);
            ll.addFist(2);
            ll.addFist(2);
            ll.addFist(1);
            // ll.addFist(2);
            // ll.addFist(1);
            // ll.addLast(1);
            // ll is 1->2->1 
            ll.print();
            System.out.println(ll.checkPalindrome());


            // ll.addLast(5);
            // ll.add(2,3);
            

            // ll.deleteNthfromEnd(3);
            // ll.print();
            // ll.removeFirst();
            // ll.print();

            // ll.removeLast();
            // ll.print();
            // System.out.println(ll.size);
            // System.out.println(ll.recursiveSearch(head,4));
            // System.out.println(ll.iterativeSearch(10));
            // ll.reverse();
            // ll.print();

    }
}