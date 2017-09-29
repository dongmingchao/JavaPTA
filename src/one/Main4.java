package one;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble())
            calc(in.nextDouble(),0.0001,0.00001);
    }
    public static void calc(double x,double step,double epsilon){
        if (x<0) System.out.println("NaN");
        else {
            if (x>4) {
                double n = x / 2;
                while ((n * n - x) > epsilon) {
                    n -= step;
                }
                System.out.printf("%.6f\n", n);
            }else if( x == 4 ) {
                System.out.printf("%.6f\n",2.0);
            }else{
                double n = x / 2;
                while (( x - n * n) > epsilon) {
                    n += step;
                }
                System.out.printf("%.6f\n",n);
            }
        }
    }
}