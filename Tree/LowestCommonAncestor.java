import java.util.*;
class LCAncestor extends Tree{

    boolean getPath(Node root, Node n, ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n.data){
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    Node Ancestor1(Node root , Node n1 , Node n2){
        ArrayList<Node> p1 = new ArrayList<>();
        ArrayList<Node> p2 = new ArrayList<>();
        getPath(root,n1,p1);
        getPath(root,n2,p2);
        int i = 0;
        while(i<p1.size() && i<p2.size()){
            if(p1.get(i) != p2.get(i)){
                break;
            }
        }
        return p1.get(p1.size()-1);
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Tree ob = new Tree();
        Node root = ob.BuildTree(nodes);
        LCAncestor ob2 = new LCAncestor();
        System.out.println(ob2.Ancestor1(root,new Node(4),new Node(5)));
    }
}