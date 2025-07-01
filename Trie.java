public class Trie {
    Node root;
    static class Node {
        Node[] children;
        boolean eow; // end of word
        Node(){
            this.children=new Node[26];
            for(int i=0; i<26; i++){
                children[i]=null;
            }
            this.eow=false;
        }
    }

    public void insert(String word){
        int N = word.length(); Node temp=root;
        for(int i=0; i<N; i++){
            int index = word.charAt(i)-'a';
            if(temp.children[index]==null){
                temp.children[index] = new Node();
                temp=temp.children[index];
            }
        }
        temp.eow = true;
    }

    Trie() {
        this.root=new Node();
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
    }
}
