package xin.shenheng.demo07;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Demo02Stream_forEach {
    public static void main(String[] args) {
        /*Stream<String> stream = Stream.of("张三", "李四3", "王五", "赵六", "田七");
        Stream<String> stream1 = stream.filter((String name)->{return name.startsWith("张");});
        stream1.forEach(name-> System.out.println(name));*/


        //stream.forEach( name->System.out.println(name));

        //Stream<String> stream = Stream.of("1","2","3","4");
        /*Stream<Integer> stream1 = stream.map((String str) -> {
            return Integer.parseInt(str);
        });
        stream1.forEach(in-> System.out.println(in));*/


        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        Stream<String> oneStream = one.stream().filter(name -> name.length() == 3).limit(3);

        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        Stream<String> twoStream = two.stream().filter(name -> name.startsWith("张")).skip(2);

        Stream.concat(oneStream,twoStream).map(name->new Person(name)).forEach(in-> System.out.println(in));
    }
}
