import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathDirectedWt {
    public final int v;
    LinkedList<Pair>[] list;
    public ShortestPathDirectedWt(int v){
        this.v = v;
        list = new LinkedList[v];
        for(int i = 0;i < v;i++){
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, Pair v){
        list[u].add(v);
    }

    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public void print(){
        for(int i =0;i<list.length;i++){
            System.out.print(i + "=>");
            for(int j = 0;j<list[i].size();j++){
                System.out.print(" " + list[i].get(j).first +" with wt "+list[i].get(j).second+ " => ");
            }
            System.out.println();
        }
    }

    public void topologicalSort(int node, Stack<Integer> stack, boolean[] visited) {
        visited[node] = true;
        for(Pair i: list[node]){
            if(!visited[i.first])
                topologicalSort(i.first, stack, visited);
        }
        stack.push(node);
    }

    public void shortestPathWt(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        for(int i = 0;i < v;i++){
            if(!visited[i])
                topologicalSort(i, stack, visited);
        }

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while(!stack.isEmpty()){
            int node = stack.peek();
            if(dist[node] != Integer.MAX_VALUE){
                for(Pair i: list[node]){
                    if(dist[node] + i.second < dist[i.first])
                        dist[i.second] = dist[node] + i.second;
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        ShortestPathDirectedWt g = new ShortestPathDirectedWt(6);
        g.addEdge(0, new Pair(1, 2));
        g.addEdge(0,new Pair(4, 1));
        g.addEdge(1, new Pair(2, 3));
        g.addEdge(4, new Pair(2, 2));
        g.addEdge(2, new Pair(3, 6));
        g.addEdge(4, new Pair(5, 4));
        g.addEdge(5, new Pair(3, 1));
//        g.print();
        g.shortestPathWt();
    }
}
