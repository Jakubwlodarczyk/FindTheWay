package findtheway.model;

public class Edge {

    private Vertex begin, end;
    private Integer weight;

    private Edge() {}

    public Edge(Vertex begin, Vertex end, Integer weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }

    public String toString() {
        return begin.getName() + "-->" + end.getName() + "| cost: " + getWeight().toString();
    }

    public Vertex getBegin() {
        return begin;
    }

    public Vertex getEnd() {
        return end;
    }

    public Integer getWeight() {
        return weight;
    }
}

