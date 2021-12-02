package minhho.graph;

public class Edge {

    private int weight;
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(int weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

}
