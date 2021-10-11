import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrismMST {
    static class Node
    {
        private int v;
        private int weight;
        Node(int _v, int _w) { v = _v; weight = _w; }

        Node() {}

        int getV() { return v; }
        int getWeight() { return weight; }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        primsAlgo(adj, n);
        primsAlgoBetter(adj, n);
    }

    private static void primsAlgo(ArrayList<ArrayList<Node>> adj, int n) {

        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);

        boolean[] mst = new boolean[n];
        Arrays.fill(mst, false);

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        key[0] = 0;

        for(int i=0;i<n-1;i++){
            int max = Integer.MAX_VALUE, maxInd = 0;
            for(int j=0;j<n;j++){
                if(!mst[j] && key[j] < max){
                    max = key[j];
                    maxInd = j;
                }
            }

            mst[maxInd] = true;

            for(Node v: adj.get(maxInd)) {
                if(!mst[v.getV()] && v.getWeight() < key[v.getV()]){
                    key[v.getV()] = v.getWeight();
                    parent[v.getV()] = maxInd;
                }
            }
        }

        for (int i=1;i<n;i++){
            System.out.println(parent[i] + " " + i);
        }

    }

    private static void primsAlgoBetter(ArrayList<ArrayList<Node>> adj, int N) { //nlogn - logn because of priority queue
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mstSet[] = new boolean[N];
        for(int i = 0;i<N;i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Comparator<>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        key[0] = 0;
        parent[0] = -1;
        pq.add(new Node(0, key[0]));

        while(!pq.isEmpty()) {
            int u = pq.poll().getV();
            mstSet[u] = true;

            for(Node it: adj.get(u)) {
                if(!mstSet[it.getV()] && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }
        }

        for(int i = 1;i<N;i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
}
