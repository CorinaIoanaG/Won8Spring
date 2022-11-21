import java.util.List;

public class Country {
    private int id;
    private String name;
    private String capital;
    private long population;
    private long area;
    private String continent;
    private List<String> neighbours;

    public Country(int id, String name, String capital, long population, long area, String continent, List<String> neighbours) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public long getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }
}
