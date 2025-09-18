import java.util.*;
public class Kth_Level {    
    class Node {
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int  idx = -1;
    Node BuildTree(int nodes[]){
        ++idx;
        if(nodes[idx] == -1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = BuildTree(nodes);
        newNode.right = BuildTree(nodes);
        return newNode;
    }
    public  void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
    }

    void Kth(Node root , int level , int K){
        if(root == null){
            return;
        }
        if(level == K){
            System.out.print(root.data + " ");
            return;
        }
        Kth(root.left,level+1,K);
        Kth(root.right,level+1,K);
    }

    void levelorder_Traversal(Node root , int K){
        Queue<Node> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                // System.out.println();
                ++level;
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(level == K){
                    System.out.print(currNode.data + "  ");
                }
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }    
        }
     }
    public static void main(String args[]){
        int nodes[] = { 1, 2, 4, 9,-1,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};
        Kth_Level tree = new Kth_Level();
        Node root = tree.BuildTree(nodes);
        // tree.preorder(root);
        // tree.levelorder_Traversal(root, 3);
        tree.Kth(root , 1 ,3);
        
    }
}
