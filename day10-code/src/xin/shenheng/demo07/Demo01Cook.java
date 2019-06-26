package xin.shenheng.demo07;

public class Demo01Cook {
    public static void main(String[] args) {
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("=====");
            }
        });
        invokeCook(()->{
            System.out.println("=====");
        });
    }

    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
