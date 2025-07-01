public class trees {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int x){
            data=x;
            left=right=null;
        }
    }
    void preOrder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    void postOrder(Node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        System.out.println("Root: "+root.data);
        System.out.println("Left child: "+root.left.data);
        System.out.println("Right child: "+root.right.data);
        System.out.println("Left-Left GrandChild: "+root.left.left.data);
        System.out.println("Left-Right GrandChild: "+root.left.right.data);
        System.out.println("Right-Left GrandChild: "+root.right.left.data);
        System.out.println("Right-Right GrandChild: "+root.right.right.data);

        trees tr = new trees();
        System.out.print("PreOrder traversal: ");
        tr.preOrder(root);
        System.out.println();
        System.out.print("InOrder traversal: ");
        tr.inOrder(root);
        System.out.println();
        System.out.print("PostOrder traversal: ");
        tr.postOrder(root);
        System.out.println();
    }
}
