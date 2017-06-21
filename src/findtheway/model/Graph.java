package findtheway.model;

import java.util.LinkedList;
import java.util.Objects;

public class Graph {

    private LinkedList<Vertex> vertices = new LinkedList<>();
    private Integer vertexCount;

    public Graph() {
        vertexCount = 0;
    }

    public Graph(Integer n) {
        for(Integer i=0; i<n; i++)
            vertices.add(new Vertex(i.toString()));
        vertexCount = n;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for(Vertex v : vertices)
            if(v != null && !Objects.equals(v.toString(), ""))
                out.append(v.toString()).append("\n");
        return out.toString();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
        vertexCount++;
    }

    public LinkedList<Vertex> getVertices() {
        return vertices;
    }
}