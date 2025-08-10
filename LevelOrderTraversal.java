import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node{
        Node left, right;
        int data;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

public class LevelOrderTraversal {
    public static Node insert(Node root, int data) {
        if(root == null) return new Node(data);
        if(data <= root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }
    
    public static void levelOrder(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); 

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);

        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // number of nodes
        Node root = null;
        for(int i = 0; i < n; i++) {
            int data = scn.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
        scn.close();
    }
}
