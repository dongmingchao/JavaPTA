/*
* 7-2 jmu-Java-05集合-2-统计一段文字中的单词个数并按单词的字母顺序排序后输出（10 分）
现需要统计若干段文字(英文)中的不同单词数量。并将前10个(按字母顺序)单词输出。
如果所有单词不超过10个，则将所有的单词输出。

注1：单词之间以空格(1个或多个空格)为间隔。
注2：忽略空行或者空格行。

输入说明

若干行英文，最后以!!!!!为结束。

输出说明

单词数量。 然后输出前10个单词（按字母顺序），如果所有单词不超过10个，则将所有的单词输出。

输入样例

Failure is probably the fortification in your pole
It is like a peek your wallet as the thief when you
are thinking how to spend several hard-won lepta
when you are wondering whether new money it has laid
background Because of you, then at the heart of the
most lax alert and most low awareness and left it
godsend failed
!!!!!
输出样例

48
Because
Failure
It
a
alert
and
are
as
at
awareness
* */

package seven;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<String> rec = new TreeSet<>();
        String st;
        while (!(st = in.next()).equals("!!!!!")) {
            rec.add(st);
        }
        System.out.println(rec.size());
        Iterator iterator = rec.iterator();
        for (int i = 0; i < rec.size(); i++) {
            if (i < 10) System.out.println(iterator.next());
        }
    }
}
