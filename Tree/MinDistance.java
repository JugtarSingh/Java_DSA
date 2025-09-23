public class MinDistance extends LCA {

    int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);
        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        else if(leftDist == -1){
            return rightDist + 1;
        }
        else{
            return leftDist + 1;
        }
    }

    int minDistance(Node root, int n1, int n2){
        Node lca = LCAncestor2(root, n1, n2);
        int dist1 = lcaDist(lca , n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.Buildtree(nodes);
        MinDistance obj = new MinDistance();
        System.out.println("Minimum distance between 2 nodes: "+obj.minDistance(root, 4, 6));
    }
}
