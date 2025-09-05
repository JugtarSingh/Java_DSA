package ArrayList;

import java.util.*;  // import java.util.ArrayList;
public class list{
    public static void main(String[] args) {
        // Java Collection FrameWork
        //Classname objectname =new Classname();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        // Add operation -)(1)
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        System.out.println(arr1);
        
        // Get Operation -O(1)
        int element=arr1.get(3);
        System.out.println(element);

        // Remove Operation -O(n)
        // arr1.remove(2);
        // System.out.println(arr1);

        //Set Operation -O(n)
        // arr1.set(2, 10);
        // System.out.println(arr1);

        // Contain element -O(n)
        // System.out.println(arr1.contains(11));
        // System.out.println(arr1.contains(1));
        
        // Another form of add operation
        arr1.add(1,100);
        System.out.println(arr1);

        // Size of an Array list
        System.out.println(arr1.size());
    }
}