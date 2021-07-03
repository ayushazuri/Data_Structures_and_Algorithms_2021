import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestNumber {
    public static void main(String[] args) {
        int[] a = {7, 10, 4, 3, 20, 15};
        int k = 2;
        System.out.println(kthLargest(a, k));
    }

    public static int kthLargest(int[] a, int k){
//        PriorityQueue<Integer> pq = new PriorityQueue<>((b, c) -> c - b);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i: a){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.element();
    }
}
