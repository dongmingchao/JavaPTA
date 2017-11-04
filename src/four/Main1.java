package four;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        PersonSortable[] persons = new PersonSortable[n];
        for (int i=0;i<persons.length;i++) {
            in.nextLine();
            String name = in.next();
            int age = in.nextInt();
            persons[i] = new PersonSortable(name,age);
        }
        Arrays.sort(persons);
        for (PersonSortable person : persons) {
            System.out.println(person);
        }
        System.out.println(Arrays.toString(PersonSortable.class.getInterfaces()));
    }
}
class PersonSortable implements Comparable{
    private String name;
    private int age;

    @Override
    public String toString() {
        return name + "-" + age;
    }

    public PersonSortable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        PersonSortable personSortable = (PersonSortable) o;
        if (name.equals(personSortable.name)){
            return age - personSortable.age;
        }else{
            return name.compareTo(personSortable.name);
        }
    }
}