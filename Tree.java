import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    Node root;

    private Node insert(Node curr, int data){
        if(curr == null){
            curr = new Node(data);
        }
        if(data < curr.data){
            curr.left = insert(curr.left, data);
        }
        else if(data > curr.data){
            curr.right = insert(curr.right,data);
        }
        return curr;
    }
    public void add(int data){
        this.root = insert(this.root,data);
    }
    //Preorder, inorder, postorder
    private void preorderPrivate(Node curr){
        if(curr == null){
            return;
        }
        System.out.println(curr.data);
        preorderPrivate(curr.left);
        preorderPrivate(curr.right);
    }
    public void preoder(){
        preorderPrivate(this.root);
    }

    //inorder
    private void inorderPrivate(Node curr){
        if(curr == null){
            return;
        }
        inorderPrivate(curr.left);
        System.out.println(curr.data);
        inorderPrivate(curr.right);
    }
    public void inorder(){
        inorderPrivate(this.root);
    }

    //postorder
    private void postorderPrivate(Node curr){
        if(curr == null){
            return;
        }
        postorderPrivate(curr.left);
        postorderPrivate(curr.right);
        System.out.println(curr.data);
    }
    public void postorder(){
       postorderPrivate(this.root);
    }


    // Find
    private boolean findPrivate(Node curr, int x){
        if(curr == null){
            return false;
        }
        while(curr != null){
            if(curr.data == x){
                return true;
            }
            if(x < curr.data){
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        return false;
    }
    public boolean find(int x){
        return findPrivate(this.root,x);
    }
    //Find recursively
    private boolean findR(Node curr, int x){
        if(curr == null){
            return false;
        }
        if(x == curr.data){
            return true;
        }
        if(x < curr.data){
            return findR(curr.left,x);
        }
        else{
            return findR(curr.right,x);
        }
    }
    public boolean findRecursive(int x){
        return findR(this.root,x);
    }

    //Breadth First Search
    private void bfsPrivate(Node curr){
        Queue<Node> a = new LinkedList<>();
        a.add(curr);
        while(!a.isEmpty()){
            curr = a.remove();
            System.out.println(curr.data + " ");
            if(curr.left != null){
                a.add(curr.left);
            }
             if(curr.right != null){
                a.add(curr.right);
            }
        }
    }
    public void bfs(){
        bfsPrivate(this.root);
    }

    //Max
    private int maxPrivate(Node curr){
        if(curr == null){
            return -1; //default
        }
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.data;
    }
    public int max(){
        return maxPrivate(this.root);
    }
    //Max recursive
    private int maxR(Node curr){
        if(curr.right != null){
            return maxR(curr.right);
        }
        return curr.data;
    }
    public int maxRecursive(){
        return maxR(this.root);
    }

    //Delete

    private void swap(Node a, Node b){
        Node tmp = a;
        a = b;
        b = tmp;
    }

    private Node deletePrivate(Node curr, int x){
        if(curr == null){
            return null;
        }
        //First step find your element
        if(x < curr.data){
            curr.left = deletePrivate(curr.left,x);
        }
        if(x > curr.data){
            curr.right = deletePrivate(curr.right,x);
        }
        //I find it
        else{
            if(curr.left == null && curr.right == null){
                curr = null;
            }
            else if(curr.left == null || curr.right == null){
                curr = curr.left == null ? curr.right : curr.left;
            }
            else{
                //bug not fix
                /*
                Node tmpNode = curr.left.findMax();
                swap(tmpNode,curr);
               curr.left = deletePrivate(curr.left,tmpNode.data);
               */



            }

        }
        return curr;
    }
    public void delete(int x){
        deletePrivate(this.root,x);
    }

    //Inverse tree
    private Node invertTreeR(Node curr) {
        if (curr == null) {
            return null;
        }
        /*
        Node right = invertTree(curr.right);
        Node left = invertTree(curr.left);
        curr.left = right;
        curr.right = left;
         */
        Node tmp = curr.left;
        curr.left = curr.right;
        curr.right = tmp;
        invertTreeR(curr.left);
        invertTreeR(curr.right);
        return curr;
    }
    public void invertTree(){
        invertTreeR(this.root);
    }



}
