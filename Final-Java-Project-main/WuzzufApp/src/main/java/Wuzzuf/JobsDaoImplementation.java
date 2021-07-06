
package Wuzzuf;

import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.data.Tuple;
import smile.io.Read;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Comparator.comparing;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.tools.DocumentationTool.Location;
import smile.data.measure.NominalScale;

public class JobsDaoImplementation implements JobsDao{
    
    List<Jobs_Pojo> wuzzuf = new ArrayList<>();
    private DataFrame wuzzufDataFrame;
    private DataFrame aa;
    public JobsDaoImplementation(){}
    
    @Override
    public  DataFrame  readWuzzufFromCsv(String filename) {
        
       CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
        DataFrame df = null;
        try {
            df = Read.csv (filename, format);
            System.out.println(df.summary ());
            df = df.select ("Title", "Company", "Location", "Type", "Level","YearsExp","Country","Skills");
            //System.out.println(df.summary ());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace ();
        }
        wuzzufDataFrame = df;
       
        return df;

       }
    

    @Override
    public DataFrame getAllJobs() {
        return wuzzufDataFrame;
    }
    

    @Override
    public Jobs_Pojo createWuzzuf(String [] data) {
        String Title = data[0];
        String Company = data[1];
        String Location = data[2];
        String Type = data[3];
        String Level = data[4];
        String YearsExp = data[5];
        String Country = data[6];
        String Skills = data[7];

        return new Jobs_Pojo(Title, Company, Location, Type, Level, YearsExp, Country, Skills);
    }
 @Override
    public List<Jobs_Pojo> getwuzzufList() {
        assert wuzzufDataFrame != null;
        List<Jobs_Pojo> Wuzzuf = new ArrayList<> ();
        ListIterator<Tuple> iterator = wuzzufDataFrame.stream ().collect (Collectors.toList ()).listIterator ();
        while (iterator.hasNext ()) {
            Tuple t = iterator.next ();
            Jobs_Pojo p = new Jobs_Pojo();
            p.setTitle ((String) t.get ("Title"));
            p.setCompany ((String) t.get ("Company"));
            p.setLocation ((String) t.get ("Location"));
            p.setType ((String) t.get ("Type"));
            p.setLevel ((String) t.get ("Level"));
            p.setYearsExp ((String) t.get ("YearsExp"));
            p.setCountry ((String) t.get ("Country"));
            p.setSkills ((String) t.get ("Skills"));
           
            Wuzzuf.add (p);
        }
        return Wuzzuf;
    }
//    @Override
//    public DataFrame getAllWuzzuf() {
//        return wuzzufDataFrame;
//        
//    }
    
    @Override
public List<Jobs_Pojo> returnList(DataFrame x) {
        assert x != null;
        List<Jobs_Pojo> Wuzzuf = new ArrayList<> ();
        ListIterator<Tuple> iterator = x.stream ().collect (Collectors.toList ()).listIterator ();
        while (iterator.hasNext ()) {
            Tuple t = iterator.next ();
            Jobs_Pojo p = new Jobs_Pojo();
            p.setTitle ((String) t.get ("Title"));
            p.setCompany ((String) t.get ("Company"));
            p.setLocation ((String) t.get ("Location"));
            p.setType ((String) t.get ("Type"));
            p.setLevel ((String) t.get ("Level"));
            p.setYearsExp ((String) t.get ("YearsExp"));
            p.setCountry ((String) t.get ("Country"));
            p.setSkills ((String) t.get ("Skills"));
           
            Wuzzuf.add (p);
        }
        return Wuzzuf;
    }

@Override
public List<String> returnListSkills(DataFrame x) {
        assert x != null;
        List<String> Wuzzuf = new ArrayList<String> ();
        ListIterator<Tuple> iterator = x.stream ().collect (Collectors.toList ()).listIterator ();
        while (iterator.hasNext ()) {
            Tuple t = iterator.next ();
           
            Wuzzuf.add ( t.getString ("Skills"));
        }
        return Wuzzuf;
    }
//@Override
//public List<Integer> factorization(DataFrame x, String y)
//    {
//        String[] values = x.stringVector(y).distinct().toArray(new String[]{});
//        int[] numbers = x.stringVector(y).factorize(new NominalScale (values)).toIntArray();
//        return numbers;
//    }

@Override
public List<String> returnListYearsExp(DataFrame x) {
        assert x != null;
        List<String> Wuzzuf = new ArrayList<String> ();
        ListIterator<Tuple> iterator = x.stream ().collect (Collectors.toList ()).listIterator ();
        while (iterator.hasNext ()) {
            Tuple t = iterator.next ();
           
            Wuzzuf.add ( t.getString ("YearsExp"));
        }
        return Wuzzuf;
    }
}
