package minhho.utils;

import minhho.graph.Graph;
import minhho.graph.Vertex;

public class GraphDataGenerator {

    public static void generate() {
        Graph graph = new Graph();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);

        graph.addNeighbor(a, b);
        graph.addNeighbor(a, c);
        graph.addNeighbor(a, d);
        graph.addNeighbor(a, e);
        graph.addNeighbor(a, f);
        graph.addNeighbor(a, g);

        graph.addNeighbor(b, c);
        graph.addNeighbor(b, d);
        graph.addNeighbor(b, e);
        graph.addNeighbor(b, f);
        graph.addNeighbor(b, g);

        graph.addNeighbor(c, d);
        graph.addNeighbor(c, e);
        graph.addNeighbor(c, f);
        graph.addNeighbor(c, g);

        graph.addNeighbor(f, g);

    }






}
