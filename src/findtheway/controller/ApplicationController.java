package findtheway.controller;

import findtheway.database.DatabaseConnection;
import findtheway.model.DijkstraAlgorithm;
import findtheway.model.Edge;
import findtheway.model.Graph;
import findtheway.model.Vertex;

import java.util.ArrayList;
import java.util.List;

public class ApplicationController {

    private DatabaseConnection databaseConnection;
    private Graph graph;
    private DijkstraAlgorithm dijkstraAlgorithm;
    private List<Edge> edgeList;
    private List<Vertex> vertexList;
    private Vertex source;
    private Vertex target;

    public void initApplication() {
        databaseConnection = new DatabaseConnection();
        vertexList = new ArrayList<>(databaseConnection.getVertexes());
        edgeList = new ArrayList<>(databaseConnection.getEdges(vertexList));
        graph = new Graph(vertexList, edgeList);
        dijkstraAlgorithm = new DijkstraAlgorithm(graph);
        source = databaseConnection.getSource(vertexList);
        target = databaseConnection.getTarget(vertexList);
    }

    public void calculatePath() {
        dijkstraAlgorithm.execute(source);
        dijkstraAlgorithm.getPath(target);
    }
}