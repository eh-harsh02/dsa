public class maxHeap {
    // size <= maxSize (capacity)
    int heap[]; int size; int maxSize;

    public maxHeap(int capacity) {
        this.maxSize=capacity;
        this.size=0; // no element exist in the heap
        this.heap=new int [maxSize];
    }
    //Helper Methods
    public int left(int index){return (2*index)+1;}  // Binary indexing
    public int right(int index){return (2*index)+2;} 
    public int parent(int index){return (index-1)/2;}
    public void swap(int fPos, int sPos){
        int temp;
        temp=heap[fPos];
        heap[fPos]=heap[sPos];
        heap[sPos]=temp;
    }
    public int peek() {return heap[0];}
    // utility methods
    public void insert(int key){
        int pos = size;
        heap[pos] = key;
        while(heap[pos]>heap[parent(pos)]){
            swap(pos, parent(pos));
            pos = parent(pos);
        }
        size +=1;
    }
    public void display(){
        for(int i=0; i<size/2; i++){
            System.out.print("Parent- "+heap[i]+"\t");
            System.out.print("Left- "+heap[left(i)]+"\t");
            System.out.print("Right- "+heap[right(i)]+"\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        maxHeap MaxHeap = new maxHeap(500);   // heap[500], maxSize = 500, size = 0;
        MaxHeap.insert(10);
        MaxHeap.insert(20);
        MaxHeap.insert(30);
        MaxHeap.insert(100);
        MaxHeap.insert(90);
        MaxHeap.insert(70);
        System.out.println(MaxHeap.peek());
        // display
        for(int i=0; i<MaxHeap.size; i++){
            System.out.print(MaxHeap.heap[i]+" ");
        }
        System.out.println();
    }
}
