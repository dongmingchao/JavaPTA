/**
 * 7-1 jmu-Java-02基本语法-01-综合小测验（9 分）
 * 主要考察简单函数编写、Arrays的用法、String的截取与拼接。
 * <p>
 * 运行程序后可以输入4个选项，分别为：fib,sort,search,getBirthDate
 * <p>
 * fib:根据输入n，打印斐波那契数列。比如输入：3，输出：1 1 2
 * <p>
 * sort:输入一串数字，然后进行排序，输出。用[]包裹。提示：使用函数
 * <p>
 * search:如果找到返回所找到的位置，如果没找到，返回-1。提示：使用函数
 * <p>
 * getBirthDate:输入n个身份证，然后把输入的n个身份号的年月日抽取出来，组成装年-月-日输出。
 * <p>
 * 当输入不是这几个字符串(fib,sort,search,getBirthDate)的时候，显示exit
 * <p>
 * 参考：jdk文档的Arrays，String
 * <p>
 * 输入格式:
 * <p>
 * fib
 * 3
 * sort
 * -1 10 3 2 5
 * search
 * -1
 * search
 * 0
 * getBirthDate
 * 1
 * 330226196605054190
 * e
 * 输出格式:
 * <p>
 * 1 1 2
 * [-1, 2, 3, 5, 10]
 * 0
 * -1
 * 1966-05-05
 * exit
 */
package two;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer now[] = null;
        while(in.hasNextLine()){
            String ask = in.next();
            if(ask.equals("fib")){
                int n = in.nextInt();
                fib(n);
            }else if (ask.equals("sort")){
                String suck = in.nextLine();
                String n = in.nextLine();
                String input[] = n.split(" |\n");
                now = new Integer[input.length];
                for (int i = 0; i < input.length; i++) {
                    now[i]=Integer.parseInt(input[i]);
                }
                System.out.println(sort(now));
            }else if (ask.equals("search")){
                if (now==null) System.out.println("当前数组空");
                else{
                    int want = in.nextInt();
                    System.out.println(search(now,want));
                }
            }else if(ask.equals("getBirthDate")){
                int n = in.nextInt();
                String input[] = new String[n];
                String suck = in.nextLine();
                for (int i = 0; i < n; i++) {
                    input[i] = in.nextLine();
                }
                Date res[] = getBirthDate(input);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                for (Date date : res) {
                    System.out.println(sdf.format(date));
                }
            }else {
                System.out.println("exit");
                in.close();
                System.exit(0);
            }
        }
    }

    static void print(Integer[] a) {
        System.out.println(Arrays.asList(a));
    }

    static ArrayList sort(Integer input[]) {
        Arrays.sort(input);
        return new ArrayList<>(Arrays.asList(input));
    }

    static int search(Integer[] input, int ele) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ele) return i;
        }
        return -1;
    }

    static Date[] getBirthDate(String[] input) {
        Date[] out = new Date[input.length];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (int i = 0; i < input.length; i++) {
            try {
                out[i] = sdf.parse(input[i].substring(6, 14));
            } catch (ParseException e) {
                System.out.println("转换失败");
                e.printStackTrace();
            }
        }
        return out;
    }

    static void fib(int n) {
        ArrayList<Integer> out = new ArrayList<>(Arrays.asList(1, 1, 2));
        List<Integer> res=null;
        if (n < 4) {
            res=out.subList(0, n);
        } else {
            for (int i = 3; i < n; i++) {
                out.add(out.get(i - 1) + out.get(i - 2));
            }
            res=out;
        }
        for (int i = 0; i < res.size(); i++) {
            if (i==res.size()-1) System.out.println(res.get(i));
            else System.out.print(res.get(i)+" ");
        }
    }
}
