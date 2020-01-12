import java.util.Comparator;
import java.util.PriorityQueue;

class MedianClass {
    public static void main(String[] args) {
        // MaxHeap
        PriorityQueue<Integer> lowHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        PriorityQueue<Integer> highHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        int[] stream = new int[]{67,2,36,14,9,54,120,2};
        for(int n: stream) {
            // Size is equal
            
            lowHeap.add(n);
            highHeap.add(lowHeap.poll());
     
            if(lowHeap.size()<highHeap.size()){
                lowHeap.add(highHeap.poll());
            }
        }

        System.out.println(lowHeap);
        System.out.println(highHeap);

        if(lowHeap.size() > highHeap.size()){
            System.out.println(lowHeap.peek());
        }else {
            System.out.println((highHeap.peek()+lowHeap.peek())/2.0);
        }
        
    }
}