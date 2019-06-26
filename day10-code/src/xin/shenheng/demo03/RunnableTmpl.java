package xin.shenheng.demo03;

public class RunnableTmpl implements Runnable {
    private  int ticket = 100;

    @Override
    public void run() {

        while (true) {
            //先判断票是否存在
            if(ticket>0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "===>正在卖第" + ticket + "张票");
                ticket--;
            }
        }
    }
}
