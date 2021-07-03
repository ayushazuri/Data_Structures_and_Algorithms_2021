import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 2, 2, 2, 4, 3, 3, 3, 3, 3, 3};
        int k = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: a){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            pq.add(e);
            if(pq.size() > k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll().getKey());
        }
    }
}
