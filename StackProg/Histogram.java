import java.util.*;
public class Histogram {

    public static void maxArea(int arr[]){
        int i,currArea,maxArea=0,width;
        int nsr[]=new int[arr.length];
        int nsl[]=new int [arr.length];
        // Next smaller right
        Stack<Integer> s = new Stack<>();
        for(i=arr.length-1;i>=0;i--){

            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }
            else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // Next smaller left 
        s = new Stack<>();
        for(i=0;i<arr.length;i++){

            while(!s.isEmpty() && arr[i] <=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        // current area j-i-1= nsr[i]-nsl[i]-1

        for(i=0;i<arr.length;i++){
            width=nsr[i]-nsl[i]-1;
            currArea=arr[i]*width;
            maxArea=Math.max(currArea,maxArea);
        }
        System.out.println("Maximum Area in the Histogram is: "+maxArea);
    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        maxArea(arr);
    }
}
