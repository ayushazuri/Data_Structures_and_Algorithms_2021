//Sort an array which is nearly sorted.

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KNearlySorted {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] a = {6, 5, 3, 2, 8, 10, 9};
        ArrayList<Integer> al = new ArrayList<>();
        int k = 3;

        for(int i: a){
            pq.add(i);
            if(pq.size() > k)
                al.add(pq.poll());
        }
        while(!pq.isEmpty()){
            al.add(pq.poll());
        }
        System.out.println(al);
    }


}
