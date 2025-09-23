package BST;
import java.util.*;

class ArrayToBST extends BST{
    
    // The approach is just like the binary search where we have to find out the mid element 
    // Here also we are finding out the mid element of the array and inserting it into a new node 
    Node sortedArrayToBST(int arr[], int min, int max){
        if(min > max){
            return null;
        }
        int mid = (min+max)/2;
        Node newNode = new Node(arr[mid]);
        newNode.left = sortedArrayToBST(arr,min,mid-1);
        newNode.right = sortedArrayToBST(arr,mid+1,max);
        return newNode;
    }


    public static void main(String args[]){
    //    int a[] = {3,5,6,8,11,12};
    //    ArrayToBST obj = new ArrayToBST();
    //    Node root = obj.sortedArrayToBST(a,0,a.length-1);
    //    obj.inorder(root);

    //  Node root = new Node(8);
    // root.left = new Node(6);
    // root.left.left = new Node(5);

    }
}