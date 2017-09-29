package three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2f {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        calc();
        sc.close();
    }
    public static void calc() {
        ArrayList<Object> res = new ArrayList<>();
        int len = sc.nextInt();
        for (int i = 0; i < len; i++) {
//            System.out.println(i);
            String ask = sc.next();
            switch (ask) {
                case "c":
//                    res.add(new Computer());
                    break;
                case "d":
                    res.add(new Double(sc.nextDouble()));
                    break;
                case "i":
                    res.add(new Integer(sc.nextInt()));
                    break;
                case "s":
                    res.add(sc.next());
                    break;
                default:
                    res.add(null);
            }
        }
        Collections.reverse(res);
        res.forEach(each -> {
            if (each != null)
                System.out.println(each);
        });
    }
}
