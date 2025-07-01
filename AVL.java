public class AVL {
    Node root;
    static class Node{
        int data;
        Node left, right;
        int height;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
            this.height = 1; 
        }
    }
    AVL() {this.root = null;}
    private int getHeight(Node root){
        if(root==null) return 0;
        return root.height;
    }
    private int getBalance(Node root){
        if(root==null) return 0;
        return getHeight(root.left) - getHeight(root.right);
    }

    public Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;
        y.left=x;
        x.right=T2;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right))+1;
        return y;
    }

    public Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(getHeight(y.left), getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
        return x;
    }

    public void insert(int key){
        root = insertData(root, key);
    }

    private Node insertData(Node root, int key){
        if(root == null) return new Node(key);
        else if(key<root.data) root.left=insertData(root.left, key);
        else if(key>root.data) root.right=insertData(root.right, key);
        else return root;
        // backtracking
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        int balance = getBalance(root);
        if(balance<-1 && key>root.data) return leftRotate(root);
        if(balance>1 && key<root.data) return rightRotate(root);
        if(balance>1 && key>root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance<-1 && key<root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public void inorder(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }
    }
    private Node minValueNode(Node root){
        Node current = root;
        while(current.left != null) current = current.left;
        return current;
    }

    public void delete(int key){
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key){
        if(root==null) return root;
        if(key<root.data) root.left = deleteNode(root.left, key);
        else if(key>root.data) root.right = deleteNode(root.right, key);
        else{
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else{
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(60);
        avl.inorder(); 
        System.out.println();
        avl.delete(30);
        avl.inorder();
        System.out.println();
        System.out.println("Root: " + avl.root.data);
        System.out.println("Height of the tree: " + avl.getHeight(avl.root));
        System.out.println("Balance Factor of root: " + avl.getBalance(avl.root));
    }
}
// rotation gives the constant time
// insertion takes o(log n) time
// height of the tree is always balanced
// height of the tree is always log n
// AVL tree is a self-balancing binary search tree
// where the difference between heights of left and right subtrees cannot be more than one for all nodes.