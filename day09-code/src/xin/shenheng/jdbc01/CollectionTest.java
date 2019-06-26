package xin.shenheng.jdbc01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
    public static void main(String[] args) {
        Collection<Student> c = new ArrayList<>();
        Student s1 = new Student("林青霞",30);
        Student s2 = new Student("张曼玉",35);
        Student s3 = new Student("王祖贤",33);
        c.add(s1);
        c.add(s2);
        c.add(s3);

        System.out.println(((ArrayList<Student>) c).get(1).getName());

        for (int i = 0; i < c.size(); i++) {
            System.out.println(((ArrayList<Student>) c).get(i).getName() + "==" + ((ArrayList<Student>) c).get(i).getAge());
        }



        System.out.println("===============");

        Iterator<Student> it = c.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s.getName() + "========" + s.getAge());
        }
    }
}
