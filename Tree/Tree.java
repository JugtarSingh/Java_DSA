class Tree{
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
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
}