public class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node findMax(){
        if(right != null){
            return right.findMax();
        }
        return this;
    }
}
