package xin.shenheng.demo09;

public class DemoMain {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();

        //向上进行转型
        USB usbMouse = new Mouse();
        computer.useDevice(usbMouse);


        USB usbKeyboard = new Keyboard();
        computer.useDevice(usbKeyboard);


        computer.powerOff();




    }
}
