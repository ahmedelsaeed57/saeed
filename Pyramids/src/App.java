import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
       PyramidCSVDAO pDAO = new PyramidCSVDAO();
       ArrayList<Pyramid> pyramids = (ArrayList<Pyramid>) pDAO.readPyramidsFromCsv("pyramids.csv");
       int i = 0 ;
       for(Pyramid p : pyramids){
           System.out.println("#"+(i++)+" "+p.getPharao()+p.getModern_name()+p.getSite()+p.getHeight());
       }
    }
}
