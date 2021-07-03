import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallestNumber {
    public static void main(String[] args) {
        int[] a = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(a, 2-1));
    }

    public static int kthSmallest(int[] a, int k){
//        PriorityQueue<Integer> pq = new PriorityQueue<>((b, c) -> c - b);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: a){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.element();
    }
}
