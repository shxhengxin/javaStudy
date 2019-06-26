package xin.shenheng.jdbc02;

import java.util.Calendar;

public class Demo01Calendar {
    public static void main(String[] args) {

        demo02();
    }

    public static void demo03() {

    }

    public static void demo02() {
        Calendar c = Calendar.getInstance();
       // c.set(Calendar.YEAR,9999);
        c.set(9999,8,8);
        System.out.println(c.get(Calendar.YEAR));
    }

    public static void demo01() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
    }
}
