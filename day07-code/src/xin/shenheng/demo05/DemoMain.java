package xin.shenheng.demo05;

public class DemoMain {
    public static void main(String[] args) {
       // MyInterface obj = new MyInterfaceImpl();
        //obj.method();
        MyInterface obj = new MyInterface() {
            @Override
            public void method() {
                System.out.println("我来了");
            }
        };
        obj.method();
    }
}
