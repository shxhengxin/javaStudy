package xin.shenheng.demo06;

public class Demo {
    public static void main(String[] args) {
        BaoZi bz = new BaoZi();


        new BaoZiPu(bz).start();
        new ChiHuo(bz).start();

    }
}
