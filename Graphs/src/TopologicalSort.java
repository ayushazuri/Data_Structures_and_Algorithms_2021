//Directed Graph

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    public LinkedList<Integer> list[];
    public int v;
    public TopologicalSort(int v){
        this.v = v;
        list = new LinkedList[v];
        for(int i = 0;i < v;i++){
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        list[u].add(v);
    }

    public ArrayList<Integer> TopoSort(){
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(visited, false);
        for(int i = 0;i < v;i++){
            if(!visited[i])
                findTopoSort(i, stack, visited);
        }

        ArrayList<Integer> topoSort = new ArrayList<>();
        while(!stack.isEmpty()){
            topoSort.add(stack.pop());
        }
        return topoSort;
    }

    public void findTopoSort(int source, Stack<Integer> stack, boolean[] visited){
        visited[source] = true;
        for(int i: list[source]){
            if(!visited[i])
                findTopoSort(i, stack, visited);
        }
        stack.push(source);
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

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        graph.print();

        ArrayList<Integer> topoSort = graph.TopoSort();
        System.out.println(topoSort);


    }
}
