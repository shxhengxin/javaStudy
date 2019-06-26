package xin.shenheng.demo03;


import java.util.Arrays;

public class Demo01System {
    public static void main(String[] args) {
        //jdbc01();
        demo02();
    }
    public static void demo01() {

        long s = System.currentTimeMillis();
        for (int i = 1; i < 9999 ; i++) {
            System.out.println(i);
        }
        long e = System.currentTimeMillis();
        System.out.println(e-s);


    }

    public static void demo02() {
        int[] src = {1,2,3,4,5};
        int[] dest = {6,7,8,9,10};
        System.arraycopy(src,0,dest,0,3);
        System.out.println(Arrays.toString(dest));

    }
}
