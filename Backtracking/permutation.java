package Backtracking;

public class permutation {
    public static void findPermutations(String str ,String ans){
        // base case 
        if(str.length()==0)
        System.out.println(ans);

        // recursion
        for(int i=0;i<str.length();i++){
            char curr= str.charAt(i);
            String newStr= str.substring(0, i) + str.substring(i+1);
            findPermutations(newStr, ans+curr);
        }

        
    }
    public static void main(String args[]){
        findPermutations("abc", "");
    }
}
