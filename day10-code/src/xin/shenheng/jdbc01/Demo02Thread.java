package xin.shenheng.jdbc01;

public class Demo02Thread {
    public static void main(String[] args) {
        demo02();
    }

    private static void demo02() {
        for (int i = 1; i <= 60 ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void demo01() {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("================");
        MyThread myThrea = new MyThread();
        myThrea.start();
        new MyThread().start();

    }
}
