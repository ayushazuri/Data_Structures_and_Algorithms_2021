//Find k closest element to x in an array

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestElement {
    public static void main(String[] args) {
        int[] a = {5, 6, 7, 8, 9};
        int k = 3;
        int x = 7;

        int[] difference = new int[a.length];
        for(int i=0;i<a.length;i++){
            difference[i] = Math.abs(a[i] - x);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
               return o2.getDiff() - o1.getDiff();
            }
        });
        for(int i=0;i<difference.length;i++){
            pq.add(new Pair(i, difference[i]));
            if(pq.size() > k)
                pq.poll();
        }

        while(!pq.isEmpty()){
            System.out.println(a[pq.poll().getIndex()]);
        }

    }
}

class Pair{
    Integer index;
    Integer diff;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getDiff() {
        return diff;
    }

    public void setDiff(Integer diff) {
        this.diff = diff;
    }

    Pair(int index, int diff){
        this.index = index;
        this.diff = diff;
    }
}
