public class BasicLinkedListOperations {

    // ========= Singly Linked List =========
    static class SLLNode {
        int data;
        SLLNode next;

        SLLNode(int data) {
            this.data = data;
        }
    }

    static SLLNode insertAtBeginningSLL(SLLNode head, int data) {
        SLLNode newNode = new SLLNode(data);
        newNode.next = head;
        return newNode;
    }

    static SLLNode insertAtEndSLL(SLLNode head, int data) {
        SLLNode newNode = new SLLNode(data);
        if (head == null) return newNode;
        SLLNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    static SLLNode deleteFromBeginningSLL(SLLNode head) {
        return (head == null) ? null : head.next;
    }

    static SLLNode deleteFromEndSLL(SLLNode head) {
        if (head == null || head.next == null) return null;
        SLLNode temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
        return head;
    }

    static void traverseSLL(SLLNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // ========= Doubly Linked List =========
    static class DLLNode {
        int data;
        DLLNode next, prev;

        DLLNode(int data) {
            this.data = data;
        }
    }

    static DLLNode insertAtBeginningDLL(DLLNode head, int data) {
        DLLNode newNode = new DLLNode(data);
        newNode.next = head;
        if (head != null) head.prev = newNode;
        return newNode;
    }

    static DLLNode insertAtEndDLL(DLLNode head, int data) {
        DLLNode newNode = new DLLNode(data);
        if (head == null) return newNode;
        DLLNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    static DLLNode deleteFromBeginningDLL(DLLNode head) {
        if (head == null) return null;
        head = head.next;
        if (head != null) head.prev = null;
        return head;
    }

    static DLLNode deleteFromEndDLL(DLLNode head) {
        if (head == null || head.next == null) return null;
        DLLNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.prev.next = null;
        return head;
    }

    static void traverseForwardDLL(DLLNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    static void traverseBackwardDLL(DLLNode tail) {
        while (tail != null) {
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
        System.out.println();
    }

    // ========= Circular Singly Linked List =========
    static class CSLLNode {
        int data;
        CSLLNode next;

        CSLLNode(int data) {
            this.data = data;
        }
    }

    static CSLLNode insertAtEndCSLL(CSLLNode head, int data) {
        CSLLNode newNode = new CSLLNode(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        CSLLNode temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
        return head;
    }

    static CSLLNode deleteFromBeginningCSLL(CSLLNode head) {
        if (head == null || head.next == head) return null;
        CSLLNode temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = head.next;
        return head.next;
    }

    static void traverseCSLL(CSLLNode head) {
        if (head == null) return;
        CSLLNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // ========= Circular Doubly Linked List =========
    static class CDLLNode {
        int data;
        CDLLNode next, prev;

        CDLLNode(int data) {
            this.data = data;
        }
    }

    static CDLLNode insertAtEndCDLL(CDLLNode head, int data) {
        CDLLNode newNode = new CDLLNode(data);
        if (head == null) {
            newNode.next = newNode.prev = newNode;
            return newNode;
        }
        CDLLNode last = head.prev;
        last.next = newNode;
        newNode.prev = last;
        newNode.next = head;
        head.prev = newNode;
        return head;
    }

    static CDLLNode deleteFromBeginningCDLL(CDLLNode head) {
        if (head == null || head.next == head) return null;
        CDLLNode last = head.prev;
        head = head.next;
        head.prev = last;
        last.next = head;
        return head;
    }

    static void traverseCDLL(CDLLNode head) {
        if (head == null) return;
        CDLLNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // ========= Test Main =========
    public static void main(String[] args) {
        System.out.println("Singly Linked List:");
        SLLNode sll = null;
        sll = insertAtBeginningSLL(sll, 3);
        sll = insertAtEndSLL(sll, 5);
        traverseSLL(sll);
        sll = deleteFromEndSLL(sll);
        traverseSLL(sll);

        System.out.println("\nDoubly Linked List:");
        DLLNode dll = null;
        dll = insertAtEndDLL(dll, 10);
        dll = insertAtBeginningDLL(dll, 5);
        traverseForwardDLL(dll);
        dll = deleteFromBeginningDLL(dll);
        traverseForwardDLL(dll);

        System.out.println("\nCircular Singly Linked List:");
        CSLLNode csll = null;
        csll = insertAtEndCSLL(csll, 1);
        csll = insertAtEndCSLL(csll, 2);
        traverseCSLL(csll);
        csll = deleteFromBeginningCSLL(csll);
        traverseCSLL(csll);

        System.out.println("\nCircular Doubly Linked List:");
        CDLLNode cdll = null;
        cdll = insertAtEndCDLL(cdll, 8);
        cdll = insertAtEndCDLL(cdll, 9);
        traverseCDLL(cdll);
        cdll = deleteFromBeginningCDLL(cdll);
        traverseCDLL(cdll);
    }
}
