/*
create
2 zheng 15
1
equal
1 wang 15
1 WANG 14
equal
2
2
equal
1 li 15
2 li 15
equal
2
2 fang 15
end
 */

package four;

import java.util.Scanner;

public class Examf2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = null;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            switch (line) {
                case "end":
                    return;
                case "create":
                    students = createStudents(sc);
                    for (Student e : students) {
                        System.out.println(e);
                    }
                    break;
                case "equal":
                    students = createStudents(sc);
                    System.out.println(students[0].equals(students[1]));
                    break;
                default:
                    break;
            }
        }
        sc.close();

    }

    private static Student[] createStudents(Scanner sc) {
        Student[] students = new Student[2];
        for (int i = 0; i < students.length; i++) {
            String line = sc.nextLine();
            if(line.length()==1)
                students[i] = new Student(Integer.parseInt(line));
            else{
                String[] strs = line.split(" ");
                students[i] = new Student(Integer.parseInt(strs[0]),strs[1],Integer.parseInt(strs[0]));
            }
        }
        return students;
    }
}
class Student{
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        System.out.println("Student("+id+", "+name+", "+age+") invoked");
    }

    public Student(int id) {
        this(id,null,0);
        System.out.println("Student("+id+" invoked) ");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        return name != null ? name.toUpperCase().equals(student.name.toUpperCase()) : student.name == null;
    }
}