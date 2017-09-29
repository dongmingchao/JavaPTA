/*
判断题
单选题
编程题
7-2 jmu-Java-02基本语法-03-身份证排序（9 分）
输入n，然后连续输入n个身份证号。
据输入的是sort1还是sort2，执行不同的功能。输入的不是sort1或sort2，则输出exit并退出。
输入sort1，将每个身份证的年月日抽取出来，按年-月-日格式组装，然后对组装后的年-月-日升序输出。
输入sort2，将所有身份证按照里面的年月日升序输出。
输入样例:

3
330226196605054190
34080019810819327X
320111197112301539
sort1
sort2
e
输出样例:

1966-05-05
1971-12-30
1981-08-19
330226196605054190
320111197112301539
34080019810819327X
exit
 */





package two;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        String input[] = new String[times];
        for (int i = 0; i < times; i++) {
            input[i]=in.next();
        }
        String suck = in.nextLine();
        Arrays.sort(input,sort);
        while (in.hasNext()) {
            String ask = in.next();
            if (ask.equals("sort2")) {
                for (String s : input) {
                    System.out.println(s);
                }
            } else if (ask.equals("sort1")) {
                for (String s : input) {
                    String year = s.substring(6, 10);
                    String month = s.substring(10, 12);
                    String day = s.substring(12, 14);
                    System.out.println(year + "-" + month + "-" + day);
                }
            } else {
                System.out.println("exit");
                in.close();
                System.exit(0);
            }
        }
    }
    static Comparator<String> sort = (o1, o2) -> {
        if (Integer.parseInt(o1.substring(6,14)) > Integer.parseInt(o2.substring(6,14)))
            return 1;
        else  return -1;
    };
}
