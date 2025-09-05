import java.util.*;
public class ValidParentheses {
    public static boolean isValid(String s){
        int i;
        Stack<Character> stack =new Stack<>();
        for(i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){   //opening
                stack.push(ch);
            }
            else{
                // closing
                if(stack.isEmpty()){
                    return false;
                }
                if((stack.peek()=='{' && ch=='}') //{}
                ||(stack.peek()=='[' && ch==']')  //[]
                ||(stack.peek()=='(' && ch==')')){//()
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
         if(stack.isEmpty()){
                return true;
            }
            else{
                return false;
            }
    }
    public static void main(String [] args){
        String s="{[()]}";
        System.out.println(isValid(s));
    }
}
