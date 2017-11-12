/*7-6 银行业务队列简单模拟（5 分）
设某银行有A、B两个业务窗口，且处理业务的速度不一样，其中A窗口处理速度是B窗口
的2倍 —— 即当A窗口每处理完2个顾客时，B窗口处理完1个顾客。给定到达银行的顾客
序列，请按业务完成的顺序输出顾客序列。假定不考虑顾客先后到达的时间间隔，并且
当不同窗口同时处理完2个顾客时，A窗口顾客优先输出。

输入格式:

输入为一行正整数，其中第1个数字N(≤1000)为顾客总数，后面跟着N位顾客的编号。
编号为奇数的顾客需要到A窗口办理业务，为偶数的顾客则去B窗口。数字间以空格分隔。

输出格式:

按业务处理完成的顺序输出顾客的编号。数字间以空格分隔，但最后一个编号后不能有
多余的空格。

输入样例:

8 2 1 3 9 4 11 13 15
输出样例:

1 3 2 9 11 4 13 15*/

package seven;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        deal(in.nextLine());
    }

    private static void deal(String in) {
        String[] ask = in.split(" ");
        Queue<Integer> odd = new ArrayDeque<>();
        Queue<Integer> even = new ArrayDeque<>();
        for (int i = 1; i < ask.length; i++) {
            int got = Integer.valueOf(ask[i]);
            if (got % 2 == 0) even.offer(got);
            else odd.offer(got);
        }
//        System.out.println(odd);
//        System.out.println(even);
        int length = odd.size() + even.size();
        for (int i = 0; i < length; i++) {
            if (odd.isEmpty()) System.out.print(even.poll());
            else if (even.isEmpty()) System.out.print(odd.poll());
            else {
                switch (i % 3) {
                    case 0:
                        System.out.print(odd.poll());
                        break;
                    case 1:
                        System.out.print(odd.poll());
                        break;
                    case 2:
                        System.out.print(even.poll());
                        break;
                }
            }
            if (i != length - 1) System.out.print(' ');
        }
    }
}
