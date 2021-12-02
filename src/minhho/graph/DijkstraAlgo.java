package minhho.graph;

import java.util.*;

public class DijkstraAlgo {

    public int computePaths(Vertex sourceVertex) {

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
        return newDistance;
    }

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
