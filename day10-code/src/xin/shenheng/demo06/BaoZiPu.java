package xin.shenheng.demo06;

public class BaoZiPu extends Thread{

    private  BaoZi bz;


    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                if(bz.flag == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(count%2 == 0) {
                    //生产薄皮
                    bz.pi = "薄皮";
                    bz.xian = "肉鲜馅";
                }else {
                    bz.pi = "冰皮";
                    bz.xian = "牛肉大葱馅";
                }
                count++;
                System.out.println("包子铺正在生产包子:"+bz.pi + bz.xian + "包子" );

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = true;
                bz.notify();
                System.out.println("包子铺生产好了:"+bz.pi + bz.xian + "包子,可以开始吃了");
            }
        }
    }
}
