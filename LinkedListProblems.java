class LinkedListProblems {

    // Basic singly linked list node
    static class Node {
        int data;
        Node next;
        Node random; // For advanced problems like clone with random
        Node child;  // For flattening multilevel linked list

        Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
            this.child = null;
        }
    }

    // 1. Reverse a Linked List
    static Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 2. Detect Cycle (Floyd's Cycle Detection)
    static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // 3. Find Middle of Linked List
    static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 4. Check if Linked List is Palindrome
    static boolean isPalindrome(Node head) {
        Node mid = findMiddle(head);
        Node rev = reverse(mid);
        while (rev != null) {
            if (head.data != rev.data) return false;
            head = head.next;
            rev = rev.next;
        }
        return true;
    }

    // 5. Merge Two Sorted Lists
    static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.data < b.data) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

    // 6. Remove N-th Node from End
    static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy, slow = dummy;
        for (int i = 0; i <= n; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    // 7. Find Intersection Point
    static Node getIntersection(Node a, Node b) {
        Node p1 = a, p2 = b;
        while (p1 != p2) {
            p1 = (p1 == null) ? b : p1.next;
            p2 = (p2 == null) ? a : p2.next;
        }
        return p1;
    }

    // 8. Clone Linked List with Random Pointer
    static Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        Node dummy = new Node(0), copyCurr = dummy;
        curr = head;
        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return dummy.next;
    }

    // 9. Rotate List by k
    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) return head;

        int len = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k %= len;
        if (k == 0) return head;

        tail.next = head; // Circular
        for (int i = 0; i < len - k; i++) tail = tail.next;
        Node newHead = tail.next;
        tail.next = null;
        return newHead;
    }

    // 10. Flatten Multilevel Linked List
    static Node flatten(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node temp = curr.next;
                curr.next = curr.child;
                Node tail = curr.child;
                while (tail.next != null) tail = tail.next;
                tail.next = temp;
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        // You can test your methods here by creating sample linked lists
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(a);

        Node rev = reverse(a);
        System.out.println("Reversed List:");
        printList(rev);
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
