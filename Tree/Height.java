public class Height extends BinaryTreeB {
    
    int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight+1 , rightHeight+1);
    }
    public static void main(String args[]){
        BinaryTree obj = new BinaryTree();
        int nodes[] = { 1, 2, 4,-1,-1,5,-1,-1,3,6,-1,-1,7,9,-1,-1,-1};
        Node root = obj.Buildtree(nodes);
        Height tree = new Height();
        obj.levelorder(root);
        System.out.println("Height of the Binary Tree is "+tree.height(root));
    }
}
