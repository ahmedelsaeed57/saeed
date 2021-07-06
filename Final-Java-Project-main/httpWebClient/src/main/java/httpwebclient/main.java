
package httpwebclient;

import charttitanicapp.XChartExamples;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.*;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.*;


public class main {
    public static OkHttpClient client = new OkHttpClient();
    public static Gson gson = new Gson();
    
    
    
    public static void main(String[] args) throws IOException  {
        PieChart("CompanyName:",10,true,"http://localhost:8080/WuzzufApp/webresources/summary/company");
        BarChart("CompanyName:", "Count", "http://localhost:8080/WuzzufApp/webresources/summary/company");
        BarChart("TitleName:", "Count", "http://localhost:8080/WuzzufApp/webresources/summary/title");
        BarChart("SkillName:", "Count", "http://localhost:8080/WuzzufApp/webresources/summary/skills");

//        Type listType = new TypeToken<ArrayList<JsonObject>>(){}.getType();
//        Request request = new Request.Builder()
//            .url("http://localhost:8080/WuzzufApp/webresources/summary/data")
//            .build();
//
//        try{
//           Response response = client.newCall(request).execute();
//           String res = response.body().string();
////           System.out.println(response.body().string());
////
//           List<JsonObject> Jobs = gson.fromJson(res, listType);
//            //graphCompaniesCount(Jobs);
//           Jobs.stream().forEach(f->System.out.println(f.toString()));
////            getField(Jobs);
//            
////           Jobs.stream().forEach(f -> System.out.println(f.get)));
//        } catch (IOException ex) {
//            System.out.println("Ddd");
//            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        
//        
//        XChartExamples xChartExamples = new XChartExamples ();
        
        
    }
    


    public static void BarChart(String x , String y , String address) throws IOException
    {
        Type listType = new TypeToken<ArrayList<JsonObject>>(){}.getType();
        Request request = new Request.Builder()
            .url(address)
            .build();
        Response response = client.newCall(request).execute();
        String res = response.body().string();
        List<JsonObject> Jobs = gson.fromJson(res, listType);
        XChartExamples xChartExamples = new XChartExamples ();
        List<String> companyList = Jobs.stream().map(m -> m.get(x).getAsString()).limit(15).collect(Collectors.toList());
        List<Long> countList = Jobs.stream().map(m -> m.get(y).getAsLong()).limit(15).collect(Collectors.toList());
        CategoryChart chart = new CategoryChartBuilder ().width (1024).height (768).title ("Histogram").xAxisTitle (x).yAxisTitle (y).build ();
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);
        chart.addSeries (x+" "+y, companyList, countList);
        new SwingWrapper (chart).displayChart ();
    }
    
        public static void PieChart(String name, int Slice_No, boolean Others, String address)
            throws MalformedURLException, IOException {
        
        URL url = new URL(address);
        URLConnection request = url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser(); // from json
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); // Convert the input
                                                                                                // stream to a json
                                                                                                // element
        JsonArray rootobj = root.getAsJsonArray();

        List<String> Elements = rootobj.get(0).getAsJsonObject().keySet().stream().collect(Collectors.toList());

        List<String> ElementsNames = new ArrayList<>();
        List<Integer> Count = new ArrayList<>();

        for (int i = 0; i < Slice_No; i++) {
            ElementsNames.add(rootobj.get(i).getAsJsonObject().get(Elements.get(0)).getAsString());
            Count.add(rootobj.get(i).getAsJsonObject().get(Elements.get(1)).getAsInt());
        }

        PieChart pieChart = new PieChartBuilder().width(1024 * 2).height(768 * 2).title(name).build();
        // adding sets to chart
        for (int i = 0; i < Slice_No; i++) {
            pieChart.addSeries(ElementsNames.get(i), Count.get(i));
        }

        // Adding Others
        if (Others) {

            int Others_Count = 0;
            for (int i = Slice_No; i < rootobj.size(); i++) {
                Others_Count += rootobj.get(i).getAsJsonObject().get(Elements.get(1)).getAsInt();
            }
            pieChart.addSeries("Others", Others_Count);
        }

        // display chart
        JFrame frame = new SwingWrapper(pieChart).displayChart();
        javax.swing.SwingUtilities.invokeLater(() -> frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE));

    }
}
    
    

