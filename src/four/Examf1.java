package four;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Examf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String result = null;
            if(line.equals("null"))
                result = extractBirthDate(null);
            else
                result = extractBirthDate(line);
            if(result==null)
                continue;
            System.out.println(result);
        }
        sc.close();
    }

    public static String extractBirthDate(String nextLine){
        if ((nextLine==null)||(nextLine.trim().length()!=18)) return null;
        else {
            String get = nextLine.trim().substring(6,14);
            return get.substring(0,4)+"-"+get.substring(4,6)+"-"+get.substring(6,8);
        }
    }
}
