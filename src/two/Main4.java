package two;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            ArrayList<ArrayList<String>> save = new ArrayList<>();
            for (int i = 1; i < n+1; i++) {
                ArrayList<String> line = new ArrayList<>();
                for (int j = 1; j < i+1; j++) {
                    String s = i+"*"+j+"="+i*j;
                    line.add(s);
                }
                save.add(line);
            }
            for (int i = 0; i < n; i++) {
                for (int i1 = 0; i1 < save.get(i).size(); i1++) {
                    if (i1==save.get(i).size()-1) System.out.println(save.get(i).get(i1));
                    else {
                        System.out.printf("%-7s",save.get(i).get(i1));
                    }
                }
            }
            System.out.println(save);
        }
    }
}
