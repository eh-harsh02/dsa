import java.util.LinkedList;
public class LinkedListCollection {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(65);
        list.addFirst(34);
        System.out.println(list);
        list.addLast(87);
        System.out.println(list);
        for(int elt : list) {
            System.out.print(elt + " -> ");
        }
        System.out.println("null");
        System.out.println(list.size());
        // list.removeFirst();
        // System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
