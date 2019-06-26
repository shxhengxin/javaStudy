package xin.shenheng.demo08;

public class Demo01ObjectMethodReference {

    public static  void  printString(String s,Printable p) {
        p.print(s);
    }

    public static void main(String[] args) {
        printString("abc",(s)->{
            MethodRerObject obj = new MethodRerObject();
            obj.printUpperCaesString(s);
        });
        MethodRerObject obj = new MethodRerObject();
        printString("Hello",obj::printUpperCaesString);
    }
}
