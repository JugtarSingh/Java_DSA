public class SumTree extends BinaryTreeB {

    int sumTree(Node root){
        if(root == null){
            return 0;
        }

        int leftchild = sumTree(root.left);
        int rightchild = sumTree(root.right);

        int data = root.data;
        int left = (root.left == null)? 0 : root.left.data; 
        int right = (root.right == null)? 0 : root.right.data; 

        root.data =  left + right + leftchild + rightchild;
        return data;


    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        SumTree obj = new SumTree();
        Node root = tree.Buildtree(nodes);
        obj.sumTree(root);
        tree.levelorder(root);
    }
}
