public class prac {
    static class Node{
        int data;
        Node left, right;
        public  Node(int val){
            data=val;
            left=right=null;
        }
    }
    
    public static void main(String[] args){
        Node root = new Node(35);
        root.left = new Node(76);
        root.right = new Node(54);
        root.left.left = new Node(65);
    }
}
