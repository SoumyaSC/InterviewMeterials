package Algorithms.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Edge{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class CreateGraph {
    public void createDirectedEdgeGraph(Map<Integer, List<Edge>> graph, int from, int to, int cost){
        List<Edge> listEdge = graph.get(from);

        if(listEdge == null){
            listEdge = new ArrayList<>();
        }

        listEdge.add(new Edge(from, to, cost));
        graph.put(from, listEdge);
    }

    public void printGraph(Map<Integer, List<Edge>> graph){
        for (Map.Entry mapEntry : graph.entrySet()) {
            List<Edge> arrList = (List<Edge>) mapEntry.getValue();
            for(int i=0; i<arrList.size(); i++){
                System.out.println("from " + arrList.get(i).from + " to " + arrList.get(i).to
                + " with cost: " + arrList.get(i).cost);
            }
        }
    }

}

class CreateGraphDriver{
    public static void main(String[] args) {
        int numberOfNodes = 5;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        CreateGraph createGraph = new CreateGraph();

        /*  0
           / \
          /   \
         1- - -2
        /     /
       /   /
      3 /

         */
        createGraph.createDirectedEdgeGraph(graph, 0, 1, 10);
        createGraph.createDirectedEdgeGraph(graph, 0, 2, 20);
        createGraph.createDirectedEdgeGraph(graph, 1, 3, 30);
        createGraph.createDirectedEdgeGraph(graph, 3, 2, 5);
        createGraph.createDirectedEdgeGraph(graph, 2, 1, 7);

        createGraph.printGraph(graph);
    }
}