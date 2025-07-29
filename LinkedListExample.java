public class LinkedListExample {
    Node head;
    
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // add - First, Last
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;

        }
        currNode.next = newNode;
    }
    //delete - first, last
    public void deleteFirst() {
        if(head == null) {
            System.out.println("The list is empty");
            return;
        }
        head = head.next;
    }
    public void deleteLast() {
        if(head == null) {
            System.out.println("The list is empty");
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    // print
    public void printList(){
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + "-> ");
            currNode = currNode.next;
        }
        System.out.println("NULL ");
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        LinkedListExample list = new LinkedListExample();
        list.addLast(89);
        list.addLast(35);
        list.addLast(29);
        list.addLast(15);
        list.addLast(12);
        list.printList();
        list.addFirst(23);
        list.printList();
        list.deleteFirst();
        list.printList();
        list.deleteLast();
        list.printList();
    }
}
