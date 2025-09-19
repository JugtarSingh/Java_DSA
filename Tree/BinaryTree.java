import java.util.*;
class BinaryTreeB {
    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    static class Info1{
        int diam;
        int ht;
        Info1(int diam, int ht){
            this.diam= diam;
            this.ht=ht;
        }
    }

    static class Info{
        Node node;
        int hd;

        Info(Node node,int hd){
            this.node =node;
            this.hd=hd;
        }
    }

    static class BinaryTree {

         int idx = -1;

        public Node Buildtree(int nodes[]) {
            ++idx;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = Buildtree(nodes);
            newNode.right = Buildtree(nodes);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }

        public static void levelorder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node CurrNode = q.remove();
                if (CurrNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(CurrNode.data + " ");
                    if(CurrNode.left!=null)
                    q.add(CurrNode.left);
                    if(CurrNode.right!=null)
                    q.add(CurrNode.right);
                }
            }
        }
        public static int  height(Node root){
            if(root==null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
        }
        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftCount= countNodes(root.left);
            int rightCount= countNodes(root.right);
            return leftCount+rightCount+1;
        }
        public static int sumNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftSum=sumNodes(root.left);
            int rightSum=sumNodes(root.right);
            return leftSum+rightSum+root.data;
        }
        public static int diameter1(Node root){
        if(root==null){
            return 0;
        }
        int leftDiam=diameter1(root.left);
        int leftHt=height(root.left);
        int rightDiam=diameter1(root.right);
        int rightHt=height(root.right);
        int selfDiam = leftHt+rightHt+1;
        return Math.max(Math.max(leftDiam,rightDiam),selfDiam);
    }
    public static Info1 diameter(Node root){
        if(root==null){
            return new Info1(0,0);
        }
        Info1 lInfo = diameter(root.left);
        Info1 rInfo = diameter(root.right);
        int finalDiam = Math.max(lInfo.diam,Math.max(rInfo.diam,lInfo.ht+rInfo.ht+1));
        int finalHt = Math.max(lInfo.ht,rInfo.ht)+1;
        return new Info1(finalDiam,finalHt);
    }
    public static boolean isIdentical(Node root, Node subroot){
        if(root == null && subroot==null){
            return true;
        }
        if(root ==null || subroot==null || root.data!=subroot.data){
            return false;
        }
        if(!isIdentical(root.left, subroot.left)){
            return false;
        }
        if(!isIdentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node rootNode  , Node subRootNode){
        if(rootNode==null){
            return false;
        }
        if(rootNode.data == subRootNode.data){
            if(isIdentical(rootNode, subRootNode)){
                return  true;
            }
        }
        return  isSubtree(rootNode.left, subRootNode) || isSubtree(rootNode.right, subRootNode);

    }
    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();
        int min=0,max=0;
        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else
                q.add(null);
            }
            else{
                if(!map.containsKey(curr.hd)){
                map.put(curr.hd , curr.node);
            }
            if(curr.node.left!=null){
                q.add(new Info(curr.node.left,curr.hd-1));
                min = Math.min(curr.hd-1,min);
            }
            if(curr.node.right!=null){
                q.add(new Info(curr.node.right, curr.hd+1));
                max= Math.max(max, curr.hd+1);
            }
            }
            
        }

        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+ " ");
        }

    }
}
    
    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        int subnodes[]={2,4,-1,-1,5,-1,-1};
        BinaryTree tree = new BinaryTree();
        BinaryTree subtree = new BinaryTree();
        Node subroot = subtree.Buildtree(subnodes);
        Node root = tree.Buildtree(nodes);
        // System.out.println(root.data);
        
        // tree.levelorder(root);
        // System.out.println("Height of the Binary Tree is : "+tree.height(root));
        // System.out.println("No of Node in the Binary tree is : "+ tree.countNodes(root));
        // System.out.println("Sum of Nodes in the Binary Tree: "+ tree.sumNodes(root));
        // System.out.println("Diameter of the Binary tree is : "+tree.diameter(root).ht);
        // tree.levelorder(subroot);
        // System.out.println("Is subtree : "+tree.isSubtree(root, subroot));

        tree.topView(root);
    }
}
