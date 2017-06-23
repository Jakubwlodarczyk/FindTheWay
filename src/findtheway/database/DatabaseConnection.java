package findtheway.database;

import findtheway.model.Edge;
import findtheway.model.Vertex;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class DatabaseConnection {

    private Scanner getDatabaseScanner() {
        try {
            String fileName = "src/findtheway/database.txt";
            return new Scanner(new File(fileName));
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return null;
    }

    public List<Edge> getEdges(List<Vertex> vertexList) {
        List<Edge> edges = new ArrayList<>();
        Scanner scanner = getDatabaseScanner();
        Vertex startCity = null;
        Vertex destinationCity = null;
        while (scanner.hasNext()) {
            String[] splitLine = scanner.nextLine().trim().split(" ");
            if (splitLine.length == 3) {
                for (Vertex vertex : vertexList) {
                    if (vertex.getName().equals(splitLine[0])) {
                        startCity = vertex;
                    }
                    if (vertex.getName().equals(splitLine[1])) {
                        destinationCity = vertex;
                    }
                }
                edges.add(new Edge(startCity, destinationCity, Integer.parseInt(splitLine[2])));
            }
        }
        return edges;
    }

    public List<Vertex> getVertexes() {
        List<Vertex> vertexes = new ArrayList<>();
        List<String> citiesStringList = new ArrayList<>();
        Scanner scanner = getDatabaseScanner();
        while (scanner.hasNext()) {
            String[] splitLine = scanner.nextLine().trim().split(" ");
            if (splitLine.length == 3) {
                citiesStringList.add(splitLine[0]);
                citiesStringList.add(splitLine[1]);
            }
        }
        Set<String> citiesStringSet = new HashSet<>(citiesStringList);
        Object[] vertexesStringList = citiesStringSet.toArray();
        for (Object aVertexesStringList : vertexesStringList) {
            vertexes.add(new Vertex((String) aVertexesStringList));
        }
        return vertexes;
    }

    public Vertex getSource(List<Vertex> vertexList) {
        String vertexName = null;
        Vertex vertex = null;
        Scanner scanner = getDatabaseScanner();
        while (scanner.hasNext()) {
            String[] splitLine = scanner.nextLine().trim().split(" ");
            if (splitLine.length == 2) {
                vertexName = splitLine[0];
            }
        }
        for (Vertex v : vertexList) {
            if (v.getName().equals(vertexName)) {
                vertex = v;
            }
        }
        return vertex;
    }

    public Vertex getTarget(List<Vertex> vertexList) {
        String vertexName = null;
        Vertex vertex = null;
        Scanner scanner = getDatabaseScanner();
        while (scanner.hasNext()) {
            String[] splitLine = scanner.nextLine().trim().split(" ");
            if (splitLine.length == 2) {
                vertexName = splitLine[1];
            }
        }
        for (Vertex v : vertexList) {
            if (v.getName().equals(vertexName)) {
                vertex = v;
            }
        }
        return vertex;
    }
}