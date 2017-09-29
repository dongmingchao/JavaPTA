package one;
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine())
            calc(in.nextLine());
        in.close();
    }
    public static void calc(String s){
        int result=Integer.parseInt(s);
        if (result>=10000&&result<=20000){
            System.out.println(Integer.toBinaryString(result)+","+Integer.toOctalString(result)+","+Integer.toHexString(result));
        }else{
            char convert[]=s.toCharArray();
            int sum=0;
            for (char each:convert) {
                if (Character.isDigit(each)){
                    int c=each-'0';
                    System.out.print(c+" ");
                    sum+=c;
                }
            }
            System.out.println(sum);
        }
    }
}