package findtheway.model;

import java.util.LinkedList;

public class Vertex {

    private String name;
    private LinkedList<Edge> edges = new LinkedList<>();

    private Vertex() {
    }

    public Vertex(String name) {
        this.name = name;
    }

    public String toString() {
        if(edges.size() == 0)
            return "?";

        StringBuilder out = new StringBuilder();
        for(Edge e : edges)
            out.append(e.toString()).append("\n");
        return out.toString();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void removeEdge(String i) {
        int e = edges.size()-1;
        while ( e >= 0 ) {
            if(edges.get(e).getEnd().getName().equals(i))
                edges.remove(e);
            e--;
        }
    }

    public void removeEdge(Vertex v) {
        removeEdge(v.getName());
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public Edge getEdge(String n) {
        for(Edge e : edges)
            if(e.getEnd().getName().equals(n))
                return e;
        return null;
    }

    public Edge getEdgeAt(int n) {
        if(n >= 0 && n < edges.size())
            return edges.get(n);
        else
            return null;
    }
}
