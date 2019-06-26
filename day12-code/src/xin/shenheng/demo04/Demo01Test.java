package xin.shenheng.demo04;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo01Test {
    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女","古力娜扎,女","马尔扎哈,男","赵丽颖,女"};
        ArrayList<String> list = method(array, (String str) -> {
            return str.split(",")[1].equals("女");

        }, (String str) -> {
            return str.split(",")[0].length() == 4;
        });
        System.out.println(list);

        for (String s : list) {
            System.out.println(s);
        }

        /*Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        Integer apply = function.apply("23555");
        System.out.println(apply);*/
        change("235555",(s)->Integer.parseInt(s));


    }


    private static void change(String s,Function<String,Integer> fun){
        Integer in = fun.apply(s);
        System.out.println(in);
    }


    private static ArrayList<String>  method(String[] arr, Predicate<String> pre1, Predicate<String> pre2){
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            boolean b = pre1.and(pre2).test(s);
            if(b) {
                list.add(s);
            }
        }
        return  list;
    }
}
