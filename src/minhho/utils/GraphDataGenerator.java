package minhho.utils;

import minhho.graph.Edge;
import minhho.graph.Graph;
import minhho.graph.Vertex;

import java.util.List;

public class GraphDataGenerator {

    public static Vertex a;
     static Vertex b ;
     static Vertex c;
     static Vertex d ;
     static Vertex e;
     static Vertex f;
     static Vertex g;

    public static Graph generate() {
        Graph graph = new Graph();

        a = new Vertex("A");
        b = new Vertex("B");
        c = new Vertex("C");
        d = new Vertex("D");
        e = new Vertex("E");
        f = new Vertex("F");
        g = new Vertex("G");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);

        graph.addNeighbor(a, new Edge(10, a, b));
        graph.addNeighbor(a, new Edge(8, a, g));

        graph.addNeighbor(b, new Edge(2, b, c));
        graph.addNeighbor(b, new Edge(10, b, d));
        graph.addNeighbor(b, new Edge(25, b, e));
        graph.addNeighbor(b, new Edge(80, b, f));

        graph.addNeighbor(c, new Edge(30, c, a));
        graph.addNeighbor(c, new Edge(8, c, d));
        graph.addNeighbor(c, new Edge(3, c, e));
        graph.addNeighbor(c, new Edge(20, c, f));

        graph.addNeighbor(d, new Edge(20, d, a));
        graph.addNeighbor(d, new Edge(5, d, f));
        graph.addNeighbor(d, new Edge(10, d, g));

        graph.addNeighbor(e, new Edge(4, e, d));


        graph.addNeighbor(f, new Edge(8, f, a));
        graph.addNeighbor(f, new Edge(5, f, g));

        graph.addNeighbor(g, new Edge(8, g, a));

        return graph;

    }

    public static void printAtoF() {
        Graph graph = generate();
        int totalDistance = Integer.MIN_VALUE;
        graph.computePaths(a);

        List<Vertex> results = graph.getShortestPath(f);

        for(Vertex v : results) {
            if (totalDistance < v.getDistance()) {
                totalDistance = v.getDistance();
            }
            System.out.print(v + " ");
        }

        System.out.println();
        System.out.println("Total distance from A to F = " + totalDistance);

    }

}
