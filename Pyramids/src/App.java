import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        ArrayList<Pyramid> pyramids = (ArrayList<Pyramid>) pDAO.readPyramidsFromCsv("pyramids.csv");
        int i = 0;
        for (Pyramid p : pyramids) {
            System.out.println("#" + (i++) + " " + p.getPharao() + p.getModern_name() + p.getSite() + p.getHeight());
        }
        List<Pyramid> list = new ArrayList<Pyramid>(
                pyramids.stream().sorted(Comparator.comparingDouble(Pyramid::getHeight)).collect(Collectors.toList()));
        System.out.println("list of pyramids sorted wrt. height");
        for (Pyramid pr : list) {
            System.out.println("#" + " " + pr.getPharao() + pr.getModern_name() + pr.getSite() + pr.getHeight());
        }
        Map<Object, List<Pyramid>> mapFunc = pyramids.stream().collect(Collectors.groupingBy(p -> p.getSite()));
        mapFunc.forEach((name, p) -> System.out.format(" %s: %s\n", name, p.stream().count()));
    }
}
