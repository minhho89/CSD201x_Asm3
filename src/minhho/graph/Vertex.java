package minhho.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

    private String name;
    private boolean visited;
    private List<Edge> adjacencyList;
    private Vertex predecessor;
    private int distance = Integer.MAX_VALUE;   // distance from starting vertex

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }


    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void addNeighbor(Edge edge) {
        adjacencyList.add(edge);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getNeighbors() {
        return adjacencyList;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Integer.compare(this.distance, otherVertex.getDistance());
    }
}
