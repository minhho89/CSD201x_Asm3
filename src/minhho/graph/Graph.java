package minhho.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {

    private Stack<Vertex> stack;
    private List<Vertex> list;

    public Graph() {
        this.stack = new Stack<>();
        list = new ArrayList<>();
    }

    public void addNeighbor(Vertex v1, Vertex v2) {
        v1.addNeighbor(v2);
    }

    public void addVertex(Vertex v) {
        list.add(v);
    }

    public void dfs(List<Vertex> vertexList) {
        for(Vertex v : vertexList) {
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
            for(Vertex v : actualVertex.getNeighbors()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.add(v);
                }
            }
        }

    }

}
