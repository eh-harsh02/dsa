public class insertInterativelyInBST {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public Node insertIterative(Node root, int element) {
        if (root == null) return new Node(element);

        Node current = root;
        while (true) {
            if (element < current.data) {
                if (current.left == null) {
                    current.left = new Node(element);
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(element);
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }

    // Optional: Inorder traversal to verify insertion
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        insertInterativelyInBST tree = new insertInterativelyInBST();

        tree.root = tree.insertIterative(tree.root, 50);
        tree.root = tree.insertIterative(tree.root, 30);
        tree.root = tree.insertIterative(tree.root, 70);
        tree.root = tree.insertIterative(tree.root, 20);
        tree.root = tree.insertIterative(tree.root, 40);
        tree.root = tree.insertIterative(tree.root, 60);
        tree.root = tree.insertIterative(tree.root, 80);

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);  // Should print: 20 30 40 50 60 70 80
    }
}
