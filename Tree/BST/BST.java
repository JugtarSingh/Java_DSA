package BST;
import java.util.*;
public class BST {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    Node insert(Node root, int val){  //O(H)
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data < val){
            root.right = insert(root.right, val);
        }
        else if (root.data > val){
            root.left = insert(root.left, val);
        }
        return root;
    }
    boolean search(Node root ,int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        if(root.data > val){
            return search(root.left, val);
        }
        else{
            return search(root.right, val);
        }
    }
    // Inorder Successor is the left most Node of right subtree because we have to find the next minimum node;
    Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    Node delete (Node root , int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            // case 1 : when it is leaf Node that is Node which has no child
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2: Node with a single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            // case 3: Node with 2 child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    void inorder(Node root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    void inrange(Node root, int k1, int k2){
        if(root == null){
            return ;
        }
        if(root.data >= k1 && root.data <=k2){
            inrange(root.left,k1,k2);
            System.out.print(root.data+" ");
            inrange(root.right,k1,k2);
            
        }
        if(root.data < k1){
            inrange(root.right,k1,k2);
        }
        if(root.data > k2){
            inrange(root.left,k1,k2);
        }
    }
    void printPath(ArrayList<Integer> path){
        for (int i : path){
            System.out.print(i+"->");
        }
        System.out.println("null");
    }

    void rootToLeaf(Node root,ArrayList<Integer> path){
        if(root == null){
            return; 
        }
        path.add(root.data);
        if(root.left==null && root.right == null){
            printPath(path);
        }
        rootToLeaf(root.left,path);
        rootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    boolean isVaidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        return isVaidBST(root.left, min, root) && isVaidBST(root.right,root, max);
    }
    // it is just like swapping the left subtree with the right subtree for each single node 
    // this is my approach 
    void mirrorBST(Node root){
        if(root == null){
            return;
        }
        Node temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorBST(root.left);
        mirrorBST(root.right);
    }

    void levelOrderTraversal(Node root){
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
        BST obj = new BST();
        int values[]={8,5,3,1,4,6,10,11,14};
        int i;
        Node root = null;
        for (i=0;i<values.length;i++){
            root = obj.insert(root,values[i]);           
        }

        obj.mirrorBST(root);
        // obj.inorder(root);
        obj.levelOrderTraversal(root);


        // System.out.println();
        // root = obj.delete(root, 4);
        // obj.inorder(root);

        // obj.inrange(root, 2, 4);
        // if(obj.search(root, 6)){
        //     System.out.println("Found");
        // }
        // else{
        //     System.out.println("Not Found");
        // }
        // ArrayList<Integer> path = new ArrayList<>();
        // obj.rootToLeaf(root,path);
        // if(obj.isVaidBST(root,null,null)){
        //     System.out.println("BST is Valid");
        // }
        // else{
        //     System.out.println("BST is not valid");
        // }
    }
}
