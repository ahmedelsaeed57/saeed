import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.Buffer;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter data ");  
        String word = "anyString";
        String fullString ="";
        while(!word.equals("stop")){
            word= sc.nextLine();
            fullString += word ;
            fullString += ",";
        }
        FileWriter writer = new FileWriter("file.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        for (String string : fullString.split(",")) {
            buffer.write(string+" ");
        }
        buffer.close();


        
}
}
