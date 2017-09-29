/*
*
* 7-5 jmu-Java-03面向对象基础-05-覆盖（3 分）
Java每个对象都继承自Object,都有equals、toString方法。我们现在需要新建PersonOverride类覆盖其toString与equals方法。

1. 新建PersonOverride类

a. 新建PersonOverride类，属性为：String name、boolean gender、int age，所有的变量必须为私有(private)。

b. 编写一有参构造函数，参数为name, age, gender

c. 编写一无参构造函数，使用this(name, age,gender)调用有参构造函数。参数值分别为default,1,true

d.toString方法返回格式为：name-age-gender

e. equals方法需要比较name、age、gender，这三者都相同，才返回true.

2. main方法

2.1 输入n1，使用无参构造函数创建n1个对象，放入数组persons1。
2.2 输入n2，然后指定name age gender。每创建一个对象都使用equals方法比较该对象是否已经在数组中存在，如果存在，则不将该对象放入数组persons2。
2.3 输出persons1数组中的所有对象
2.4 输出persons2数组中的所有对象
2.5 输出persons2中实际包含的对象的数量
2.5 使用System.out.println(Arrays.toString(PersonOverride.class.getConstructors()));输出PersonOverride的所有构造函数。

输入样例:

1
3
zhang 10 true
zhang 10 true
zhang 10 false
输出样例:

default-1-true
zhang-10-true
zhang-10-false
2
[public PersonOverride(), public PersonOverride(java.lang.String,int,boolean)]
 */


package three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        ArrayList<PersonOverride> p1 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            p1.add(new PersonOverride());
        }
        len = in.nextInt();
        ArrayList<PersonOverride> p2 = new ArrayList<>();
        in.nextLine();
        for (int i = 0; i < len; i++) {
            String[] input = in.nextLine().split(" ");
            PersonOverride temp = new PersonOverride(input[0], Integer.parseInt(input[1]), Boolean.parseBoolean(input[2]));
            if (!p2.contains(temp)) p2.add(temp);
        }
        for (PersonOverride personOverride : p1) {
            System.out.println(personOverride);
        }
        for (PersonOverride personOverride : p2) {
            System.out.println(personOverride);
        }
        System.out.println(p2.size());
        System.out.println(Arrays.toString(PersonOverride.class.getConstructors()));
    }
}

class PersonOverride {
    private String name;
    private boolean gender;
    private int age;

    public PersonOverride() {
        this("default", 1, true);
    }

    public PersonOverride(String name, int age, boolean gender) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "-" + age + "-" + gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonOverride that = (PersonOverride) o;

        if (gender != that.gender) return false;
        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }
}