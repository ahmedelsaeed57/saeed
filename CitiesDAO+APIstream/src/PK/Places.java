package PK;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Places {
    public static ArrayList<City> readCity(String path) {

        ArrayList<City> city=new ArrayList<>();
    try {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line=br.readLine();
        if(line!=null){
            line= br.readLine();
        }
        while(line!=null){
            String[] atrib=line.split(",");
            city.add(new City(atrib));
            line=br.readLine();
        }

    }catch (Exception e){}

     return city;
    }

    public static ArrayList<Country> readCountry(String path) {

        ArrayList<Country> country=new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line=br.readLine();
            if(line!=null){
                line= br.readLine();
            }
            while(line!=null){
                String[] atrib=line.split(",");
                country.add(new Country(atrib));
                line=br.readLine();
            }

        }catch (Exception e){System.out.println(e.toString());}

        return country;
    }

     }



