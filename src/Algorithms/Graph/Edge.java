package Algorithms.Graph;

public class Edge {
    int from;
    int to;
    int cost;

    public Edge(int from, int to){
        this.from = from;
        this.to = to;
    }

    public Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
