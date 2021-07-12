import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirected {
    public LinkedList<Integer> list[];
    public int v;
    public ShortestPathUndirected(int v){
        this.v = v;
        list = new LinkedList[v];
        for(int i = 0;i < v;i++){
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        list[u].add(v);
        list[v].add(u);
    }

    public void print(){
        for(int i =0;i<list.length;i++){
            System.out.print(i + "=>");
            for(int j = 0;j<list[i].size();j++){
                System.out.print(list[i].get(j) + "=>");
            }
            System.out.println();
        }
    }

    public int shortestPath(int source, int destination){
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(source);
        dist[source] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i: list[node]){
                if(dist[node] + 1 < dist[i]){
                    dist[i] = dist[node] + 1;
                    queue.add(i);
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        return dist[destination];
    }
    public static void main(String[] args) {
        ShortestPathUndirected g = new ShortestPathUndirected(9);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(2, 6);
        g.addEdge(6, 7);
        g.addEdge(6, 8);
        g.addEdge(7, 8);

//        g.print();

        System.out.println(g.shortestPath(0, 6));
    }
}
