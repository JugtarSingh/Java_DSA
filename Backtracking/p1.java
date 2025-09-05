package Backtracking;

public class p1 {

    public static void Backtrack(int arr[],int i){
        if(i==arr.length) // Base case
        {
            printArr(arr);
            return;
        }
        arr[i]=i+1;
        Backtrack(arr,i+1);  // Recursion
        arr[i]-=2;    // backtracking step.
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int arr[]=new int [5];
        Backtrack(arr,0);
        printArr(arr);
    }
    
}
