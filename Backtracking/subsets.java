package Backtracking;

public class subsets {
    public static void subset(String str,String s, int i){
        if(i==str.length())  // Base Case 
        {
            if(s  .length()==0)
            System.out.println("null");
            else
            System.out.println(s);
        }
        else
        {
            subset(str, s+str.charAt(i), i+1);  // Resursion Yes choice 
            subset(str, s, i+1);   // Backtracking    No Choice
         
        }
    }
    public static void main(String args[]){
        subset("abc","",0);
    }
    
}
