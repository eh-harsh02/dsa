import java.util.PriorityQueue;

public class priorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = pq.size();
        // PriorityQueue is by default ---> min Heap [highest priority -- min element]
        pq.add(50);
        pq.add(60);
        pq.add(40);
        pq.add(30);
        pq.add(70);
        pq.add(20);
        pq.add(80);
        pq.add(10);
        pq.add(1);
        // priority --> peek();  
        System.out.println(pq.peek());
        // System.out.println("Deleted element: "+ pq.poll()); //  it will delete highest priority element
        // System.out.println(pq.peek());
        System.out.println(pq);
        for(int i=size-1; i>=0; i++){
            System.out.println(pq);
        }
    }
}
