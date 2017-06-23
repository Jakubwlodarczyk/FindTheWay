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
        List<Vertex> cheapestPath = dijkstraAlgorithm.getPath(target);
        Integer costs = dijkstraAlgorithm.getCheapest(target);
        System.out.println("The cheapest way to get from " + source.toString()
        + " to " + target.toString() + " is:");
        for (int i=0; i < cheapestPath.size(); i++) {
            if (i+1 < cheapestPath.size()) {
                System.out.print(cheapestPath.get(i).toString() + " -> ");
            } else {
                System.out.print(cheapestPath.get(i).toString());
            }
        }
        System.out.println("\nTotal cost is: " + costs);
    }
}