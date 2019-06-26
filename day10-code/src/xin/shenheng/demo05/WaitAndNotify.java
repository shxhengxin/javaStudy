package xin.shenheng.demo05;

public class WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        demo01(obj);
        demo02(obj);






    }


    private static void demo01(Object obj) {
        new Thread(){
            @Override
            public void run() {
                while (true) {

                    synchronized (obj) {
                        System.out.println("告知老板包子的数量和种类");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子做好了，开吃");
                        System.out.println("===================");
                    }
                }
            }
        }.start();
    }

    private static void demo02(Object obj){
        new Thread(){
            @Override
            public void run() {
               while (true) {
                   try {
                       Thread.sleep(5000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   synchronized (obj) {
                       System.out.println("老板做包子，叫醒客人");
                       obj.notify();
                   }
               }
            }
        }.start();
    }


}
