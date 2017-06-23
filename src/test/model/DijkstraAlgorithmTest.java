package test.model;

import static org.junit.jupiter.api.Assertions.*;

import findtheway.model.DijkstraAlgorithm;
import findtheway.model.Edge;
import findtheway.model.Graph;
import findtheway.model.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DijkstraAlgorithmTest {
    private List<Edge> edgeList;
    private List<Vertex> vertexList;
    private Graph graph;
    private DijkstraAlgorithm dijkstraAlgorithm;

    @BeforeEach
    void initTest() {
        edgeList = new ArrayList<>();
        vertexList = new ArrayList<>();
        for (int i=0; i < 10; i++) {
            Vertex vertex = new Vertex("Location_" + i);
            vertexList.add(vertex);
        }
        addEdgeToList(0,1, 100);
        addEdgeToList(1,2, 150);
        addEdgeToList(2,3, 200);
        addEdgeToList(3,4, 100);
        addEdgeToList(0,4, 3000);

        graph = new Graph(vertexList, edgeList);
        dijkstraAlgorithm = new DijkstraAlgorithm(graph);
    }

    @Test
    void testReturnTrueIfDijkstraAlgorithmCalculateCorrectly() {
        /* Test check travel from 'location_0' to 'location_4'
           cost of travel should equal:
               100 + 150 + 200 + 100 = 550
         */
        Integer expectedCost = 550;
        Vertex source = graph.getVertexes().get(0);
        Vertex target = graph.getVertexes().get(4);
        dijkstraAlgorithm.execute(source);
        assertTrue(expectedCost == dijkstraAlgorithm.getCheapest(target));
    }

    private void addEdgeToList(int sourceLocationNumber, int destinationLocationNumber, Integer cost) {
        Edge edge = new Edge(vertexList.get(sourceLocationNumber),
                             vertexList.get(destinationLocationNumber), cost);
        edgeList.add(edge);
    }
}