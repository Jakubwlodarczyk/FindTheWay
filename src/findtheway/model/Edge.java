package findtheway.model;


public class Edge  {
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private final int cost;

    public Edge(String id, Vertex source, Vertex destination, int cost) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    Vertex getDestination() {
        return destination;
    }

    Vertex getSource() {
        return source;
    }

    int getWeight() {
        return cost;
    }

    @Override
    public String toString() {
        return source + " " + destination + " " + cost;
    }
}