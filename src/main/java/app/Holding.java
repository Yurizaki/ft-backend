package app;


public class Holding {
    
    private String name;
    private String yearChange;
    private String weight;

    public Holding(String name, String yearChange, String weight) {
        super();

        this.name = name;
        this.yearChange = yearChange;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getYearChange() {
        return yearChange;
    }
}
