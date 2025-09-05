import java.util.*;
public class Stack1 {  // LIFO(Last in first out)
    public static class SubStack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }

        // push function
        public static void push(int val){
            list.add(val);
        }

        //pop function
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        // peek function
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        } 
    }
    public static void main(String args[]){
            SubStack ob = new SubStack();
            ob.push(1);
            ob.push(2);
            ob.push(3);

            while (!ob.isEmpty()) {
                System.out.println(ob.peek());
                ob.pop();
            }

        }
}
