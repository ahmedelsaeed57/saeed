import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO implements Runnable {
    String[][] allData = new String[100][15];
    @Override
    public void run() {
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("pyramids.csv"));
            String line = br.readLine();
            do{
                line = br.readLine();
                if (line != null ) {
                    String[] attributes = line.split(",");
                    allData[counter] = attributes;
                    counter ++;
                }
            }
            while(line != null);
    
        // for(int i = 0 ; i<counter;i++){
        //         for (int j = 0; j < allData[i].length; j++) {
        //             System.out.print(allData[i][j] + " ");
        //         }
        //         System.out.println("");
        //     }
         } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public String[][] getAllData() {
        return allData;
    }
   
    public ArrayList<Pyramid> readPyramidsFromCsv(String filename){
        ArrayList<Pyramid> pyramids = new ArrayList<Pyramid>();
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            do{
                line = br.readLine();
                if (line != null ) {
                    //System.out.println(counter);
                    String[] attributes = line.split(",");
                    allData[counter] = attributes;
                    counter ++;

                }
            }
            while(line != null);
            System.out.println("counter = "+ counter);
        for(int i = 0 ; i<counter;i++){
            if(allData[i][7]==""){ //in case we ignored the missing data in height 
                continue;
            }
            pyramids.add(new Pyramid(allData[i][0],allData[i][2],allData[i][4],Double.parseDouble(allData[i][7])));
            System.out.println(i);
         } 
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return pyramids;
    }
}
