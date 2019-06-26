package xin.shenheng.demo06;

import java.util.function.Function;

public class Demo01Function_andThen {
    public static void main(String[] args) {
        String s = "120";
        /*System.out.println(s);
        Integer integer = string_integer(s, (str) -> Integer.parseInt(str));
        System.out.println(integer);

        String s1 = integer_string(integer, (in) -> Integer.toString(in));
        System.out.println(s1);*/

        String check = check(s, (str) -> Integer.parseInt(str) + 10, (in) ->  in+"");
        System.out.println(check);


    }

    private static String check(String s,Function<String,Integer> fun1,Function<Integer,String> fun2){
        String s1 = fun1.andThen(fun2).apply(s);
        return s1;
    };


    private static Integer string_integer(String s, Function<String,Integer> fun){
        Integer in = fun.apply(s);
        in = in+10;
        return  in;

    }

    private static String integer_string(Integer integer,Function<Integer,String> fun){
        String s = fun.apply(integer);
        return s;
    }


}
