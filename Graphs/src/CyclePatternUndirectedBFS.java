import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CyclePatternUndirectedBFS {
    public LinkedList<Integer> list[];
    public int v;
    public CyclePatternUndirectedBFS(int v){
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

    class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean isCyclic(){
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        for(int i = 0;i < v;i++){
            if(!visited[i])
                if(checkForCycle(i, -1, visited))
                    return true;
        }
        return false;
    }

    private boolean checkForCycle(int node, int parent, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, parent));
        visited[node] = true;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            for(int i: list[temp.node]){
                if(!visited[i]){
                    q.add(new Pair(i, node));
                    visited[node] = true;
                }else if(i != parent)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CyclePatternUndirectedBFS graph = new CyclePatternUndirectedBFS(5);
        graph.addEdge(0,1 );
        graph.addEdge(0,4 );
        graph.addEdge(1, 2 );
        graph.addEdge(1, 3);
        graph.addEdge(1, 4 );
        graph.addEdge(2, 3 );
        graph.addEdge(3, 4 );
        graph.print();
        System.out.println(graph.isCyclic());

        CyclePatternUndirectedBFS g2 = new CyclePatternUndirectedBFS(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.print();

        System.out.println(g2.isCyclic());

    }
}
