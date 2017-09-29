/*
*
* 7-6 jmu-Java-03面向对象-06-继承覆盖综合练习-Person、Student、Employee、Company（20 分）
有Person抽象类，Student类、Company类，Employee类。

Person类属性：String name, int age, boolean gender
Person类方法:

public Person(String name, int age, boolean gender);
public String toString();//返回`name-age-gender`格式的字符串
public boolean equals(Object obj);//比较name、age、gender,都相同返回true;
Student类继承自Person，属性:String stuNo, String clazz
Student类方法:

//建议使用super复用Person类的相关有参构造函数
public Student(String name, int age, boolean gender, String stuNo, String clazz);
public String toString();//返回 “Student:person的toString-stuNo-clazz”格式的字符串
public boolean equals(Object obj);//首先调用父类的equals方法,如果返回true，则比较stuNo与clazz.
Company类属性：String name
Company类方法:

public Company(String name);
public String toString();//直接返回name
public boolean equals(Object obj);//name相同返回true
Employee类继承自Person，属性：Company company, double salary
Employee类方法：

//建议使用super复用Person类的相关有参构造函数
public Employee(String name, int age, boolean gender, double salary, Company company);
public String toString();//返回“Employee:person的toString-company-salary“格式的字符串
public boolean equals(Object obj);//首先调用父类的equals方法,如果返回true。再比较company与salary。
//比较salary属性时，使用DecimalFormat df = new DecimalFormat("#.#");保留1位小数
编写equals方法重要说明：

对Employee的company属性的比较。要考虑传入为null的情况。如果company不为null且传入为null，返回false
对所有String字符类型比较时，也要考null情况。
提示

排序可使用Collections.sort
equals方法要考虑周全
main方法说明

创建若干Student对象、Employee对象。
输入s，然后依次输入name age gender stuNo clazz创建Student对象。
输入e，然后依次输入name age gender salary company创建Employee对象。
输入其他字符，则结束创建。将创建好的对象放入personList。
创建说明:对于String类型，如果为null则不创建对象，而赋值为null。对于company属性，如果为null则赋值为null，否则创建相应的Company对象。

对personList先按照姓名排序，姓名相同按照年龄排序。

接受输入，如果输入为exit则return;退出程序，否则继续下面步骤。

将personList中的元素按照类型分别放到stuList与empList

输出字符串stuList，然后输出stuList中的每个对象。

输出字符串empList，然后输出empList中的每个对象。

1-3为一个测试点 4-6为一个测试点

输入样例：

s zhang 23 false 001 net15
e wang 18 true 3000.51 IBM
s zhang 23 false 001 net15
e bo 25 true 5000.51 IBM
e bo 25 true 5000.52 IBM
e bo 18 true 5000.54 IBM
e tan 25 true 5000.56 IBM
e tan 25 true 5000.51 IBM
s wang 17 false 002 null
s wang 17 false 002 null
e hua 16 false 1000 null
s wang 17 false 002 net16
e hua 16 false 1000 null
e hua 18 false 1234 MicroSoft
!
continue
输出样例：

Employee:bo-18-true-IBM-5000.54
Employee:bo-25-true-IBM-5000.51
Employee:bo-25-true-IBM-5000.52
Employee:hua-16-false-null-1000.0
Employee:hua-16-false-null-1000.0
Employee:hua-18-false-MicroSoft-1234.0
Employee:tan-25-true-IBM-5000.56
Employee:tan-25-true-IBM-5000.51
Student:wang-17-false-002-null
Student:wang-17-false-002-null
Student:wang-17-false-002-net16
Employee:wang-18-true-IBM-3000.51
Student:zhang-23-false-001-net15
Student:zhang-23-false-001-net15
stuList
Student:wang-17-false-002-null
Student:wang-17-false-002-net16
Student:zhang-23-false-001-net15
empList
Employee:bo-18-true-IBM-5000.54
Employee:bo-25-true-IBM-5000.51
Employee:hua-16-false-null-1000.0
Employee:hua-18-false-MicroSoft-1234.0
Employee:tan-25-true-IBM-5000.56
Employee:tan-25-true-IBM-5000.51
Employee:wang-18-true-IBM-3000.51
 */


package three;


import java.text.DecimalFormat;
import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> personArrayList = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        boolean jump = false;
        while (true) {
            String ask = in.nextLine();
            String[] input = ask.split(" ");
            switch (input[0]) {
                case "s":
                    Student student = new Student(input[1], Integer.parseInt(input[2]), Boolean.parseBoolean(input[3]), input[4], input[5]);
                    personArrayList.add(student);
                    if (!students.contains(student))students.add(student);
                    break;
                case "e":
                    Employee employee = new Employee(input[1], Integer.parseInt(input[2]), Boolean.parseBoolean(input[3]), Double.valueOf(input[4]), new Company(input[5]));
                    personArrayList.add(employee);
                    if (!employees.contains(employee))employees.add(employee);
                    break;
                default:
                    jump = true;
            }
            if (jump) break;
        }
        Comparator<Person> byName = (o1, o2) -> {
            if (o1.name.equals(o2.name)) {
                if (o1.age > o2.age) return  1;
                if (o1.age == o2.age) return  0;
                return  -1;
            }
            else return o1.name.compareTo(o2.name);
        };
        Collections.sort(personArrayList, byName);
        for (Person person : personArrayList) {
            System.out.println(person);
        }

        if (!Objects.equals(in.nextLine(), "exit")) {

            Collections.sort(students, byName);
            Collections.sort(employees, byName);
            System.out.println("stuList");
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println("empList");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }else return;
    }
}

class Person {
    String name;
    int age;
    boolean gender;

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + "-" + age + "-" + gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (gender != person.gender) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

}

class Student extends Person {
    String stuNo;
    String clazz;

    public Student(String name, int age, boolean gender, String stuNo, String clazz) {
        super(name, age, gender);
        this.stuNo = stuNo;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student:" + super.toString() + "-" + stuNo + "-" + clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (stuNo != null ? !stuNo.equals(student.stuNo) : student.stuNo != null) return false;
        return clazz != null ? clazz.equals(student.clazz) : student.clazz == null;
    }

}

class Company {
    String name;

    public Company(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        return name != null ? name.equals(company.name) : company.name == null;
    }

}

class Employee extends Person {
    double salary;
    Company company;

    public Employee(String name, int age, boolean gender, double salary, Company company) {
        super(name, age, gender);
        this.salary = salary;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee:"+super.toString()+"-" + company.toString() + "-" + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;
        DecimalFormat df = new DecimalFormat("#.#");
        if (!df.format(employee.salary).equals(df.format(salary))) return false;
        return company != null ? company.equals(employee.company) : employee.company == null;
    }

}