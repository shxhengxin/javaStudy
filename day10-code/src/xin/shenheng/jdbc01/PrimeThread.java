package xin.shenheng.jdbc01;

public class PrimeThread extends Thread {
    @Override
    public void run() {
        //super.run();
        for (int i = 0; i < 20 ; i++) {
            System.out.println("run:" + i);
        }
    }
}
