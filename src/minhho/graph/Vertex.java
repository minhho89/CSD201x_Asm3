package minhho.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Vertex> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public void addNeighbor(Vertex vertex) {
        adjacencyList.add(vertex);
    }

    public void showNeighbors() {
        for (Vertex v : adjacencyList) {
            System.out.println(v);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
