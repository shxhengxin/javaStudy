package xin.shenheng.demo03;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo01Supplier {
    public static void main(String[] args) {
        //String string = getString(() -> "111111");
        //System.out.println(string);

        //method("李晓晨",(String name)->System.out.println(name));

        method("李晓晨",(String name)->{
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);

        });
    }

    public static String getString(Supplier<String> supplier){
        return supplier.get();
    }

    public static  void method(String name , Consumer<String> con) {
        con.accept(name);
    }
}
