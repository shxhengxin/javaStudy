package xin.shenheng.jdbc01;

public class Demo {
    public static void main(String[] args) {
        show(new MyFunctionalInterfaceTmpl());
        show(()->{
            System.out.println("1111111111111111");
        });
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("55555555555555");
            }
        });

        show(()->System.out.println("1111111111111111"));

    }

    private static void show(MyFunctionalInterface myInter) {
        myInter.method();
    }
}
