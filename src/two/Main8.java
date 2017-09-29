package two;

import java.util.ArrayList;
import java.util.Scanner;

public class Main8 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
//        while (in.hasNext())
            calc();
    }
    static void calc(){
        String ask = in.next();
        String fin[] = new String[10];
        ArrayList<String> target = new ArrayList<>();
        while (!ask.equals("!!end!!")) {
            target.add(ask);
            ask = in.next();
        }
        ask = in.nextLine();
        target.add("end");
        target.add(0, "begin");
//        System.out.println(target);
        fin[0]=target.toString();
        String check = in.nextLine();
//        System.out.println(target.contains(check));
//        System.out.println(target.indexOf(check));
        fin[1]=String.valueOf(target.contains(check));
        fin[2]=String.valueOf(target.indexOf(check));
        if (target.indexOf(check)==-1) {
//            System.out.println(-1);
            fin[3]="-1";
        }
        else {
//            System.out.println(target.size() - target.indexOf(back) - 1);
            fin[3]=String.valueOf(target.size() - target.indexOf(check) - 1);
        }

//        System.out.println(target.get(0));
        fin[4]=String.valueOf(target.get(0));
        target.remove(0);
//        System.out.println(target);
        fin[5]=target.toString();
        String insert = in.nextLine();
        target.set(1, insert);
//        System.out.println(target);
        fin[6]=target.toString();
        String inner = in.nextLine();
        ArrayList<String> form = new ArrayList<>();
        target.forEach(s -> {
            if (s.contains(inner)) form.add(s);
        });
//        System.out.println(form);
        fin[7]=form.toString();
        target.remove(inner);
//        System.out.println(target);
        fin[8]=target.toString();
        target.clear();
//        System.out.println(target + "," + target.size() + "," + target.isEmpty());
        fin[9]=String.valueOf(target + " " + target.size() + "," + target.isEmpty());
        for (String s : fin) {
            System.out.println(s);
        }
    }
}
