package BST;
import java.util.*;
public class MergeBST {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static ArrayList<Integer> merge(ArrayList<Integer> a1 , ArrayList<Integer> a2){
        int i=0,j=0;
        ArrayList<Integer> a3 = new ArrayList<>();
         while(i<a1.size() && j<a2.size()){
                if(a1.get(i) == a2.get(j)){
                    a3.add(a1.get(i));
                    i++;
                    j++;
                }
                else if(a1.get(i) < a2.get(j)){
                    a3.add(a1.get(i));
                    i++;
                }
                else
                {
                    a3.add(a2.get(j));
                    j++;
                }
            }
            while(i < a1.size() ){
                a3.add(a1.get(i++));
            }
            while(j < a2.size() ){
                a3.add(a2.get(j++));
            }
            return a3;
    }
    static void inorder(Node root , ArrayList<Integer> a){
        if(root == null){
            return;
        }
        inorder(root.left , a);
        a.add(root.data);
        inorder(root.right , a);
    }
    static Node BuildBST(ArrayList<Integer> a, int min, int max){
        if(min > max){
            return null;
        }
        int mid = (min + max)/2;
        Node newNode = new Node(a.get(mid));
        newNode.left = BuildBST(a,min,mid-1);
        newNode.right = BuildBST(a,mid+1,max);
        return newNode;

    }
    static Node mergeBST(Node root1 , Node root2){
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        inorder(root1 , a1);
        inorder(root2 , a2);
        ArrayList<Integer> a3 = merge( a1,a2);
        Node root = BuildBST(a3,0,a3.size()-1);
        return root;
    }
    static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static void main(String args[]){
        Node root1 = new Node(2);
        root1.right = new Node(4);
        root1.left = new Node (1);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root3 = mergeBST(root1, root2);
        levelOrder(root3);
    }
}
