import java.util.*;
public class NextGreater {
    public static void main(String args[]){
        int arr[]={6,8,0,1,3};
        int nextgreater[]=new int[arr.length];
        Stack<Integer> stack =new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextgreater[i]=-1;
            }
            else {
                nextgreater[i]=arr[stack.peek()];
            }
            // push in stack
            stack.push(i);
        }

        for(int i=0;i<nextgreater.length;i++){
            System.out.print(nextgreater[i]+" ");
        }
    }
}
