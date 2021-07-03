import java.util.*;

public class frequencySort {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 2, 2, 2, 4, 3, 3, 3, 3, 3, 3};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: a){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        pq.addAll(map.entrySet());
        ArrayList<Integer> al = new ArrayList<>();

        while(!pq.isEmpty()){
            System.out.println(pq);
            Map.Entry<Integer, Integer> e = pq.poll();
            for (int i = 1; i<=e.getValue();i++)
                al.add(e.getKey());
        }
        System.out.println(al);
    }
}
