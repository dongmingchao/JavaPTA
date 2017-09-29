import java.math.BigDecimal;
import java.util.Scanner;

public class getNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        turn(in.nextLine());
//        printDigit(in.nextInt());

    }

    public static void turn(String come) {
        char c[] = come.toCharArray();
        int res = 0;
        for (char e : c) {
            if (Character.isDigit(e)) {
                res += e - '0';
            }
        }
        System.out.println(res);
    }

    public static int[] change(String come) {
        char numarry[] = come.toCharArray();
        int res[] = new int[numarry.length];
        for (int i = 0; i < numarry.length; i++) {
            res[i] = numarry[i] - '0';
        }
        return res;
    }

    public static void printDigit(int n) {
        int input[] = getDigits(n);
        int sum = 0;
        for (int each : input) {
            System.out.print(each + " ");
            sum += each;
        }
        System.out.println(sum);
    }

    public static int[] getDigits(int n) {
        return change(String.valueOf(n));
    }
}
