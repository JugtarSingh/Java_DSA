import java.util.*;

class LCA extends BinaryTreeB{
    boolean getPath(Node root, ArrayList<Node> p, int n){
        if(root == null){
            return false;
        }
        p.add(root);

        if(root.data == n){
            return true;
        }
        boolean foundLeft = getPath(root.left, p, n);
        boolean foundRight = getPath(root.right, p, n);
        if(foundLeft || foundRight){
            return true;
        }
        p.remove(root);
        return false;
    }
    Node LCAncestor1(Node root, int n1, int n2){
        ArrayList<Node> p1 = new ArrayList<>();
        ArrayList<Node> p2 = new ArrayList<>();
        getPath(root, p1, n1);
        getPath(root, p2, n2);
        int i=0;
        while(i<p1.size() && i<p2.size()){
            if(p1.get(i).data != p2.get(i).data){
                break;
            }
            i++;
        }
        return p1.get(i-1);
    }
    Node LCAncestor2(Node root,int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }    
        Node leftlca = LCAncestor2(root.left, n1, n2);
        Node rightlca = LCAncestor2(root.right, n1, n2);
        if(leftlca == null){
            return rightlca;
        }
        if(rightlca == null){
            return leftlca;
        }
        return root;
    }
    int Kth_Ancestor(Node root, int n , int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int left = Kth_Ancestor(root.left, n, k);
        int right = Kth_Ancestor(root.right, n, k);
        if(left == -1 && right == -1){
            return -1;
        }
        int max = Math.max(left , right);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        LCA obj = new LCA();
        Node root = tree.Buildtree(nodes);
        // ArrayList<Node> list = new ArrayList<>();
        // obj.getPath(root, list, 7);
        // for(Node i : list){
        //     System.out.println(i.data);
        // }

        // System.out.println(obj.LCAncestor2(root, 6, 7).data);

        obj.Kth_Ancestor(root, 7, 2);
    }
}