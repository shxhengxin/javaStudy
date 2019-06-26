package xin.shenheng.demo07;

public class DemoGame {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("小汪");

        SKill sKill = new SKill() {
            @Override
            public void use() {
                System.out.println("1111");
            }
        };
        hero.setsKill(sKill);
        hero.attack();
    }
}
