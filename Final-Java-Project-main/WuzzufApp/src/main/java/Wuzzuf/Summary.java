
package Wuzzuf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import smile.data.DataFrame;
import smile.data.Tuple;
import smile.data.vector.IntVector;

@Path("summary")
public class Summary {

    @Context
    private UriInfo context;

    public Summary() {
    }

        JobsDao jobsDao = new JobsDaoImplementation();
        DataFrame Wuzzuf = jobsDao.readWuzzufFromCsv("D:\\Ahmed Projects\\ITI\\java\\final project\\Wuzzuf_Jobs.csv");

   @GET
    @Path("/data")
    @Produces("application/json")
    public List<Jobs_Pojo> getHtml()
    {
//        JobsDao jobsDao = new JobsDaoImplementation();
//        DataFrame Wuzzuf = jobsDao.readWuzzufFromCsv("D:\\Ahmed Projects\\ITI\\java\\final project\\Wuzzuf_Jobs.csv");
         
        return jobsDao.getwuzzufList();
    }
    
    @GET
    @Path("/structure")
    @Produces("application/json")
    public String getStructure()
    {

            //return(Wuzzuf.select("Title", "Company", "Location", "Type", "Level","YearsExp","Country","Skills").summary().toString());
         //return Wuzzuf.structure().stream().collect(Collectors.toList());
        return Wuzzuf.structure().toString();

   }
    
    @GET
    @Path("/summary")
    @Produces("application/json")
    public List<Tuple> getSumm()
    {

            //return(Wuzzuf.select("Title", "Company", "Location", "Type", "Level","YearsExp","Country","Skills").summary().toString());
         return Wuzzuf.summary().stream().collect(Collectors.toList());
        
   }
    
    
    @GET
    @Path("/removeNull")
    @Produces("application/json")
    public List<Jobs_Pojo> removeNull()
    {
         Wuzzuf = Wuzzuf.omitNullRows();
         return jobsDao.returnList(Wuzzuf);
        
   }
    
    @GET
    @Path("/removeDup")
    @Produces("application/json")
    public List<Jobs_Pojo> removeDup()
    {
        //return jobsDao.returnList(Wuzzuf).removeIf(e->!seen.add(e.getCompany()));
       //return Wuzzuf.stream().filter(i -> Collections.frequency(numbers, i) >1).collect(Collectors.toList());
         return jobsDao.returnList(Wuzzuf).stream().distinct().collect(Collectors.toList());
   }
    
    @GET
    @Path("/company")
    @Produces("application/json")
    public List<Map<String, Object>> company()
    {
       Map<String,Long> x ;
        
       x= jobsDao.returnList(Wuzzuf).stream().collect(Collectors.groupingBy(Jobs_Pojo::getCompany,Collectors.counting()));
        return x.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(f->{
         Map<String,Object> j = new HashMap<String,Object>();
         j.put("CompanyName:", f.getKey()); 
         j.put("Count", f.getValue());
         return j;
     }).collect(Collectors.toList());    

    }
    
    
    @GET
    @Path("/comapnydetails")
    @Produces("application/json")
    public Map<String, List<Jobs_Pojo>> companydetails()
    {
        return jobsDao.returnList(Wuzzuf).stream().collect(Collectors.groupingBy(Jobs_Pojo::getCompany,Collectors.toList()));
     }
    
    
    @GET
    @Path("/title")
    @Produces("application/json")
    public List<Map<String, Object>> title()
    {
        Map<String,Long> x ;
    
       x= jobsDao.returnList(Wuzzuf).stream().collect(Collectors.groupingBy(Jobs_Pojo::getTitle,Collectors.counting()));
      return x.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(f->{
         Map<String,Object> j = new HashMap<String,Object>();
         j.put("TitleName:", f.getKey()); 
         j.put("Count", f.getValue());
         return j;
     }).collect(Collectors.toList());    

    }
 
    
    @GET
    @Path("/countries")
    @Produces("application/json")
    public List<Map<String, Object>> country()
    {
        Map<String,Long> x ;
       x = jobsDao.returnList(Wuzzuf).stream().collect(Collectors.groupingBy(Jobs_Pojo::getCountry,Collectors.counting()));
//  //       x.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(a -> sortedMap.put(a.getKey(), a.getValue()));
     return x.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(f->{
         Map<String,Object> j = new HashMap<String,Object>();
         j.put("Country Name:", f.getKey()); 
         j.put("Count", f.getValue());
         return j;
     }).collect(Collectors.toList());    

    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("/skills")
    @Produces("application/json")
    public List<Map<String, Object>> skills()
    {
       
        List<String> x ;
     
     x= jobsDao.returnListSkills(Wuzzuf).stream().flatMap(s -> Arrays.stream(s.split(","))).map(f->f.trim().toUpperCase()).collect(Collectors.toList());
    
     return x.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(f->{
         Map<String,Object> j = new HashMap<String,Object>();
         j.put("SkillName:", f.getKey()); 
         j.put("Count", f.getValue());
         return j;
     }).collect(Collectors.toList());
  
}
    
    
    
//    @GET
//    @Path("/years")
//    @Produces("application/json")
//    public void YearsExp()
//    {
//       
//        List<String> x ;
//    //return jobsDao.returnListYearsExp(Wuzzuf).stream().replaceAll("([a-z])", "").collect(Collectors.toSet());
//     jobsDao.returnListYearsExp(Wuzzuf).forEach(s -> s.replaceAll("([a-z],[A-Z])", ""));
//     Wuzzuf.merge(IntVector.of("new", encodeCategory(Wuzzuf,"yearsExp")));
//
//  
//}
}