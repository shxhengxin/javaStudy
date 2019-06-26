package xin.shenheng.day04.demo02;

/**
 *
 */
public class Demo02MethodDefine {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(sum(2,3));

        System.out.printf("1");

    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static int sum(int a,int b) {
        System.out.println("==============");
        int result = a + b ;
        return  result;
    }


}
