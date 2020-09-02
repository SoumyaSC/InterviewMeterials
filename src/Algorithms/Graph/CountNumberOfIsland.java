package Algorithms.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNumberOfIsland {
    public void createGraph(Map<Integer, List<Edge>> graph, int from, int to){
        List<Edge> graphEdge = graph.get(from);

        if(graphEdge == null){
            graphEdge = new ArrayList<>();
        }
        graphEdge.add(new Edge(from, to));
        graph.put(from, graphEdge);
    }

    public int dfs(Map<Integer, List<Edge>> graph, boolean[] visited, int at){
        int count;
        if(visited[at]){
            return 0;
        }else{
            visited[at] = true;
            count = 1;

            List<Edge> graphNode = graph.get(at);
            if(graphNode!=null){
                for(Edge graphEdge : graphNode){
                    if(graphEdge.from == 1)
                        count = count + dfs(graph, visited, graphEdge.to);
                }
            }
        }
        return count;
    }

    public void printGraph(Map<Integer, List<Edge>> graph){
        for(Map.Entry mapEntry : graph.entrySet()){
            List<Edge> graphEdge = (List<Edge>) mapEntry.getValue();
            for(int i = 0; i< graphEdge.size(); i++){
                System.out.println(graphEdge.get(i).from + " " + graphEdge.get(i).to);
            }
        }
    }
}

//Not an ideal solution, does not take account of a matrix
class CountNumberOfIslandDriver{
    public static void main(String[] args) {
        int numberOfNodes = 5;
        Map<Integer, List<Edge>> graph = new HashMap<>(numberOfNodes);
        CountNumberOfIsland c = new CountNumberOfIsland();
        c.createGraph(graph, 0, 1);
        c.createGraph(graph, 0, 2);
        c.createGraph(graph, 1, 3);
        c.createGraph(graph, 3, 2);
        c.createGraph(graph, 2, 1);

        //c.printGraph(graph);

        int count = c.dfs(graph, new boolean[100], 0);
        System.out.println(count);
    }
}