import java.util.Scanner;
public class App {
    public static int[] calcN(String s )
        {
            int [] arr  = new int[4];
            for(int i = 0 ; i<s.split("\\.").length;i++)
            {
                arr[i] = Integer.parseInt(s.split("\\.")[i]);
            }
        return arr;
        }
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter an ip: ");  
        String str= sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            System.out.println(calcN(str)[i]);
        }
        
    }
}
