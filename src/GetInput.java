import java.util.Scanner;
public class GetInput {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Double here[] = new Double[2];
        here[0] = in.nextDouble();
        here[1] = in.nextDouble();
        System.out.println(here[0]+here[1]);
    }
}
