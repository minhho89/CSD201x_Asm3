package minhho.graph;

import java.util.*;

public class Graph {

    private Stack<Vertex> stack;
    private List<Vertex> list;

    public Graph() {
        this.stack = new Stack<>();
        list = new ArrayList<>();
    }

    public void addNeighbor(Vertex v, Edge e) {
        v.addNeighbor(e);
    }

    public void addVertex(Vertex v) {
        list.add(v);
    }

    public void dfs() {
        for(Vertex v : list) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsHelper(v);
            }
        }
    }

    private void dfsHelper(Vertex rootVertex) {

        stack.add(rootVertex);
        rootVertex.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            System.out.println(actualVertex);

            // check all the neighbors
            for(Edge edge : actualVertex.getNeighbors()) {

                Vertex v = edge.getTargetVertex();

                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.add(v);
                }
            }
        }

    }

    public void computePaths(Vertex sourceVertex) {

        sourceVertex.setDistance(0);        // Starting vertex
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(); // Sorted queue according to distance
        priorityQueue.add(sourceVertex);
        int newDistance = 0;

        while (!priorityQueue.isEmpty()) {

            Vertex actualVertex = priorityQueue.poll(); // Remove the head of the queue

            for(Edge edge : actualVertex.getAdjacencyList()) {

                Vertex v = edge.getTargetVertex();

                newDistance = actualVertex.getDistance() + edge.getWeight();

                if (newDistance < v.getDistance()) {
                    priorityQueue.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }

        }

    }

    // DijkstraAlgo
    public List<Vertex> getShortestPath(Vertex targetVertex) {
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        // Loop with backtrack order
        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
            shortestPathToTarget.add(vertex);
        }

        Collections.reverse(shortestPathToTarget);

        return shortestPathToTarget;
    }

}
