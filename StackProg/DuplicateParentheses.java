import java.util.*;
public class DuplicateParentheses{
    public static boolean isDuplicate(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){  // closing
                int count=0;
                while(stack.peek()!='('){
                    count++;
                    stack.pop();
                }
                if(count<1){
                    return true;  // duplicate
                }else{
                    stack.pop();
                }
            }
            else{ // opening 
                stack.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args){
        String str="(a+b)";
        System.out.println(isDuplicate(str));
    }
}