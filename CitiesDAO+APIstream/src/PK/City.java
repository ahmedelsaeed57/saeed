package PK;

import java.util.ArrayList;

public class City implements Comparable<City>{
    public String name;
    public String code;
    public int id;
    public Integer population;

    public City(String[] arr) {
        this.name = arr[1];
        this.code = arr[3];
        this.id = Integer.parseInt(arr[0]);
        this.population = Integer.parseInt(arr[2]);
    }

    @Override
    public String toString() {
        return "City=" + name ;
    }



    @Override
    public int compareTo(City o) {
        return this.population.compareTo(o.population);
    }

    public Integer getPopulation() {
        return population;
    }
    public String getCode() {
        return code;
    }
}
