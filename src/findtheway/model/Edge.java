package findtheway.model;


public class Edge  {
    private final Vertex source;
    private final Vertex destination;
    private final int cost;

    public Edge(Vertex source, Vertex destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
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