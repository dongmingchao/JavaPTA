package four;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine())
            calc(in.nextLine());
    }
    private static void calc(String in){
        System.out.print('[');
        char[] got = in.toCharArray();
        int number=0,word=0,non=0;
        for (int i = 0; i < got.length; i++) {
            if (Character.isDigit(got[i])) number++;
            else if (Character.isAlphabetic(got[i])) word++;
            else non++;
            if (i==got.length-1) System.out.print(got[i]);
            else System.out.print(got[i]+", ");
        }
        System.out.println("]\n"+number+" "+word+" "+non);
    }
}
