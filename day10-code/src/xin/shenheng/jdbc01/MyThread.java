package xin.shenheng.jdbc01;

public class MyThread extends Thread{
    @Override
    public void run() {
       /* String name = getName();
        System.out.println(name);*/
        Thread t = Thread.currentThread();
        System.out.println(t);

    }
}
