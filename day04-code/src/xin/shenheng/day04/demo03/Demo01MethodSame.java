package xin.shenheng.day04.demo03;

public class Demo01MethodSame {
    public static void main(String[] args) {
        System.out.println(isSame(10,100));
        System.out.println(isSame(100,100));
    }
    public static boolean isSame(int a,int b) {
        return a == b ;
    }
}
