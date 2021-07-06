/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.List;



public interface JobsDao {
    public DataFrame getAllJobs();
    public  DataFrame  readWuzzufFromCsv(String filename);
    public Jobs_Pojo createWuzzuf(String [] data);
    public List<Jobs_Pojo> getwuzzufList() ;
//    public DataFrame getAllWuzzuf();
    public List<Jobs_Pojo> returnList(DataFrame x);
    public List<String> returnListSkills(DataFrame x);
    //public List<Integer> factorization(DataFrame x, String y);
    public List<String> returnListYearsExp(DataFrame x) ;
}
    

