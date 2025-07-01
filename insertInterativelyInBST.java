public class insertInterativelyInBST {
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
    public Node insertIterative(Node root, int element){
        if(root==null) return new Node(element);
        Node current = root;
        while (true) { 
            if(element<current.data){
                if(current.left == null){
                    current.left = new Node(element);
                    break;
                }
                current = current.left;
            }else{
                if(current.right==null){
                    
                }
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
