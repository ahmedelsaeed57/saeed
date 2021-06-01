package PK;

import java.util.*;
import java.util.stream.Collectors;

// import jdk.vm.ci.code.site.Site;

public class Main {
    public static void main(String[] args) {
        String cityPath="cities.csv";
        String countryPath="countries.csv";

       // System.out.println("cities grouped by country :\n"+Places.cityClassifier(cityPath,countryPath)+"\n");
        ArrayList<Country> countries =Places.readCountry(countryPath);
        ArrayList<City> cities =Places.readCity(cityPath);
        
        for (Integer string : countries.stream().map((m)->m.population).toList()) {
            System.out.println(string);
        }
        System.out.println("\n avg = "+countries.stream().mapToInt((m)->m.population).average().getAsDouble());
        System.out.println("\n max = "+countries.stream().mapToInt((m)->m.population).max().getAsInt());
        System.out.println("\n map = "+cities.stream().collect(Collectors.groupingBy(City::getCode,Collectors.maxBy(City::compareTo))));

    }
}
