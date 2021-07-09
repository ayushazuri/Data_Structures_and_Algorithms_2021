import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public LinkedList<Integer>[] list;
    public int v;

    public BFS(int v){
        this.v = v;
        list = new LinkedList[v];
        for(int i = 0;i < v;i++){
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        list[source].add(destination);
        list[destination].add(source);
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

    public void bsf(int source){
        boolean[] check = new boolean[list.length];
        Queue<Integer> queue = new LinkedList<>();
        check[source] = true;
        queue.add(source);
        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.println(v);

            for(int destination: list[v]){
                if(!check[destination]){
                    check[destination] = true;
                    queue.add(destination);
                }
            }
        }
    }
    public static void main(String[] args) {
        BFS graph = new BFS(4);
        graph.addEdge(0,1 );
        graph.addEdge(0,4 );
        graph.addEdge(1, 2 );
        graph.addEdge(1, 3);
        graph.addEdge(1, 4 );
        graph.addEdge(2, 3 );
        graph.addEdge(3, 4 );
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 3);

        graph.print();
        graph.bsf(0);
    }
}
