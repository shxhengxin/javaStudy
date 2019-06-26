package xin.shenheng.demo03;

public class Demo01Thread {
    public static void main(String[] args) {
        RunnableTmpl run = new RunnableTmpl();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();

    }
}
