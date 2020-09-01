package Algorithms.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EdgeGraph{
    int from;
    int to;
    int cost;

    public EdgeGraph(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class DFSGraph {
    public void createGraph(Map<Integer, List<EdgeGraph>> graph, int from, int to, int cost){
        List<EdgeGraph> node = graph.get(from);
        if(node == null){
            node = new ArrayList<>();
        }
        node.add(new EdgeGraph(from, to, cost));
        graph.put(from, node);
    }

    public int depthFirstSearch(int at, boolean[] visited, Map<Integer, List<EdgeGraph>> graph){
        int count;
        if(visited[at]){
            return 0;
        }else{
            visited[at] = true;
            count = 1;

            List<EdgeGraph> node = graph.get(at);
            if(node!=null){
                for (EdgeGraph edgeGraph : node){
                    System.out.println("from " + edgeGraph.from + " to " + edgeGraph.to);
                    count = count + depthFirstSearch(edgeGraph.to, visited, graph);
                }
            }
            return count;
        }
    }
}

class DFSGraphDriver{
    public static void main(String[] args) {
        int numberOfNodes = 5;
        Map<Integer, List<EdgeGraph>> graph = new HashMap<>();

        DFSGraph dfsGraph = new DFSGraph();
        dfsGraph.createGraph(graph, 0, 1, 10);
        dfsGraph.createGraph(graph, 0, 2,20);
        dfsGraph.createGraph(graph, 1, 3, 30);
        dfsGraph.createGraph(graph, 3, 2, 5);
        dfsGraph.createGraph(graph, 2, 1, 7);

        int count = dfsGraph.depthFirstSearch(0, new boolean[numberOfNodes], graph);
        System.out.println(count);
    }
}