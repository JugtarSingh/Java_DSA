import java.util.Stack;
public class PushAtBottom {

    public static void pushAtBottom(Stack<Integer> stack,int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top=stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }
    public static void main(String args[]){
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Original Stack: " + stack);
        int elementToPush = 6;
        pushAtBottom(stack,elementToPush);
        System.out.println("Stack after pushing " +elementToPush +" at bottom:"+stack);
        // Output: Stack after pushing 6 at bottom: [6, 1, 2, 3, 4, 5]
    }
}
