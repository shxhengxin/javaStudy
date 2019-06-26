package xin.shenheng.jdbc01;

public class Demo01Thread {
    public static void main(String[] args) {
        PrimeThread thread = new PrimeThread();
        thread.start();
        for (int i = 0; i < 21 ; i++) {
            System.out.println("main:" + i);
        }

    }
}
