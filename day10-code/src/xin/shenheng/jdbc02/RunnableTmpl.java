package xin.shenheng.jdbc02;

public class RunnableTmpl implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=20 ; i++) {


            System.out.println("holle word" + i);
        }
    }
}
