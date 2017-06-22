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

    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        Scanner scanner = getDatabaseScanner();
        for (Integer i = 0; scanner.hasNext(); i++) {
            String[] splitLine = scanner.nextLine().trim().split(" ");
            if (splitLine.length == 3) {
                Vertex startCity = new Vertex(i.toString(), splitLine[0]);
                Vertex destinationCity = new Vertex(i.toString(), splitLine[1]);
                edges.add(new Edge(i.toString(), startCity, destinationCity, Integer.parseInt(splitLine[2])));
            }
        }
        return edges;
    }

    public List<Vertex> getVertexes() {
        List<Vertex> vertexes = new ArrayList<>();
        List<String> citiesStringList = new ArrayList<>();
        Scanner scanner = getDatabaseScanner();
        for (Integer i = 0; scanner.hasNext(); i++) {
            String[] splitLine = scanner.nextLine().trim().split(" ");
            if (splitLine.length == 3) {
                citiesStringList.add(splitLine[0]);
                citiesStringList.add(splitLine[1]);
            }
        }
        Set<String> citiesStringSet = new HashSet<>(citiesStringList);
        Object[] vertexesStringList = citiesStringSet.toArray();
        for (Integer i = 0; i <vertexesStringList.length; i++ ) {
            vertexes.add(new Vertex(i.toString(), (String)vertexesStringList[i]));
        }
        return vertexes;
    }

    public Vertex getSource() {
        String vertexName = null;
        Vertex vertex = null;
        Scanner scanner = getDatabaseScanner();
        for (Integer i = 0; scanner.hasNext(); i++) {
            String[] splitLine = scanner.nextLine().trim().split(" ");
            if (splitLine.length == 2) {
                vertexName = splitLine[0];
            }
        }
        for (Vertex v : getVertexes()) {
            if (v.getName().equals(vertexName)) {
                vertex = v;
            }
        }
        return vertex;
    }

    public Vertex getTarget() {
        String vertexName = null;
        Vertex vertex = null;
        Scanner scanner = getDatabaseScanner();
        for (Integer i = 0; scanner.hasNext(); i++) {
            String[] splitLine = scanner.nextLine().trim().split(" ");
            if (splitLine.length == 2) {
                vertexName = splitLine[1];
            }
        }
        for (Vertex v : getVertexes()) {
            if (v.getName().equals(vertexName)) {
                vertex = v;
            }
        }
        return vertex;
    }
}