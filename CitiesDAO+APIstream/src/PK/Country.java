package PK;

public class Country {
    public String name;
    public String code;
    public int population;
    public int capital;
    public String continent;
    public Double surfaceArea;
    public Double gnp;

    public Country(String[] arr) {
        this.name = arr[1];
        this.code = arr[0];
        this.capital=Integer.parseInt(arr[6]);
        this.continent = arr[2];
        this.surfaceArea = Double.parseDouble(arr[3]);
        this.gnp = Double.parseDouble(arr[5]);
        this.population = Integer.parseInt(arr[4]);
    }
}
