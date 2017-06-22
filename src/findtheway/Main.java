package findtheway;


import findtheway.database.DatabaseConnection;
import findtheway.model.DijkstraAlgorithm;
import findtheway.model.Edge;
import findtheway.model.Graph;
import findtheway.model.Vertex;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        List<Vertex> vertexList = databaseConnection.getVertexes();
        List<Edge> edgeList = databaseConnection.getEdges();
        Vertex source = databaseConnection.getSource();
        Vertex target = databaseConnection.getTarget();

        Graph graph = new Graph(vertexList, edgeList);
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);

        System.out.println(vertexList);
        System.out.println(edgeList);
        System.out.println(source);
        System.out.println(target);

        dijkstraAlgorithm.execute(source);
        System.out.println(dijkstraAlgorithm.getPath(target));
    }
}
