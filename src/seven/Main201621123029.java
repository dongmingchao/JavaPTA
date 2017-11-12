//编写函数判断一个给定字符串是否是回文，
//一定要使用栈(请利用Java集合中已有的类)
// 但不能使用java的Stack类（具体原因自己搜索）与数组。
// 请粘贴你的代码，类名为Main你的学号。
package seven;

import java.util.*;
import java.util.function.Consumer;

public class Main201621123029 {

    private LinkedList storeList;

    public Main201621123029(LinkedList in) {
        storeList = in;
    }

    public Main201621123029(String in) {
        storeList = new LinkedList();
        for (int i = 0; i < in.length(); i++) storeList.push(in.charAt(i));
    }

    Object peek() {
        if (storeList.peek() instanceof Character)
            return (Character) storeList.peek();
        else return storeList.peek();
    }

    Main201621123029 push(Object object) {
        storeList.push(object);
        return this;
    }

    Main201621123029 push(String s) {
        storeList.addAll(Arrays.asList(s.toCharArray()));
        return this;
    }

    Main201621123029 pop(Consumer consumer) {
        if (storeList.size() < 1) return this;
        consumer.accept(storeList.pop());
        return this;
    }

    Main201621123029 forEach(Consumer action) {
        Objects.requireNonNull(action);
        @SuppressWarnings("unchecked") final LinkedList elementData = this.storeList;
        final int size = storeList.size();
        for (int i = 0; i < size; i++) {
            action.accept(elementData.get(i));
        }
        return this;
    }

    public static void main(String[] args) {
        String left = "cbc";
        String right = left;
        Main201621123029 tt = new Main201621123029(left);
        final int[] sum = {0};
        for (char e : right.toCharArray())
            tt.pop(each -> {
                if (each.equals(e)) sum[0]++;
            });
        if (sum[0] == right.length()) System.out.println("回文");
    }
}
