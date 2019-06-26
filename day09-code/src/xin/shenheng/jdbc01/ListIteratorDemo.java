package xin.shenheng.jdbc01;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        ListIterator<String> lit = list.listIterator();

        while(lit.hasNext()){
			String s = lit.next();
			System.out.println(s);
        }
        System.out.println("--------------------------");



        System.out.println(lit.hasPrevious());
        while (lit.hasPrevious()) {

            String s = lit.previous();
            System.out.println(s);

        }
    }
}
