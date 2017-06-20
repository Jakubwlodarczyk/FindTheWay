package findtheway.model;

public class CitySet {

    private String firstCity;
    private String secondCity;
    private Integer cost;

    public CitySet(String firstCity, String secondCity, Integer cost) {
        this.firstCity = firstCity;
        this.secondCity = secondCity;
        this.cost = cost;
    }

    public String toString() {
        return String.format("%s -> %s : %s", firstCity, secondCity, cost);
    }
}
