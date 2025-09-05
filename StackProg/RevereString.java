import java.util.*;
public class RevereString {
    public static void main(String[]args){
        String reverse="";
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a String:");
        String str=sc.nextLine();
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
        }
        System.out.println("Original String: "+str);
        while(!stack.isEmpty()){
            reverse+=stack.peek();
            stack.pop();
        }
        System.out.println("Reversed String: " +reverse);
    }
}
