package xin.shenheng.jdbc01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("hello");
        c.add("world");
        c.add("java");
        System.out.println(c.size());
        System.out.println(c);

        System.out.println("=====================");
        //判断集合是否存在该元素
        System.out.println(c.contains("hello"));//true
        System.out.println(c.contains("hello1"));//false
        System.out.println("=============");
        //判断集合是否为空
        //c.clear();
        System.out.println(c.size());
        System.out.println(c.isEmpty());//有元素返回false，否则反之


        //遍历集合
        System.out.println("=====================");
        Iterator<String> it = c.iterator();
        System.out.println(it);
        System.out.println(it.next());
        System.out.println("=============");
        while (it.hasNext()) {
            System.out.println(it.next());
        }


    }
}
