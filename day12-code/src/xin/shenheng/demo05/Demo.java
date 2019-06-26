package xin.shenheng.demo05;

public class Demo {
    private static  String[] names = {"bill","hill","jill"};

    public static void main(String[] args) {
        try{
            checkUsername("bill");
            System.out.println("注册成功了");
        }catch (RegisterException e){
            e.printStackTrace();
        }
    }

    private static boolean checkUsername(String uname) throws RegisterException {
        for (String name : names) {
            if(name.equals(uname)) {
                throw new RegisterException("亲"+name+"已经被注册了！");
            }
        }
        return  true;
    }

}
