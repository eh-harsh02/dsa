import java.util.LinkedList;
import java.util.Queue;

public class binarySearchTree {
    Node root;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    binarySearchTree(){this.root=null;}

    public void inOrder(){ 
        inOrderTraversal(root);
        System.out.println();
    }

    public void desOrder(){
        desOrderTraversal(root);
        System.out.println();
    }
    public boolean search(int key){ //encapsulated code
        Node ans= searchKey(root, key);
        if(ans!=null) return true;
        else return false;
    }

    public void inOrderTraversal(Node root){
        if(root!=null){
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
        }
    }

    public void desOrderTraversal(Node root){  // print in descending order
        if(root!=null){
        desOrderTraversal(root.right);
        System.out.print(root.data+" ");
        desOrderTraversal(root.left);
        }
    }

    public void insert(int key){root = insertKey(root, key);} // encapsulated code

    public Node insertKey(Node root, int key){
        if(root == null) root = new Node(key);
        if(key<root.data) root.left=insertKey(root.left, key);
        else if(key>root.data) root.right=insertKey(root.right, key);
        return root;
        
    }

    public Node searchKey(Node root, int key){ // TC: lognbase2(Average Case)--Balanced Tree & O(n) ---skewed tree // SC: Same as TC
        if(root==null || key==root.data) return root;
        else if(key<root.data) return searchKey(root.left, key);
        else return searchKey(root.right, key);
    }

    public int findMin(Node root){
        int minVal = Integer.MAX_VALUE;
        Node temp=root;
        while(temp!=null){
            minVal=temp.data;
            temp=temp.left;
        }
        return minVal;
    }
    public void delete(int key){root = deleteKey(root, key);}
    public Node deleteKey(Node root, int key){
        if(root==null) return null;
        else{
            if(key<root.data) root.left=deleteKey(root.left, key);
            else if(key>root.data) root.right=deleteKey(root.right, key);
            else{ //when I found the key, now delete the key
                if(root.left==null) return root.right; // Right Child Exist
                else if(root.right==null) return root.left; // Left Child Exist
                else{//key contains both left and right children
                    int minValue = findMin(root.right);
                    root.data=minValue;
                    root.right=deleteKey(root.right, root.data);
                }
            }
        }
        return root;
    }

    public void BFS(){
        bfs(root);
    }

    public void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node deletedQueue = queue.poll();
            System.out.println(deletedQueue+" ");
            //explore
            if(deletedQueue.left!=null) queue.add(deletedQueue.left);
            if(deletedQueue.right!=null) queue.add(deletedQueue.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        binarySearchTree bst = new binarySearchTree();   // root = null
        bst.insert(60);
        bst.insert(30);
        bst.insert(130);
        bst.insert(100);
        bst.insert(170);
        bst.insert(10);
        bst.insert(50);
        bst.delete(10);
        bst.delete(200);
        bst.inOrder();
        bst.desOrder();
        System.out.println(bst.search(100));
        System.out.println(bst.search(200));
    }
}
