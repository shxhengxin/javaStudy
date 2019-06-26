package xin.shenheng.demo04;


public class Synchronized {
    public static void main(String[] args) {
        RunnableTmpl run = new RunnableTmpl();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();

    }
}
